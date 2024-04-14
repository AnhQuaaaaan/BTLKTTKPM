package com.example.kttkpm.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "HoaDon")
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngayxuatdon",nullable = false)
    private Date ngayxuatdon;

    @Column(name = "tongtien",nullable = false)
    private long tongtien;

    @Column(name = "mota")
    private String mota;

    @ManyToOne
    @JoinColumn(name = "nhaphang_id")
    private NhapHang nhaphang;

    @ManyToOne
    @JoinColumn(name = "nguoidung_id")
    private NguoiDung nguoidung;
}
