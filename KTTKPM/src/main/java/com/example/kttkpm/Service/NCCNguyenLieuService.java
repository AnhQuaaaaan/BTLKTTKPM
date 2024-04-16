package com.example.kttkpm.Service;

import com.example.kttkpm.DTO.NCCNguyenLieuDto;
import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.Entity.NCCNguyenLieu;
import com.example.kttkpm.Entity.NguyenLieu;
import com.example.kttkpm.Entity.NhaCungCap;
import com.example.kttkpm.Repository.NCCNguyenLieuRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NCCNguyenLieuService {
    @Autowired
    private NCCNguyenLieuRepository nccNguyenLieuRepository;
    @Autowired
    private NguyenLieuService nguyenLieuService;
    @Autowired
    private NhaCungCapService nhaCungCapService;
    private NCCNguyenLieuDto convertToDto(NCCNguyenLieu nccNguyenLieu) {
        NCCNguyenLieuDto dto=new NCCNguyenLieuDto();
        dto.setId(nccNguyenLieu.getId());
        dto.setTennguyenlieu(nccNguyenLieu.getNguyenlieu().getTen());
        dto.setTennhacungcap(nccNguyenLieu.getNhacungcap().getTen());
        dto.setDongia(nccNguyenLieu.getDongia());
        dto.setSoluong(nccNguyenLieu.getSoluong());
        return dto;
    }

    public List<NCCNguyenLieuDto> getAll(){
        List<NCCNguyenLieu> nccNguyenLieus=nccNguyenLieuRepository.findAll();
        List<NCCNguyenLieuDto> nccNguyenLieuDtos = nccNguyenLieus.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return  nccNguyenLieuDtos;
    }
    public void update(NCCNguyenLieuDto nccNguyenLieuDto){
        NguyenLieu nguyenLieu= nguyenLieuService.findNguyenLieuByTen(nccNguyenLieuDto.getTennguyenlieu());
        NhaCungCap nhaCungCap=nhaCungCapService.findNhaCungCapByTen(nccNguyenLieuDto.getTennhacungcap());
        if (nguyenLieu == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nguyên Liệu Không Tồn Tại. Vui Lòng Thêm Mới");
        }
        else if (nhaCungCap == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nhà Cung Cấp Không Tồn Tại. Vui Lòng Thêm Mới");
        }
        else{ 
            NCCNguyenLieu nccNguyenLieu= nccNguyenLieuRepository.findNCCNguyenLieuById(nccNguyenLieuDto.getId());
            nccNguyenLieu.setDongia(nccNguyenLieuDto.getDongia());
            nccNguyenLieu.setSoluong(nccNguyenLieuDto.getSoluong());
            nccNguyenLieu.setNguyenlieu(nguyenLieu);
            nccNguyenLieu.setNhacungcap(nhaCungCap);
            nccNguyenLieuRepository.save(nccNguyenLieu);
        }

    }
    public void delete(int id){
        System.out.println(id);
        nccNguyenLieuRepository.deleteById(id);
    }
}
