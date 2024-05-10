package com.example.btlkttkpm.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCapDto implements Serializable {
    private int id;
    private String ten,diachi,email,sdt;
}
