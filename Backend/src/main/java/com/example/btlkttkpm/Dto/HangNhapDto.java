package com.example.btlkttkpm.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HangNhapDto implements Serializable {
    private int id,hoadonnhap_id,nguyenlieu_id;
    private long gia,soluong;
    private String tennguyenlieu;
}
