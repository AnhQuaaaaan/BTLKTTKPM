package com.example.btlkttkpm.Repository;

import com.example.btlkttkpm.Model.HangNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HangNhapRepository extends JpaRepository<HangNhap,Integer> {
    List<HangNhap> findAllByHoadonnhap_Id(int id);
}
