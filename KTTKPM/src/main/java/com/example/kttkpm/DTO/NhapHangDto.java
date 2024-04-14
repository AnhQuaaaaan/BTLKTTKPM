package com.example.kttkpm.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhapHangDto implements Serializable {
    private int id,cuahangid,nguyenlieuid,nhacungcapid,nguoidungid;
    private Date ngaynhap;
    private String mota,tencuahang,tennhanvien,tennguyenlieu,tennhacungcap;
    private long soluong,dongia,tongtien;
}
