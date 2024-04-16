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

@Table(name = "NCCNguyenLieu")
public class NCCNguyenLieu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "soluong",nullable = false)
    private long soluong;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "nguyenlieu_id")
    private NguyenLieu nguyenlieu;

    @Column(name = "dongia",nullable = false)
    private long dongia;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "nhacungcap_id")
    private NhaCungCap nhacungcap;

    @OneToMany(mappedBy = "nccnguyenlieu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<NhapHang> nccnguyenlieus =new ArrayList<>();
}
