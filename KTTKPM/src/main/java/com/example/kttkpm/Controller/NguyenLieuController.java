package com.example.kttkpm.Controller;

import com.example.kttkpm.DTO.NguoiDungDto;
import com.example.kttkpm.DTO.NguyenLieuDto;
import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.Entity.NguyenLieu;
import com.example.kttkpm.Service.NguyenLieuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/nguyenlieu")
public class NguyenLieuController {
    @Autowired
    private NguyenLieuService nguyenLieuService;
    @PostMapping("/add")
    ResponseEntity<Void> addNl(@RequestBody NguyenLieuDto nguyenLieuDto){
        nguyenLieuService.save(nguyenLieuDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<NguyenLieuDto>> getAllNL(){
        return ResponseEntity.ok(nguyenLieuService.getAllNl());
    }

}
