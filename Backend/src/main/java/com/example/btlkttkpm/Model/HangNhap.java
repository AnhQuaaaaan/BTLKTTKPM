package com.example.btlkttkpm.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "HangNhap")

public class HangNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "gia")
    private long gia;
    @Column(name = "soluong")
    private long soluong;
    @ManyToOne()
    @JoinColumn(name = "nguyenlieu_id")
    private NguyenLieu nguyenlieu;
    @ManyToOne()
    @JoinColumn(name = "hoadonnhap_id")
    private HoaDonNhap hoadonnhap;
}
