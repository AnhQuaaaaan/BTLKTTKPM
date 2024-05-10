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
public class NhanVienKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten")
    private String ten;


    @Column(name = "sdt")
    private String sdt;
    @OneToMany(mappedBy = "nhanvienkho")
    @JsonManagedReference
    private List<HoaDonNhap> nhanvienkhos =new ArrayList<>();
}
