package com.example.kttkpm.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonDto implements Serializable {
    private int id,nguoidungid,idnhaphang;
    private Date ngayxuatdon;
    private String tencuahang,tennhanvien,tennguyenlieu,tennhacungcap,mota,tennguoidung;
    private long tongtien;

}
