package com.example.btlkttkpm.Controller;

import com.example.btlkttkpm.Dto.HangNhapDto;
import com.example.btlkttkpm.Dto.HoaDonNhapDto;
import com.example.btlkttkpm.Service.HangNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hangnhap")
public class HangNhapController {
    @Autowired
    private HangNhapService hangNhapService;
    @GetMapping("/{id}")
    public ResponseEntity<List<HangNhapDto>> getAllHnByHDNID(@PathVariable int id){
        return ResponseEntity.ok(hangNhapService.getAllHNByHDN(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addHangNhap(@RequestBody HangNhapDto hangNhapDto){
        hangNhapService.add(hangNhapDto);
        return ResponseEntity.ok().build();
    }
}
