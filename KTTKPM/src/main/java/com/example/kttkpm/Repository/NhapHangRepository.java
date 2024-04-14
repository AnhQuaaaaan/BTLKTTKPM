package com.example.kttkpm.Repository;

import com.example.kttkpm.Entity.NguoiDung;
import com.example.kttkpm.Entity.NhapHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhapHangRepository extends JpaRepository<NhapHang,Integer> {
    NhapHang findNhapHangById(int id);
}
