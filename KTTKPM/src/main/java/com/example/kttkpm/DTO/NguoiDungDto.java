package com.example.kttkpm.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDungDto implements Serializable {
    private int id;
    private String username,password,vitri;
}
