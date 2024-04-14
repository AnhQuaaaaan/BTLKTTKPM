package com.example.kttkpm.Controller;

import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.DTO.NhapHangDto;
import com.example.kttkpm.Service.NhapHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/nhaphang")
public class NhapHangController {
    @Autowired
    private NhapHangService nhapHangService;
    @PostMapping("/add")
    ResponseEntity<?> addNcc(@RequestBody NhapHangDto nhapHangDto){
        NhapHangDto nhapHangDto1=nhapHangService.save(nhapHangDto);
        return ResponseEntity.ok(nhapHangDto1);
    }
}
