package com.example.btlkttkpm.Controller;

import com.example.btlkttkpm.Dto.HoaDonNhapDto;
import com.example.btlkttkpm.Service.HoaDonNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hoadonnhap")
public class HoaDonNhapController {
    @Autowired
    private HoaDonNhapService hoaDonNhapService;
    @PostMapping("/newhoadon/{id}")
    public ResponseEntity<HoaDonNhapDto> newHoaDonNhap(@PathVariable int id){
        return ResponseEntity.ok(hoaDonNhapService.NewHoaDonNhap(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HoaDonNhapDto> getHoaDon(@PathVariable int id){
        return ResponseEntity.ok(hoaDonNhapService.getHoaDonNhapById(id));
    }
    @PutMapping("/update")
    public ResponseEntity<Void> getHoaDon(@RequestBody HoaDonNhapDto hoaDonNhapDto){
        hoaDonNhapService.update(hoaDonNhapDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<HoaDonNhapDto>> getAll(){
        return ResponseEntity.ok(hoaDonNhapService.getAllHDN());
    }
}
