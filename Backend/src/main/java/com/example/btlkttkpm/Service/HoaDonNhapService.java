package com.example.btlkttkpm.Service;

import com.example.btlkttkpm.Dto.HoaDonNhapDto;
import com.example.btlkttkpm.Dto.NguyenLieuDto;
import com.example.btlkttkpm.Dto.NhaCungCapDto;
import com.example.btlkttkpm.Model.*;
import com.example.btlkttkpm.Repository.HangNhapRepository;
import com.example.btlkttkpm.Repository.HoaDonNhapRepository;
import com.example.btlkttkpm.Repository.NhaCungCapRepository;
import com.example.btlkttkpm.Repository.NhanVienKhoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class HoaDonNhapService {
    @Autowired
    private HoaDonNhapRepository hoaDonNhapRepository;
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;
    @Autowired
    private NhanVienKhoRepository nhanVienKhoRepository;
    @Autowired
    private HangNhapRepository hangNhapRepository;
    private HoaDonNhapDto convertToDto(HoaDonNhap hoaDonNhap) {
        ModelMapper modelMapper=new ModelMapper();
        HoaDonNhapDto hoaDonNhapDto=modelMapper.map(hoaDonNhap,HoaDonNhapDto.class);
        return hoaDonNhapDto;
    }
    private HoaDonNhapDto convertToAllDto(HoaDonNhap hoaDonNhap) {
        HoaDonNhapDto hoaDonNhapDto=new HoaDonNhapDto();
        hoaDonNhapDto.setTongtien(hoaDonNhap.getTongtien());
        hoaDonNhapDto.setId(hoaDonNhap.getId());
        hoaDonNhapDto.setNgayxuatdon(hoaDonNhap.getNgayxuatdon());
        hoaDonNhapDto.setTennv(hoaDonNhap.getNhanvienkho().getTen());
        hoaDonNhapDto.setTenncc(hoaDonNhap.getNhacungcap().getTen());
        return hoaDonNhapDto;
    }

    public HoaDonNhapDto NewHoaDonNhap(int id){
        NhanVienKho nhanVienKho=nhanVienKhoRepository.findNhanVienKhoById(1);
        HoaDonNhap hoaDonNhap=new HoaDonNhap();
        NhaCungCap nhaCungCap=nhaCungCapRepository.findNhaCungCapById(id);
        hoaDonNhap.setNhacungcap(nhaCungCap);
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        hoaDonNhap.setNgayxuatdon(LocalDate.now().format(formatter));
        hoaDonNhap.setNhanvienkho(nhanVienKho);
        hoaDonNhapRepository.save(hoaDonNhap);
        return convertToDto(hoaDonNhap);
    }
    public HoaDonNhapDto getHoaDonNhapById(int id){
        HoaDonNhapDto hoaDonNhapDto=new HoaDonNhapDto();
        HoaDonNhap hoaDonNhap=hoaDonNhapRepository.findHoaDonNhapById(id);
        hoaDonNhapDto.setId(hoaDonNhap.getId());
        hoaDonNhapDto.setDiachincc(hoaDonNhap.getNhacungcap().getDiachi());
        hoaDonNhapDto.setEmailncc(hoaDonNhap.getNhacungcap().getEmail());
        hoaDonNhapDto.setSdtncc(hoaDonNhap.getNhacungcap().getSdt());
        hoaDonNhapDto.setTenncc(hoaDonNhap.getNhacungcap().getTen());
        hoaDonNhapDto.setNgayxuatdon(hoaDonNhap.getNgayxuatdon());
        hoaDonNhapDto.setTennv(hoaDonNhap.getNhanvienkho().getTen());
        return hoaDonNhapDto;
    }
    public void update(HoaDonNhapDto hoaDonNhapDto){
        HoaDonNhap hoaDonNhap=hoaDonNhapRepository.findHoaDonNhapById(hoaDonNhapDto.getId());
        hoaDonNhap.setTongtien(hoaDonNhapDto.getTongtien());
        hoaDonNhapRepository.save(hoaDonNhap);
    }
    public List<HoaDonNhapDto> getAllHDN(){
        List<HoaDonNhap>hoaDonNhaps=hoaDonNhapRepository.findAll();
        List<HoaDonNhapDto> hoaDonNhapDtos = hoaDonNhaps.stream()
                .map(this::convertToAllDto)
                .collect(Collectors.toList());
        return  hoaDonNhapDtos;
    }
}
