package com.example.kttkpm.Controller;

import com.example.kttkpm.DTO.NCCNguyenLieuDto;
import com.example.kttkpm.DTO.NguoiDungDto;
import com.example.kttkpm.DTO.NhaCungCapDto;
import com.example.kttkpm.Entity.NCCNguyenLieu;
import com.example.kttkpm.Entity.NguyenLieu;
import com.example.kttkpm.Entity.NhaCungCap;
import com.example.kttkpm.Repository.NguyenLieuRepository;
import com.example.kttkpm.Repository.NhaCungCapRepository;
import com.example.kttkpm.Service.NCCNguyenLieuService;
import com.example.kttkpm.Service.NguyenLieuService;
import com.example.kttkpm.Service.NhaCungCapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/materials")
public class NCCNguyenLieuController {
    @Autowired
    private NCCNguyenLieuService nccNguyenLieuService;
    @GetMapping
    public ResponseEntity<List<NCCNguyenLieuDto>> getAllNCCNL(){
        return ResponseEntity.ok(nccNguyenLieuService.getAll());
    }
    @PutMapping( "/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody NCCNguyenLieuDto nccnguyenLieuDto,@PathVariable int id){
        try{
            nccNguyenLieuService.update(nccnguyenLieuDto,id);
            return ResponseEntity.ok().build();
        }
        catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteItem(@PathVariable int id){
        nccNguyenLieuService.delete(id);
        return ResponseEntity.ok().build();
    }

}
