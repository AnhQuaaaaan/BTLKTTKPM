package com.example.kttkpm.Repository;

import com.example.kttkpm.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    NguoiDung findNguoiDungByUsernameAndPassword(String username, String password);
    NguoiDung findNguoiDungById(int id);
}
