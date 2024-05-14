package com.example.btlkttkpm.Service;

import com.example.btlkttkpm.Dto.NguyenLieuDto;
import com.example.btlkttkpm.Model.NguyenLieu;
import com.example.btlkttkpm.Repository.NguyenLieuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

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

    public List<NguyenLieuDto> getAllNguyenLieu(){
        List<NguyenLieu> nguyenLieus=nguyenLieuRepository.findAll();
        List<NguyenLieuDto> nguyenLieuDtos = nguyenLieus.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return  nguyenLieuDtos;
    }
    public NguyenLieuDto findNguyenLieuById(int id){
        return convertToDto(nguyenLieuRepository.findNguyenLieuById(id));
    }
}
