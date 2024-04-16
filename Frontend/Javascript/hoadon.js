document.addEventListener("DOMContentLoaded", function () {
    getHd();
});
async function getHd() {
    event.preventDefault()
    const data = JSON.parse(localStorage.getItem('nhaphangData'));
    document.getElementById('id').innerText = data.id;
    document.getElementById('ngayxuatdon').innerText = data.ngaynhap;
    document.getElementById('cuahang').innerText = data.tencuahang;
    document.getElementById('nguoidung').innerText = data.tennhanvien;
    document.getElementById('nguyenlieu').innerText = data.tennguyenlieu;
    document.getElementById('nhacungcap').innerText = data.tennhacungcap;
    document.getElementById('tongtien').innerText = data.tongtien;
    document.getElementById('motahd').innerText = data.mota;
}
async function luuhd(event) {
    const data = JSON.parse(localStorage.getItem('nhaphangData'));
    const username = localStorage.getItem("token");
    const userData = JSON.parse(username);
    const idnd = userData.id
    event.preventDefault()
    const send = {
        id:data.id,
        tongtien:data.tongtien,
        ngayxuatdon:data.ngaynhap,
        mota:data.mota,
        nguoidungid:idnd
    };
    await fetch(`http://localhost:8080/api/hoadon/add`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(send)
    })
        .then(response => {
            alert("Thêm hóa đơn thành công")
            window.location.href = "index.html"
        })
        .catch(err => {
            console.log(err)
        })
}