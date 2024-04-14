package com.example.kttkpm.Controller;

import com.example.kttkpm.DTO.NguoiDungDto;
import com.example.kttkpm.Entity.NguoiDung;
import com.example.kttkpm.Service.NguoiDungService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody NguoiDungDto nguoiDungDto){
        if (nguoiDungService.checkUser(nguoiDungDto.getUsername(),nguoiDungDto.getPassword())!=null){
            return ResponseEntity.ok(nguoiDungService.checkUser(nguoiDungDto.getUsername(),nguoiDungDto.getPassword()));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tên đăng nhập hoặc mật khẩu không đúng");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody NguoiDungDto nguoiDungDto){
        if (nguoiDungService.checkUser(nguoiDungDto.getUsername(), nguoiDungDto.getPassword())!=null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tài khoản đã tồn tại");
        }
        else{
            nguoiDungService.save(nguoiDungDto);
            return ResponseEntity.ok(nguoiDungDto);
        }
    }
}
