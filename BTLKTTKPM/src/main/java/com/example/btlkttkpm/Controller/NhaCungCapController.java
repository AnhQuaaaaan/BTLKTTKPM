package com.example.btlkttkpm.Controller;

import com.example.btlkttkpm.Dto.NguyenLieuDto;
import com.example.btlkttkpm.Dto.NhaCungCapDto;
import com.example.btlkttkpm.Service.NguyenLieuService;
import com.example.btlkttkpm.Service.NhaCungCapService;
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
    @GetMapping
    public ResponseEntity<List<NhaCungCapDto>> getAllNCC(){
        return ResponseEntity.ok(nhaCungCapService.getAllNhaCungCap());
    }
    @GetMapping("/{id}")
    public ResponseEntity<NhaCungCapDto> getNCCById(@PathVariable int id){
        return ResponseEntity.ok(nhaCungCapService.findNhaCungCapByID(id));
    }
    @PostMapping("/add")
    ResponseEntity<Void> addNcc(@RequestBody NhaCungCapDto nhaCungCapDto){
        nhaCungCapService.save(nhaCungCapDto);
        return ResponseEntity.ok().build();
    }
}
