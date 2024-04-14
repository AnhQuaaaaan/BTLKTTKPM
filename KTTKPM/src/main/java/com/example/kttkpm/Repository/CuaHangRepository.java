package com.example.kttkpm.Repository;

import com.example.kttkpm.Entity.CuaHang;
import com.example.kttkpm.Entity.NCCNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang,Integer> {
    CuaHang findCuaHangById(int id);
}
