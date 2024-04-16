
async function nhaphang() {
    event.preventDefault()
    const idncc = localStorage.getItem('idncc');
    const idnl = localStorage.getItem('idnl');
    const dongia = document.getElementById("dongia").value
    const soluong = document.getElementById("soluong").value
    const ngaynhap = document.getElementById("ngaynhap").value
    const mota = document.getElementById("mota").value
    const cuahangid = 1
    const username = localStorage.getItem("token");
    const userData = JSON.parse(username);
    const idnd = userData.id
    const data = {
        nhacungcapid: idncc,
        nguyenlieuid: idnl,
        dongia: dongia,
        soluong: soluong,
        ngaynhap: ngaynhap,
        cuahangid: cuahangid,
        mota: mota,
        nguoidungid: idnd
    };
    console.log(data)
    await fetch(`http://localhost:8080/api/nhaphang/add`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            return response.json();
        })
        .then(data => {
            localStorage.setItem('nhaphangData', JSON.stringify(data));
            window.location.href = 'hoadon.html';
        })
        .catch(err => {
            console.log(err)
        })
}