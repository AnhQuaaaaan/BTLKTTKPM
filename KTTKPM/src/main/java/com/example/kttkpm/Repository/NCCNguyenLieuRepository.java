package com.example.kttkpm.Repository;

import com.example.kttkpm.Entity.NCCNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NCCNguyenLieuRepository extends JpaRepository<NCCNguyenLieu,Integer> {
    NCCNguyenLieu findNCCNguyenLieuById(int id);
}
