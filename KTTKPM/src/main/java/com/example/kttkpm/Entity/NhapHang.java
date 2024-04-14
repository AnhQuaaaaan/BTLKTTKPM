package com.example.kttkpm.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "NhapHang")
public class NhapHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngaynhap",nullable = false)
    private Date ngaynhap;

    @Column(name = "mota")
    private String mota;

    @ManyToOne
    @JoinColumn(name = "nccnguyenlieu_id")
    private NCCNguyenLieu nccnguyenlieu;

    @ManyToOne
    @JoinColumn(name = "cuahang_id")
    private CuaHang cuahang;

    @OneToMany(mappedBy = "nhaphang", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<HoaDon> nhaphangs =new ArrayList<>();
}
