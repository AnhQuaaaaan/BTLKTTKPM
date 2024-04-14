package com.example.kttkpm.Repository;

import com.example.kttkpm.Entity.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NguyenLieuRepository extends JpaRepository<NguyenLieu,Integer> {
    NguyenLieu findNguyenLieuByTen(String ten);
    NguyenLieu findNguyenLieuById(int id);
}
