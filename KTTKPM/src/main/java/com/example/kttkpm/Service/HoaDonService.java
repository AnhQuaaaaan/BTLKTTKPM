package com.example.kttkpm.Service;

import com.example.kttkpm.DTO.HoaDonDto;
import com.example.kttkpm.DTO.NguoiDungDto;
import com.example.kttkpm.Entity.HoaDon;
import com.example.kttkpm.Entity.NguoiDung;
import com.example.kttkpm.Entity.NhapHang;
import com.example.kttkpm.Repository.HoaDonRepository;
import com.example.kttkpm.Repository.NguoiDungRepository;
import com.example.kttkpm.Repository.NhapHangRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Autowired
    private NhapHangRepository nhapHangRepository;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    public void save(HoaDonDto hoaDonDto){
        System.out.println(hoaDonDto.getId());
        NguoiDung nguoiDung=nguoiDungRepository.findNguoiDungById(hoaDonDto.getNguoidungid());
        NhapHang nhapHang=nhapHangRepository.findNhapHangById(hoaDonDto.getId());
        HoaDon hoaDon=new HoaDon();
        hoaDon.setNgayxuatdon(hoaDonDto.getNgayxuatdon());
        hoaDon.setTongtien(hoaDonDto.getTongtien());
        hoaDon.setMota(hoaDonDto.getMota());
        hoaDon.setNhaphang(nhapHang);
        hoaDon.setNguoidung(nguoiDung);
        hoaDonRepository.save(hoaDon);
    }
}
