package com.example.kttkpm.Repository;

import com.example.kttkpm.Entity.HoaDon;
import com.example.kttkpm.Entity.NCCNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
}
