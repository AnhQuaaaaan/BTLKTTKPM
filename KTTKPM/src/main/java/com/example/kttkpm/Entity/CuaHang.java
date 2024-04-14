package com.example.kttkpm.Entity;

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
@Table(name = "CuaHang")
public class CuaHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten",nullable = false)
    private String ten;

    @Column(name = "diachi",nullable = false)
    private String diachi;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "sdt",nullable = false)
    private String sdt;

    @Column(name = "mota")
    private String mota;

    @OneToMany(mappedBy = "cuahang", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<NhapHang> cuahangs =new ArrayList<>();
}
