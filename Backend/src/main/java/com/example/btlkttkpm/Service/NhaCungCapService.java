package com.example.btlkttkpm.Service;

import com.example.btlkttkpm.Dto.NhaCungCapDto;
import com.example.btlkttkpm.Model.NhaCungCap;
import com.example.btlkttkpm.Repository.NhaCungCapRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class NhaCungCapService {
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;
    private NhaCungCapDto convertToDto(NhaCungCap nhaCungCap) {
        ModelMapper modelMapper=new ModelMapper();
        NhaCungCapDto nhaCungCapDto=modelMapper.map(nhaCungCap,NhaCungCapDto.class);
        return nhaCungCapDto;
    }
    public List<NhaCungCapDto> getAllNhaCungCap(){
        List<NhaCungCap> nhaCungCaps=nhaCungCapRepository.findAll();
        List<NhaCungCapDto> nhaCungCapDtos = nhaCungCaps.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return nhaCungCapDtos;
    }
    public NhaCungCapDto findNhaCungCapByID(int id){
        return convertToDto(nhaCungCapRepository.findNhaCungCapById(id));
    }
    public void save(NhaCungCapDto nhaCungCapDto){
        ModelMapper modelMapper=new ModelMapper();
        NhaCungCap nhaCungCap=modelMapper.map(nhaCungCapDto,NhaCungCap.class);
        nhaCungCapRepository.save(nhaCungCap);
    }
}
