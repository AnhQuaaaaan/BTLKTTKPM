package com.example.kttkpm.Service;

import com.example.kttkpm.DTO.NCCNguyenLieuDto;
import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.Entity.NCCNguyenLieu;
import com.example.kttkpm.Entity.NguyenLieu;
import com.example.kttkpm.Entity.NhaCungCap;
import com.example.kttkpm.Repository.NhaCungCapRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class NhaCungCapService {
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;
    private NhaCungCapDto convertToDto(NhaCungCap nhaCungCap) {
        ModelMapper modelMapper=new ModelMapper();
        NhaCungCapDto nhaCungCapDto=modelMapper.map(nhaCungCap,NhaCungCapDto.class);
        return nhaCungCapDto;
    }
    public List<NhaCungCapDto> getAllNcc(){
        List<NhaCungCap> nhaCungCaps=nhaCungCapRepository.findAll();
        List<NhaCungCapDto> nhaCungCapDtos = nhaCungCaps.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return  nhaCungCapDtos;
    }
    public void save(NhaCungCapDto nhaCungCapDto){
        ModelMapper modelMapper=new ModelMapper();
        NhaCungCap nhaCungCap=modelMapper.map(nhaCungCapDto,NhaCungCap.class);
        nhaCungCapRepository.save(nhaCungCap);
    }

    public NhaCungCap findNhaCungCapByTen(String s){
        return nhaCungCapRepository.findNhaCungCapByTen(s);
    }
}
