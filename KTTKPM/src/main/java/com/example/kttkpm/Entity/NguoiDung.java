package com.example.kttkpm.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "NguoiDung")
public class NguoiDung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "vitri",nullable = false)
    private String vitri;

    @OneToMany(mappedBy = "nguoidung", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<HoaDon> nguoidungs =new ArrayList<>();
}
