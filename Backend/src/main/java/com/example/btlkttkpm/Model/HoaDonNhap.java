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
public class HoaDonNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ngayxuatdon")
    private String ngayxuatdon;
    @Column(name = "tongtien")
    private long tongtien;
    @OneToMany(mappedBy = "hoadonnhap")
    @JsonManagedReference
    private List<HangNhap> hoadonNhaps =new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name = "nhacungcap_id")
    private NhaCungCap nhacungcap;
    @ManyToOne()
    @JoinColumn(name = "nhanvienkho_id")
    private NhanVienKho nhanvienkho;
}
