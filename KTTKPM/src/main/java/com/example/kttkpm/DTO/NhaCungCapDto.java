package com.example.kttkpm.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCapDto implements Serializable {
    private int id;
    private String ten;
    private String diachi;
    private String email;
    private String sdt;
    private String mota;
}
