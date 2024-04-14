package com.example.kttkpm.Controller;

import com.example.kttkpm.DTO.HoaDonDto;
import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hoadon")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @PostMapping("/add")
    ResponseEntity<Void> addhd(@RequestBody HoaDonDto hoaDonDto){
        hoaDonService.save(hoaDonDto);
        return ResponseEntity.ok().build();
    }
}
