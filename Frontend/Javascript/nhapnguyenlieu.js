const nccs=document.getElementById("hidenccs")
const ncc=document.getElementById("themncc")
const nl=document.getElementById("themnl")
const nls=document.getElementById("hidenls")
const m=document.getElementById("hide")
const listnl = document.getElementById("listnl").getElementsByTagName("table")[0];
async function getAllncc() {
    nccs.style.display="block"
    await fetch(`http://localhost:8080/api/nhacungcap`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then( response => response.json())
        .then( data => {
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
            const motaHeader = document.createElement("th");
            motaHeader.innerText = "Mô tả";
            headerRow.appendChild(motaHeader);
            const them = document.createElement("th");
            headerRow.appendChild(them);
            listnl.appendChild(headerRow);
            data.forEach(item => {
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
    
                const motaCell = document.createElement("td");
                motaCell.innerText = item.mota;
                newRow.appendChild(motaCell);
    
                const suaCell = document.createElement("td");
                const suaButton = document.createElement("button");
                suaButton.innerText = "Chọn";
                suaButton.onclick = function() {
                    localStorage.setItem('idncc', item.id.toString());
                    ncc.style.display="none"
                    choosencc()
                }
                suaButton.classList.add("my-button");
                suaCell.appendChild(suaButton);
                newRow.appendChild(suaCell);
    
                listnl.appendChild(newRow);
            })
            
        })
        .catch(error => console.error('Error:', error));
}


document.getElementById("tennhacungcapsearch").addEventListener("input", function() {
    const searchncc = this.value.toLowerCase(); 
    searchNcc(searchncc);
});
async function searchNcc(searchNcc) {

    const filteredData = await fetch(`http://localhost:8080/api/nhacungcap`, {
        headers: {
            "Content-Type": "application/json"
        },
    })
        .then( response => response.json())
        .catch(error => console.error('Error:', error));
    const filteredItems = filteredData.filter(item => {
        return item.ten.toLowerCase().includes(searchNcc);
    });
    listnl.innerHTML=""
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
            const motaHeader = document.createElement("th");
            motaHeader.innerText = "Mô tả";
            headerRow.appendChild(motaHeader);
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

            const motaCell = document.createElement("td");
            motaCell.innerText = item.mota;
            newRow.appendChild(motaCell);

            const suaCell = document.createElement("td");
            const suaButton = document.createElement("button");
            suaButton.innerText = "Chọn";
            suaButton.onclick = function() {
                localStorage.setItem('idncc', item.id.toString());
                ncc.style.display="none"
                choosencc()
            }
            suaButton.classList.add("my-button");
            suaCell.appendChild(suaButton);
            newRow.appendChild(suaCell);

            listnl.appendChild(newRow);
    });
}
document.addEventListener("DOMContentLoaded", function() {
    getAllncc();
});
async function choosencc(){
        nls.style.display="block"
        nccs.style.display="none"
        await fetch(`http://localhost:8080/api/nguyenlieu`, {
            headers: {
                "Content-Type": "application/json"
            },
        })
            .then(async response => response.json())
            .then(async data => {
                listnl.innerHTML=""
                const headerRow = document.createElement("tr");
                const idHeader = document.createElement("th");
                idHeader.innerText = "ID";
                headerRow.appendChild(idHeader);
                const tenHeader = document.createElement("th");
                tenHeader.innerText = "Tên";
                headerRow.appendChild(tenHeader);
                const motaHeader = document.createElement("th");
                motaHeader.innerText = "Mô tả";
                headerRow.appendChild(motaHeader);
                const them = document.createElement("th");
                headerRow.appendChild(them);
                listnl.appendChild(headerRow);
                data.forEach(item => {
                    const newRow = document.createElement("tr");
    
                    const idnccCell = document.createElement("td");
                    idnccCell.innerText = item.id;
                    newRow.appendChild(idnccCell);
        
                    const tennlCell = document.createElement("td");
                    tennlCell.innerText = item.ten;
                    newRow.appendChild(tennlCell);
        
                    const motaCell = document.createElement("td");
                    motaCell.innerText = item.mota;
                    newRow.appendChild(motaCell);
        
                    const suaCell = document.createElement("td");
                    const suaButton = document.createElement("button");
                    suaButton.innerText = "Chọn";
                    suaButton.onclick = function() {
                        localStorage.setItem('idnl', item.id.toString());
                        nl.style.display="none"
                        choosenl()
                    }
                    suaButton.classList.add("my-button");
                    suaCell.appendChild(suaButton);
                    newRow.appendChild(suaCell);
        
                    listnl.appendChild(newRow);
                })
                
            })
            .catch(error => console.error('Error:', error));
    }
    
    document.getElementById("tennguyenlieusearch").addEventListener("input", function() {
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
        listnl.innerHTML=""
                const headerRow = document.createElement("tr");
                const idHeader = document.createElement("th");
                idHeader.innerText = "ID";
                headerRow.appendChild(idHeader);
                const tenHeader = document.createElement("th");
                tenHeader.innerText = "Tên";
                headerRow.appendChild(tenHeader);
                const motaHeader = document.createElement("th");
                motaHeader.innerText = "Mô tả";
                headerRow.appendChild(motaHeader);
                const them = document.createElement("th");
                headerRow.appendChild(them);
                listnl.appendChild(headerRow);
        filteredItems.forEach(item => {
            const newRow = document.createElement("tr");
    
            const idnccCell = document.createElement("td");
            idnccCell.innerText = item.id;
            newRow.appendChild(idnccCell);

            const tennlCell = document.createElement("td");
            tennlCell.innerText = item.ten;
            newRow.appendChild(tennlCell);

            const motaCell = document.createElement("td");
            motaCell.innerText = item.mota;
            newRow.appendChild(motaCell);

            const suaCell = document.createElement("td");
            const suaButton = document.createElement("button");
            suaButton.innerText = "Chọn";
            suaButton.onclick = function() {
                localStorage.setItem('idnl', item.id.toString());
                nl.style.display="none"
                choosenl()
            }
            suaButton.classList.add("my-button");
            suaCell.appendChild(suaButton);
            newRow.appendChild(suaCell);

            listnl.appendChild(newRow);
        });
    }
    
    async function choosenl(){
        nls.style.display="none"
        m.style.display="block"
        listnl.innerHTML=""
    }
    async function nhaphang(){
        event.preventDefault()
        const idncc = localStorage.getItem('idncc');
        const idnl = localStorage.getItem('idnl');
        const dongia=document.getElementById("dongia").value
        const soluong=document.getElementById("soluong").value
        const ngaynhap=document.getElementById("ngaynhap").value
        const mota=document.getElementById("mota").value
        const luuhoadon = document.getElementById("luuhoadon");
        const cuahangid=1
        const username = localStorage.getItem("token");
        const userData = JSON.parse(username);
        const idnd=userData.id
        const data = {
            nhacungcapid: idncc,
            nguyenlieuid:idnl,
            dongia: dongia,
            soluong: soluong,
            ngaynhap:ngaynhap,
            cuahangid:cuahangid,
            mota:mota,
            nguoidungid:idnd
        };
        await fetch(`http://localhost:8080/api/nhaphang/add`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(response =>{
            return response.json();
        })
        .then(data=>{
            console.log(data)
            m.style.display="none"
            hoadon.style.display="block"
            document.getElementById('id').innerText = data.id;
            document.getElementById('ngayxuatdon').innerText = data.ngaynhap;
            document.getElementById('cuahang').innerText = data.tencuahang;
            document.getElementById('nguoidung').innerText = data.tennhanvien;
            document.getElementById('nguyenlieu').innerText = data.tennguyenlieu;
            document.getElementById('nhacungcap').innerText = data.tennhacungcap;
            document.getElementById('tongtien').innerText = data.tongtien;
            document.getElementById('motahd').innerText = data.mota;
            const idnh=data.id
            console.log(idnh)
            const ngayxuatdon=data.ngaynhap
            const tongtien=data.tongtien
            luuhoadon.addEventListener("click",async function() {
                const data = {
                    id:idnh,
                    tongtien:tongtien,
                    soluong: soluong,
                    ngayxuatdon:ngayxuatdon,
                    mota:mota,
                    nguoidungid:idnd
                };
                await fetch(`http://localhost:8080/api/hoadon/add`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            })
            .then(response =>{
                alert("Thêm hóa đơn thành công")
            })
            .catch(err =>{
                console.log(err)
            })
        })
    })
    .catch(err =>{
        console.log(err)
    })
}
function themnccnll(event){
    event.preventDefault()
    ncc.style.display="block"
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
            ncc.style.display="none"
        })
        .then(reload=>{
            reloadAndFetchData()
        })
        .catch(err =>{
            console.log( err)
        })
}
async function themnlnll(event){
    event.preventDefault()
    nl.style.display="block"
}
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
            nl.style.display="none"
        })
        .then(reload=>{
            reloadAndFetchData()
        })
        .catch(err =>{
            console.log( err)
        })
}