const nccs = document.getElementById("hidenccs")
const ncc = document.getElementById("themncc")
const listnl = document.getElementById("listnl").getElementsByTagName("table")[0];
async function getAllncc() {
    nccs.style.display = "block"
    await fetch(`http://localhost:8080/api/nhacungcap`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(response => response.json())
        .then(data => {
            listnl.innerHTML = "";
            const headerRow = "<tr><th>ID</th><th>Tên</th><th>Địa chỉ</th><th>Email</th><th>SDT</th><th></th></tr>";
            listnl.innerHTML += headerRow;
            data.forEach(item => {
                const rowHTML = `
                <tr>
                    <td>${item.id}</td>
                    <td>${item.ten}</td>
                    <td>${item.diachi}</td>
                    <td>${item.email}</td>
                    <td>${item.sdt}</td>
                    <td><button class="my-button" onclick="selectItem('${item.id}')">Chọn</button></td>
                </tr>`;
                listnl.innerHTML += rowHTML;
            })

        })
        .catch(error => console.error('Error:', error));
}


document.getElementById("tennhacungcapsearch").addEventListener("input", function () {
    const searchncc = this.value.toLowerCase();
    searchNcc(searchncc);
});
async function searchNcc(searchNcc) {

    const filteredData = await fetch(`http://localhost:8080/api/nhacungcap`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(response => response.json())
        .catch(error => console.error('Error:', error));
    const filteredItems = filteredData.filter(item => {
        return item.ten.toLowerCase().includes(searchNcc);
    });
    listnl.innerHTML = ""
    const headerRow = document.createElement("tr");
    const idHeader = document.createElement("th");
    idHeader.innerText = "ID";
    headerRow.appendChild(idHeader);
    const tenHeader = document.createElement("th");
    tenHeader.innerText = "Tên";
    headerRow.appendChild(tenHeader);
    const diachiHeader = document.createElement("th");
    diachiHeader.innerText = "Địa chỉ";
    headerRow.appendChild(diachiHeader);
    const emailHeader = document.createElement("th");
    emailHeader.innerText = "Email";
    headerRow.appendChild(emailHeader);
    const sdtHeader = document.createElement("th");
    sdtHeader.innerText = "SDT";
    headerRow.appendChild(sdtHeader);
    const them = document.createElement("th");
    headerRow.appendChild(them);
    const sua = document.createElement("th");
    headerRow.appendChild(sua);
    listnl.appendChild(headerRow);
    filteredItems.forEach(item => {
        const newRow = document.createElement("tr");

        const idnccCell = document.createElement("td");
        idnccCell.innerText = item.id;
        newRow.appendChild(idnccCell);

        const tennlCell = document.createElement("td");
        tennlCell.innerText = item.ten;
        newRow.appendChild(tennlCell);

        const tennccCell = document.createElement("td");
        tennccCell.innerText = item.diachi;
        newRow.appendChild(tennccCell);

        const dongiaCell = document.createElement("td");
        dongiaCell.innerText = item.email;
        newRow.appendChild(dongiaCell);

        const soluongCell = document.createElement("td");
        soluongCell.innerText = item.sdt;
        newRow.appendChild(soluongCell);


        const suaCell = document.createElement("td");
        const suaButton = document.createElement("button");
        suaButton.innerText = "Chọn";
        suaButton.onclick = function () {
            localStorage.setItem('idncc', item.id.toString());
            ncc.style.display = "none"
            choosencc()
        }
        suaButton.classList.add("my-button");
        suaCell.appendChild(suaButton);
        newRow.appendChild(suaCell);

        listnl.appendChild(newRow);
    });
}
document.addEventListener("DOMContentLoaded", function () {
    getAllncc();
});
function choosencc() {
    window.location.href = "chonnguyenlieu.html"
}
function themnccnll(event) {
    event.preventDefault()
    ncc.style.display = "block"
}
async function addncc(event) {
    event.preventDefault()
    const ten = document.getElementById("tenncc").value
    const diachi = document.getElementById("diachincc").value
    const email = document.getElementById("emailncc").value
    const sdt = document.getElementById("sdtncc").value
    const mota = document.getElementById("motancc").value
    fetch(`http://localhost:8080/api/nhacungcap/add`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ ten, diachi, email, sdt, mota })
    })
        .then(async response => {
            response.json()
        })
        .then(data => {
            alert("Thêm thành công")
            ncc.style.display = "none"
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
    localStorage.setItem('idncc', id);
    ncc.style.display = "none";
    newHoaDonNhap(id)
    
}
async function newHoaDonNhap(id) {
    event.preventDefault();
    try {
        const response = await fetch(`http://localhost:8080/api/hoadonnhap/newhoadon/${id}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
        });
        const data = await response.json(); // Chờ đợi cho đến khi dữ liệu được phân tích thành công
        localStorage.setItem('idhdn', data.id);
        choosencc()
    } catch (err) {
        console.log(err); // Xuất log lỗi nếu có
    }
}

