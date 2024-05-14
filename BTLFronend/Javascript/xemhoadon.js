document.addEventListener("DOMContentLoaded", function () {
    getHd();
    getnl()
});
async function getHd() {
    event.preventDefault()
    const idxhd = JSON.parse(localStorage.getItem('idxhd'));
    const idhd=document.getElementById("idhd")
    const nxd=document.getElementById("nxd")
    const tennv=document.getElementById("tennv")
    const tenncc=document.getElementById("tenncc")
    const diachincc=document.getElementById("diachincc")
    const emailncc=document.getElementById("emailncc")
    const sdtncc=document.getElementById("sdtncc")
    await fetch(`http://localhost:8080/api/hoadonnhap/${idxhd}`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(response => {
            return response.json()
        })
        .then(data =>{
            idhd.innerText=data.id
            nxd.innerText=data.ngayxuatdon
            tennv.innerText=data.tennv
            tenncc.innerText=data.tenncc
            diachincc.innerText=data.diachincc
            emailncc.innerText=data.emailncc
            sdtncc.innerText=data.sdtncc
        })
        .catch(err => {
            console.log(err)
        })
}
async function getnl(){
    event.preventDefault()
    const tongtien=document.getElementById("tongtien")
    const tbody = document.querySelector('.table tbody');
    const idxhd = localStorage.getItem('idxhd');
    let tt=0
    await fetch(`http://localhost:8080/api/hangnhap/${idxhd}`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(async response => response.json())
        .then(async data => {
            data.forEach(item => {
                tt+=item.gia*item.soluong
                const tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${item.tennguyenlieu}</td>
                <td>${item.gia}</td>
                <td>${item.soluong}</td>
            `;
                tbody.appendChild(tr);
            });
            tongtien.innerText=tt

        })
        .catch(error => console.error('Error:', error));
}

