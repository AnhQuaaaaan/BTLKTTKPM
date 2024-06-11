package com.example.btlkttkpm.Model;

import com.example.btlkttkpm.Model.HangNhap;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "NguyenLieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten")
    private String ten;


    @Column(name = "mota")
    private String mota;

    @OneToMany(mappedBy = "nguyenlieu")
    @JsonManagedReference
    private List<HangNhap> nguyenlieus =new ArrayList<>();
}
