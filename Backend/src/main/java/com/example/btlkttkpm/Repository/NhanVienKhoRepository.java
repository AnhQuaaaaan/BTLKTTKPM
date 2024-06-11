package com.example.btlkttkpm.Repository;

import com.example.btlkttkpm.Model.NhaCungCap;
import com.example.btlkttkpm.Model.NhanVienKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienKhoRepository extends JpaRepository<NhanVienKho,Integer> {
    NhanVienKho findNhanVienKhoById(int id);
}
