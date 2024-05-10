package com.example.btlkttkpm.Repository;

import com.example.btlkttkpm.Model.HoaDonNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonNhapRepository extends JpaRepository<HoaDonNhap,Integer> {
    HoaDonNhap findHoaDonNhapById(int id);
}
