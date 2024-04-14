async function getAllnl() {
    const listnl = document.getElementById("listnl").getElementsByTagName("table")[0];
    fetch(`http://localhost:8080/api/materials`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then( response => response.json())
        .then( data => {
            data.forEach(item => {
                const newRow = document.createElement("tr");

                const idnccCell = document.createElement("td");
                idnccCell.innerText = item.id;
                newRow.appendChild(idnccCell);

                const tennlCell = document.createElement("td");
                tennlCell.innerText = item.tennguyenlieu;
                newRow.appendChild(tennlCell);

                const tennccCell = document.createElement("td");
                tennccCell.innerText = item.tennhacungcap;
                newRow.appendChild(tennccCell);

                const dongiaCell = document.createElement("td");
                dongiaCell.innerText = item.dongia;
                newRow.appendChild(dongiaCell);

                const soluongCell = document.createElement("td");
                soluongCell.innerText = item.soluong;
                newRow.appendChild(soluongCell);

                const suaCell = document.createElement("td");
                const suaButton = document.createElement("button");
                suaButton.innerText = "Sửa";
                suaButton.onclick = function() {
                    editItem(item.id,item.tennguyenlieu,item.tennhacungcap,item.dongia,item.soluong)
                }
                suaButton.classList.add("my-button");
                suaCell.appendChild(suaButton);
                newRow.appendChild(suaCell);

                const xoaCell = document.createElement("td");
                const xoaButton = document.createElement("button");
                xoaButton.innerText = "Xóa";
                xoaButton.onclick=function (){
                    deleteItem(item.id)
                }
                xoaButton.classList.add("my-button");
                xoaCell.appendChild(xoaButton);
                newRow.appendChild(xoaCell);

                listnl.appendChild(newRow);
            })
        })
        .catch(error => console.error('Error:', error));
}
async function deleteItem(id1){
    fetch(`http://localhost:8080/api/materials/delete/${id1}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then(response =>{
            reloadAndFetchData()
        })
        .catch(err =>{
            console.log(err)
        })
}
function editItem(id1,tennl,tenncc,dg,sl) {
    const hide = document.getElementById("hide")
    const hidenl = document.getElementById("themnl")
    const hidencc = document.getElementById("themncc")
    const nl=document.getElementById("ngoaile")
    nl.style.display="none"
    hide.style.display="block";
    hidenl.style.display="none"
    hidencc.style.display="none"
    const id=document.getElementById("id")
    const tennguyenlieu=document.getElementById("tennguyenlieu")
    const tennhacungcap=document.getElementById("tennhacungcap")
    const dongia=document.getElementById("dongia")
    const soluong=document.getElementById("soluong")
    id.value=id1
    tennguyenlieu.value= tennl;
    tennhacungcap.value=tenncc;
    dongia.value=dg;
    soluong.value=sl;
}
async function updateitem(event){
    event.preventDefault()
    const nl=document.getElementById("ngoaile")
    const hide = document.getElementById("hide")
    const themnl = document.getElementById("themnl")
    const themncc = document.getElementById("themncc")
    const id=document.getElementById("id").value
    const tennguyenlieu=document.getElementById("tennguyenlieu").value
    const tennhacungcap=document.getElementById("tennhacungcap").value
    const dongia=document.getElementById("dongia").value
    const soluong=document.getElementById("soluong").value
    const data = {
        tennguyenlieu: tennguyenlieu,
        tennhacungcap: tennhacungcap,
        dongia: dongia,
        soluong: soluong
    };
    console.log(data)
    fetch(`http://localhost:8080/api/materials/update/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(async response => {
            if (!response.ok) {
                return await response.text().then(errorText => {
                    nl.style.display="block"
                    nl.innerText = errorText;
                    hide.style.display="none"
                    if (errorText.includes("Nguyên Liệu")) {
                        themnl.style.display = "block";
                    }
                    if (errorText.includes("Nhà Cung Cấp")) {
                        themncc.style.display = "block";
                    }
                    throw new Error(errorText);
                });
            }
            else{
                reloadAndFetchData()
            }
        })
        .catch(error => {
            console.error( error);
        });
}
function reloadAndFetchData(){
    window.location.reload();
}
document.addEventListener("DOMContentLoaded", function() {
    getAllnl();
});
async function addnl(event){
    event.preventDefault()
    const ten=document.getElementById("tennl").value
    const mota=document.getElementById("motanl").value
    console.log(tennl)
    fetch(`http://localhost:8080/api/nguyenlieu/add`,{
        method:"POST",
        headers: {
            "Content-Type": "application/json"
        },
        body:JSON.stringify({ten,mota})
    })
        .then( response =>{
            response.json()
        })
        .then(data=>{
            alert("Thêm thành công")
        })
        .then(reload=>{
            reloadAndFetchData()
        })
        .catch(err =>{
            console.log( err)
        })
}


document.getElementById("tennguyenlieusearch").addEventListener("input", function() {
    const searchTerm = this.value.toLowerCase(); 
    searchItems(searchTerm);
});
async function searchItems(searchTerm) {
    const filteredData = await fetch(`http://localhost:8080/api/materials`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then( response => response.json())
        .catch(error => console.error('Error:', error));
    const filteredItems = filteredData.filter(item => {
        return item.tennguyenlieu.toLowerCase().includes(searchTerm);
    });

    const listnl = document.getElementById("listnl").getElementsByTagName("table")[0];
    listnl.innerHTML=""
        const headerRow = document.createElement("tr");
    
        const idHeader = document.createElement("th");
        idHeader.innerText = "ID";
        headerRow.appendChild(idHeader);
        const nguyenlieuHeader = document.createElement("th");
        nguyenlieuHeader.innerText = "Nguyên liệu";
        headerRow.appendChild(nguyenlieuHeader);
        const nhacungcapHeader = document.createElement("th");
        nhacungcapHeader.innerText = "Nhà cung cấp";
        headerRow.appendChild(nhacungcapHeader);
        const dongiaHeader = document.createElement("th");
        dongiaHeader.innerText = "Đơn giá";
        headerRow.appendChild(dongiaHeader);
        const soluongHeader = document.createElement("th");
        soluongHeader.innerText = "Số lượng";
        headerRow.appendChild(soluongHeader);
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
                tennlCell.innerText = item.tennguyenlieu;
                newRow.appendChild(tennlCell);

                const tennccCell = document.createElement("td");
                tennccCell.innerText = item.tennhacungcap;
                newRow.appendChild(tennccCell);

                const dongiaCell = document.createElement("td");
                dongiaCell.innerText = item.dongia;
                newRow.appendChild(dongiaCell);

                const soluongCell = document.createElement("td");
                soluongCell.innerText = item.soluong;
                newRow.appendChild(soluongCell);

                const suaCell = document.createElement("td");
                const suaButton = document.createElement("button");
                suaButton.innerText = "Sửa";
                suaButton.onclick = function() {
                    editItem(item.id,item.tennguyenlieu,item.tennhacungcap,item.dongia,item.soluong)
                }
                suaButton.classList.add("my-button");
                suaCell.appendChild(suaButton);
                newRow.appendChild(suaCell);

                const xoaCell = document.createElement("td");
                const xoaButton = document.createElement("button");
                xoaButton.innerText = "Xóa";
                xoaButton.onclick=function (){
                    deleteItem(item.id)
                }
                xoaButton.classList.add("my-button");
                xoaCell.appendChild(xoaButton);
                newRow.appendChild(xoaCell);

                listnl.appendChild(newRow);
    });
}
async function addncc(event){
    event.preventDefault()
    const ten=document.getElementById("tenncc").value
    const diachi=document.getElementById("diachincc").value
    const email=document.getElementById("emailncc").value
    const sdt=document.getElementById("sdtncc").value
    const mota=document.getElementById("motancc").value
    fetch(`http://localhost:8080/api/nhacungcap/add`,{
        method:"POST",
        headers: {
            "Content-Type": "application/json"
        },
        body:JSON.stringify({ten,diachi,email,sdt,mota})
    })
        .then(async response =>{
            response.json()
        })
        .then(data=>{
            alert("Thêm thành công")
        })
        .then(reload=>{
            reloadAndFetchData()
        })
        .catch(err =>{
            console.log( err)
        })
}
