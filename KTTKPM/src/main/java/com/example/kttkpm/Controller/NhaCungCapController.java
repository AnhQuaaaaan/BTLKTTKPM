package com.example.kttkpm.Controller;

import com.example.kttkpm.DTO.NCCNguyenLieuDto;
import com.example.kttkpm.DTO.NguyenLieuDto;
import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.Entity.NguyenLieu;
import com.example.kttkpm.Entity.NhaCungCap;
import com.example.kttkpm.Service.NguyenLieuService;
import com.example.kttkpm.Service.NhaCungCapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/nhacungcap")
public class NhaCungCapController {
    @Autowired
    private NhaCungCapService nhaCungCapService;
    @PostMapping("/add")
    ResponseEntity<Void> addNcc(@RequestBody NhaCungCapDto nhaCungCapDto){
        nhaCungCapService.save(nhaCungCapDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<NhaCungCapDto>> getAllNCC(){
        return ResponseEntity.ok(nhaCungCapService.getAllNcc());
    }
}
