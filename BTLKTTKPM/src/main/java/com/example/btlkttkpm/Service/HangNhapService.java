package com.example.btlkttkpm.Service;

import com.example.btlkttkpm.Dto.HangNhapDto;
import com.example.btlkttkpm.Dto.HoaDonNhapDto;
import com.example.btlkttkpm.Dto.NguyenLieuDto;
import com.example.btlkttkpm.Model.HangNhap;
import com.example.btlkttkpm.Model.HoaDonNhap;
import com.example.btlkttkpm.Model.NguyenLieu;
import com.example.btlkttkpm.Repository.HangNhapRepository;
import com.example.btlkttkpm.Repository.HoaDonNhapRepository;
import com.example.btlkttkpm.Repository.NguyenLieuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class HangNhapService {
    @Autowired
    private HangNhapRepository hangNhapRepository;
    @Autowired
    private HoaDonNhapRepository hoaDonNhapRepository;
    @Autowired
    private NguyenLieuRepository nguyenLieuRepository;

    private HangNhapDto convertToDto(HangNhap hangNhap) {
        HangNhapDto hangNhapDto=new HangNhapDto();
        hangNhapDto.setId(hangNhap.getId());
        hangNhapDto.setGia(hangNhap.getGia());
        hangNhapDto.setSoluong(hangNhap.getSoluong());
        hangNhapDto.setTennguyenlieu(hangNhap.getNguyenlieu().getTen());
        hangNhapDto.setHoadonnhap_id(hangNhap.getHoadonnhap().getId());
        hangNhapDto.setNguyenlieu_id(hangNhap.getNguyenlieu().getId());
        return hangNhapDto;
    }

    public void add(HangNhapDto hangNhapDto){
        HangNhap hangNhap=new HangNhap();
        HoaDonNhap hoaDonNhap=hoaDonNhapRepository.findHoaDonNhapById(hangNhapDto.getHoadonnhap_id());
        NguyenLieu nguyenLieu=nguyenLieuRepository.findNguyenLieuById(hangNhapDto.getNguyenlieu_id());
        hangNhap.setGia(hangNhapDto.getGia());
        hangNhap.setHoadonnhap(hoaDonNhap);
        hangNhap.setSoluong(hangNhapDto.getSoluong());
        hangNhap.setNguyenlieu(nguyenLieu);
        hangNhapRepository.save(hangNhap);
    }
    public List<HangNhapDto> getAllHNByHDN(int id){
        List<HangNhap> hangNhaps=hangNhapRepository.findAllByHoadonnhap_Id(id);
        List<HangNhapDto> hangNhapDtos = hangNhaps.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return hangNhapDtos;
    }
}
