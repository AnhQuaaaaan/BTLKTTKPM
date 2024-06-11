package com.example.btlkttkpm.Repository;

import com.example.btlkttkpm.Model.NguyenLieu;
import com.example.btlkttkpm.Model.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguyenLieuRepository extends JpaRepository<NguyenLieu,Integer> {
    NguyenLieu findNguyenLieuById(int id);
}
