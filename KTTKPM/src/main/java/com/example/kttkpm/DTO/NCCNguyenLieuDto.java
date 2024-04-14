package com.example.kttkpm.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NCCNguyenLieuDto implements Serializable {
    private int id;
    private long soluong;
    private String tennguyenlieu;
    private String tennhacungcap;
    private long dongia;
}
