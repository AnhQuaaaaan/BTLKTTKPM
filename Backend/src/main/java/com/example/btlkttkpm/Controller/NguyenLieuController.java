package com.example.btlkttkpm.Controller;

import com.example.btlkttkpm.Dto.NguyenLieuDto;
import com.example.btlkttkpm.Dto.NhaCungCapDto;
import com.example.btlkttkpm.Service.NguyenLieuService;
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
    @GetMapping
    public ResponseEntity<List<NguyenLieuDto>> getAllNL(){
        return ResponseEntity.ok(nguyenLieuService.getAllNguyenLieu());
    }
    @GetMapping("/{id}")
    public ResponseEntity<NguyenLieuDto> getNl(@PathVariable int id){
        return ResponseEntity.ok(nguyenLieuService.findNguyenLieuById(id));
    }
    @PostMapping("/add")
    ResponseEntity<Void> addNl(@RequestBody NguyenLieuDto nguyenLieuDto){
        nguyenLieuService.save(nguyenLieuDto);
        return ResponseEntity.ok().build();
    }
}
