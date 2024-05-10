
const nl = document.getElementById("themnl")
const nls = document.getElementById("hidenls")
const listnl = document.getElementById("listnl").getElementsByTagName("table")[0];
const tbody = document.querySelector('.table1 tbody');
async function getAllnl() {
    await fetch(`http://localhost:8080/api/nguyenlieu`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(async response => response.json())
        .then(async data => {
            data.forEach(item => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.ten}</td>
                <td>${item.mota}</td>
                <td><Button type="button" class="buttonnl">Chọn</Button></td>
            `;
                tbody.appendChild(tr);
                tr.querySelector('button[type="button"]').addEventListener('click', () => selectItem(item.id));
            });

        })
        .catch(error => console.error('Error:', error));
}
document.addEventListener("DOMContentLoaded", function () {
    getAllnl();
    loadncc();
    loadhangnhap()
});
document.getElementById("tennguyenlieusearch").addEventListener("input", function () {
    const searchnl = this.value.toLowerCase();
    searchNl(searchnl);
});
async function searchNl(searchnl) {
    const filteredData = await fetch(`http://localhost:8080/api/nguyenlieu`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(async response => response.json())
        .catch(error => console.error('Error:', error));
    const filteredItems = filteredData.filter(item => {
        return item.ten.toLowerCase().includes(searchnl);
    });
    tbody.innerHTML=''
    filteredItems.forEach(item => {
        
        const tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.ten}</td>
                <td>${item.mota}</td>
                <td><Button type="button" class="buttonnl">Chọn</Button></td>
            `;
                tbody.appendChild(tr);
                tr.querySelector('button[type="button"]').addEventListener('click', () => selectItem(item.id));
    });
}
async function themnlnll(event) {
    event.preventDefault()
    nl.style.display = "block"
}
async function addnl(event) {
    event.preventDefault()
    const ten = document.getElementById("tennl").value
    const mota = document.getElementById("motanl").value
    fetch(`http://localhost:8080/api/nguyenlieu/add`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ ten, mota })
    })
        .then(response => {
            response.json()
        })
        .then(data => {
            alert("Thêm thành công")
            nl.style.display = "none"
        })
        .then(reload => {
            reloadAndFetchData()
        })
        .catch(err => {
            console.log(err)
        })
}
function reloadAndFetchData() {
    window.location.reload();
}
function selectItem(id) {
    localStorage.setItem('idnl', id);
    nl.style.display = "none";
    selectednl()
}
async function loadncc() {
    event.preventDefault()
    const tenncc = document.getElementById("tenncc")
    const diachincc = document.getElementById("diachincc")
    const idncc = localStorage.getItem('idncc');
    const emailncc = document.getElementById("emailncc")
    const sdtncc = document.getElementById("sdtncc")
    fetch(`http://localhost:8080/api/nhacungcap/${idncc}`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(response => {
            return response.json()
        })
        .then(data => {
            tenncc.innerText = data.ten;
            diachincc.innerText = data.diachi;
            emailncc.innerText = data.email;
            sdtncc.innerText = data.sdt
        })
        .catch(err => {
            console.log(err)
        })
}
async function selectednl() {
    event.preventDefault()
    const tennl = document.getElementById("tennl")
    const motanl = document.getElementById("motanl")
    const nhap = document.getElementById("nhap")
    const idnl = localStorage.getItem('idnl');
    fetch(`http://localhost:8080/api/nguyenlieu/${idnl}`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(response => {
            return response.json()
        })
        .then(data => {
            tennl.innerText = data.ten;
            motanl.innerText = data.mota;
            nhap.style.display = "flex"
        })
        .catch(err => {
            console.log(err)
        })
}
async function xacnhannl(event) {
    const idnl = localStorage.getItem('idnl');
    const idhdn = localStorage.getItem('idhdn');
    const dongia = document.getElementById("dongianl").value
    const soluong = document.getElementById("soluongnl").value
    const data = {
        hoadonnhap_id: idhdn,
        nguyenlieu_id: idnl,
        gia: dongia,
        soluong: soluong,
    };
    await fetch(`http://localhost:8080/api/hangnhap/add`, {
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
            window.location.reload = "chonnguyenlieu.html"
        })
        .catch(err => {
            console.log(err)
        })
}
async function loadhangnhap(event) {
    const idhdn = localStorage.getItem('idhdn');
    const apiUrl = `http://localhost:8080/api/hangnhap/${idhdn}`;
    try {
        const response = await fetch(apiUrl, {
            headers: {
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const hangNhapList = await response.json(); 
        const container = document.querySelector('.listnnl');
        container.innerHTML = '';  

        if (hangNhapList.length === 0) {
        } else {
            const table = document.createElement('table');
            table.innerHTML = `
                <tr>
                    <th>Tên Nguyên Liệu</th>
                    <th>Giá</th>
                    <th>Số Lượng</th>
                </tr>
            `;

            hangNhapList.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.tennguyenlieu}</td>
                    <td>${item.gia}</td>
                    <td>${item.soluong}</td>
                `;
                table.appendChild(row);
            });

            container.appendChild(table);
        }
    } catch (error) {
        console.error('Error fetching data:', error);
        document.querySelector('.listnnl').innerHTML = '<p>Đã xảy ra lỗi khi tải dữ liệu.</p>';
    }
}
function nhaphang(){
    event.preventDefault()
    window.location.href="hoadon.html"
}