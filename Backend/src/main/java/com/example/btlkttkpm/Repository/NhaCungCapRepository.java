package com.example.btlkttkpm.Repository;

import com.example.btlkttkpm.Model.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap,Integer> {
    NhaCungCap findNhaCungCapById(int id);
}
