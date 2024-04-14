package com.example.kttkpm.Service;

import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.DTO.NhapHangDto;
import com.example.kttkpm.Entity.*;
import com.example.kttkpm.Repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Date date=new Date();
        CuaHang cuaHang=cuaHangRepository.findCuaHangById(nhapHangDto.getCuahangid());
        NCCNguyenLieu nccNguyenLieu=nccNguyenLieuRepository.findNCCNguyenLieuByNguyenlieuIdAndNhacungcapId(nhapHangDto.getNguyenlieuid(), nhapHangDto.getNhacungcapid());
        try {
            date = dateFormat.parse(String.valueOf(nhapHangDto.getNgaynhap()));
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (nccNguyenLieu==null){
            NguoiDung nguoiDung=nguoiDungRepository.findNguoiDungById(nhapHangDto.getNguoidungid());
            NguyenLieu nguyenLieu=nguyenLieuRepository.findNguyenLieuById(nhapHangDto.getNguyenlieuid());
            NhaCungCap nhaCungCap=nhaCungCapRepository.findNhaCungCapById(nhapHangDto.getNhacungcapid());
            NCCNguyenLieu nccNguyenLieu1=new NCCNguyenLieu();
            nccNguyenLieu1.setNguyenlieu(nguyenLieu);
            nccNguyenLieu1.setNhacungcap(nhaCungCap);
            nccNguyenLieu1.setSoluong(nhapHangDto.getSoluong());
            nccNguyenLieu1.setDongia(nhapHangDto.getDongia());
            nccNguyenLieuRepository.save(nccNguyenLieu1);
            NhapHang nhapHang=new NhapHang();
            nhapHang.setMota(nhapHangDto.getMota());
            nhapHang.setCuahang(cuaHang);
            nhapHang.setNgaynhap(date);
            nhapHang.setNccnguyenlieu(nccNguyenLieu1);
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
        else{
            NguoiDung nguoiDung=nguoiDungRepository.findNguoiDungById(nhapHangDto.getNguoidungid());
            NguyenLieu nguyenLieu=nguyenLieuRepository.findNguyenLieuById(nhapHangDto.getNguyenlieuid());
            NhaCungCap nhaCungCap=nhaCungCapRepository.findNhaCungCapById(nhapHangDto.getNhacungcapid());
            NCCNguyenLieu nccNguyenLieu1=nccNguyenLieuRepository.findNCCNguyenLieuByNguyenlieuIdAndNhacungcapId(nhapHangDto.getNguyenlieuid(), nhapHangDto.getNhacungcapid());
            nccNguyenLieu1.setSoluong(nccNguyenLieu1.getSoluong()+ nhapHangDto.getSoluong());
            nccNguyenLieu1.setDongia(nhapHangDto.getDongia());
            nccNguyenLieuRepository.save(nccNguyenLieu1);
            NhapHang nhapHang=new NhapHang();
            nhapHang.setMota(nhapHangDto.getMota());
            nhapHang.setCuahang(cuaHang);
            nhapHang.setNgaynhap(date);
            nhapHang.setNccnguyenlieu(nccNguyenLieu1);
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
}
