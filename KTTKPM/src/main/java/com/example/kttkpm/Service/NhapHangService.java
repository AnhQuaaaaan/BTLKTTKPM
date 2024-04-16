package com.example.kttkpm.Service;

import com.example.kttkpm.DTO.NhapHangDto;
import com.example.kttkpm.Entity.*;
import com.example.kttkpm.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class NhapHangService {
    @Autowired
    private NhapHangRepository nhapHangRepository;
    @Autowired
    private CuaHangRepository cuaHangRepository;
    @Autowired
    private NCCNguyenLieuRepository nccNguyenLieuRepository;
    @Autowired
    private NguyenLieuRepository nguyenLieuRepository;
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    public NhapHangDto save(NhapHangDto nhapHangDto){
            CuaHang cuaHang=cuaHangRepository.findCuaHangById(nhapHangDto.getCuahangid());
            NguoiDung nguoiDung=nguoiDungRepository.findNguoiDungById(nhapHangDto.getNguoidungid());
            NguyenLieu nguyenLieu=nguyenLieuRepository.findNguyenLieuById(nhapHangDto.getNguyenlieuid());
            NhaCungCap nhaCungCap=nhaCungCapRepository.findNhaCungCapById(nhapHangDto.getNhacungcapid());
            NCCNguyenLieu nccNguyenLieu=new NCCNguyenLieu();
            nccNguyenLieu.setNguyenlieu(nguyenLieu);
            nccNguyenLieu.setNhacungcap(nhaCungCap);
            nccNguyenLieu.setSoluong(nhapHangDto.getSoluong());
            nccNguyenLieu.setDongia(nhapHangDto.getDongia());
            nccNguyenLieuRepository.save(nccNguyenLieu);


            NhapHang nhapHang=new NhapHang();
            nhapHang.setMota(nhapHangDto.getMota());
            nhapHang.setCuahang(cuaHang);
            nhapHang.setNgaynhap(nhapHangDto.getNgaynhap());
            nhapHang.setNccnguyenlieu(nccNguyenLieu);
            nhapHangRepository.save(nhapHang);

            NhapHangDto nhapHangDto1=new NhapHangDto();
            nhapHangDto1.setId(nhapHang.getId());
            nhapHangDto1.setNgaynhap(nhapHang.getNgaynhap());
            nhapHangDto1.setTencuahang(nhapHang.getCuahang().getTen());
            nhapHangDto1.setTennhanvien(nguoiDung.getUsername());
            nhapHangDto1.setTennguyenlieu(nguyenLieu.getTen());
            nhapHangDto1.setTennhacungcap(nhaCungCap.getTen());
            nhapHangDto1.setTongtien(nhapHangDto.getSoluong()* nhapHangDto.getDongia());
            nhapHangDto1.setMota(nhapHang.getMota());
            return nhapHangDto1;
        }
    }
