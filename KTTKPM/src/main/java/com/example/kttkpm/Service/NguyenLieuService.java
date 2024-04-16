package com.example.kttkpm.Service;

import com.example.kttkpm.DTO.NguyenLieuDto;
import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.Entity.NguoiDung;
import com.example.kttkpm.Entity.NguyenLieu;
import com.example.kttkpm.Entity.NhaCungCap;
import com.example.kttkpm.Repository.NguyenLieuRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class NguyenLieuService {
    @Autowired
    private NguyenLieuRepository nguyenLieuRepository;
    private NguyenLieuDto convertToDto(NguyenLieu nguyenLieu) {
        ModelMapper modelMapper=new ModelMapper();
        NguyenLieuDto nguyenLieuDto=modelMapper.map(nguyenLieu,NguyenLieuDto.class);
        return nguyenLieuDto;
    }

    public void save(NguyenLieuDto nguyenLieuDto){
        ModelMapper modelMapper=new ModelMapper();
        NguyenLieu nguyenLieu=modelMapper.map(nguyenLieuDto,NguyenLieu.class);
        nguyenLieuRepository.save(nguyenLieu);
    }
    public List<NguyenLieuDto> getAllNl(){
        List<NguyenLieu> nguyenLieus=nguyenLieuRepository.findAll();
        List<NguyenLieuDto> nguyenLieuDtos = nguyenLieus.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return  nguyenLieuDtos;
    }
    public NguyenLieu findNguyenLieuByTen(String s){
        return nguyenLieuRepository.findNguyenLieuByTen(s);
    }
}
