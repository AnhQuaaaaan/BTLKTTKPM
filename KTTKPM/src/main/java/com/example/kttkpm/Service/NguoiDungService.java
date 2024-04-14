package com.example.kttkpm.Service;

import com.example.kttkpm.DTO.NguoiDungDto;
import com.example.kttkpm.Entity.NguoiDung;
import com.example.kttkpm.Repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    public void save(NguoiDungDto nguoiDungDto){
        ModelMapper modelMapper=new ModelMapper();
        NguoiDung nguoiDung=modelMapper.map(nguoiDungDto,NguoiDung.class);
        nguoiDung.setVitri("nv");
        nguoiDungRepository.save(nguoiDung);
    }
    public NguoiDungDto checkUser(String username, String password){
        NguoiDung nguoiDung=nguoiDungRepository.findNguoiDungByUsernameAndPassword(username, password);

        if(nguoiDung!=null){
            ModelMapper modelMapper=new ModelMapper();
            NguoiDungDto nguoiDungDto=modelMapper.map(nguoiDung,NguoiDungDto.class);
            return nguoiDungDto;
        }
        return null;
    }
}
