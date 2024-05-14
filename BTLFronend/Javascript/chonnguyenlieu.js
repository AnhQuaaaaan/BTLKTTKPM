
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
    tbody.innerHTML = ''
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
    const ten = document.getElementById("tennl1").value
    const mota = document.getElementById("motanl1").value
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
    const idhdn = localStorage.getItem('idhdn');
    const dongia = document.getElementById("dongianl")
    const soluong = document.getElementById("soluongnl")
    const loi = document.getElementById("loi")
    try {
        const response = await fetch(`http://localhost:8080/api/hangnhap/${idnl}/${idhdn}`, {
            headers: {
                "Content-Type": "application/json"
            },
        });

        if (!response.ok) {
            try {
                const nguyenlieuResponse = await fetch(`http://localhost:8080/api/nguyenlieu/${idnl}`, {
                    headers: {
                        "Content-Type": "application/json"
                    },
                });

                if (!nguyenlieuResponse.ok) {
                    throw new Error('Lỗi khi lấy dữ liệu từ API nguyên liệu');
                }

                const data = await nguyenlieuResponse.json();

                tennl.innerText = data.ten;
                motanl.innerText = data.mota;
                nhap.style.display = "flex";
            } catch (error) {
                console.error('Lỗi khi xử lý response từ API nguyên liệu:', error);
            }
        }
        else {
            const responseData = await response.json();
            try {
                const nguyenlieuResponse = await fetch(`http://localhost:8080/api/nguyenlieu/${idnl}`, {
                    headers: {
                        "Content-Type": "application/json"
                    },
                });

                if (!nguyenlieuResponse.ok) {
                    throw new Error('Lỗi khi lấy dữ liệu từ API nguyên liệu');
                }

                const data = await nguyenlieuResponse.json();

                tennl.innerText = data.ten;
                motanl.innerText = data.mota;
                dongia.value = responseData.gia;
                soluong.value = responseData.soluong;
                loi.innerText = "Nguyên liệu này đã được chọn vui lòng sửa thông tin"
                nhap.style.display = "flex";
            } catch (error) {
                console.error('Lỗi khi xử lý response từ API nguyên liệu:', error);
            }
        }
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }

}
async function xacnhannl() {
    event.preventDefault();
    const idnl = localStorage.getItem('idnl');
    const idhdn = localStorage.getItem('idhdn');
    const dongia = document.getElementById("dongianl").value
    const soluong = document.getElementById("soluongnl").value
    
    try {
        const response = await fetch(`http://localhost:8080/api/hangnhap/${idnl}/${idhdn}`, {
            headers: {
                "Content-Type": "application/json"
            },
        });

        if (!response.ok) {
            const data = {
                hoadonnhap_id: idhdn,
                nguyenlieu_id: idnl,
                gia: dongia,
                soluong: soluong,
            };
            try {
                const resp =await fetch(`http://localhost:8080/api/hangnhap/add`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            })
                if (!resp.ok) {
                    throw new Error('Lỗi gì rồi');
                }
                window.location.href="chonnguyenlieu.html"
                
            } catch (error) {
                console.error('Lỗi khi xử lý response từ API nguyên liệu:', error);
            }
        }
        else {
            const responseData = await response.json();
            const data = {
                id:responseData.id,
                hoadonnhap_id: idhdn,
                nguyenlieu_id: idnl,
                gia: dongia,
                soluong: soluong,
            };
            try {
                const resp =await fetch(`http://localhost:8080/api/hangnhap/update`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            })
                if (!resp.ok) {
                    throw new Error('Lỗi gì rồi');
                }
                window.location.href="chonnguyenlieu.html"
                
            } catch (error) {
                console.error('Lỗi khi xử lý response từ API nguyên liệu:', error);
            }
        }
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
    }

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
function nhaphang() {
    event.preventDefault()
    window.location.href = "hoadon.html"
}