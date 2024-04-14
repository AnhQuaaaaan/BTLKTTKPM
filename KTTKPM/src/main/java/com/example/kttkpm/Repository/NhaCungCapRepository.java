package com.example.kttkpm.Repository;

import com.example.kttkpm.Entity.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap,Integer> {
    NhaCungCap findNhaCungCapByTen(String ten);
    NhaCungCap findNhaCungCapById(int id);
}
