package com.example.btlkttkpm.Model;

import com.example.btlkttkpm.Model.HangNhap;
import com.example.btlkttkpm.Model.HoaDonNhap;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "NhaCungCap")
public class NhaCungCap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @OneToMany(mappedBy = "nhacungcap")
    @JsonManagedReference
    private List<HoaDonNhap> nhacungcaps =new ArrayList<>();
}
