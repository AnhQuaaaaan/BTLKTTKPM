package com.example.btlkttkpm.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonNhapDto implements Serializable {
    private int id,nhacungcap_id,nhanvienkho_id;
    private String ngayxuatdon,tennv,tenncc,diachincc,emailncc,sdtncc;
    private long tongtien;
}
