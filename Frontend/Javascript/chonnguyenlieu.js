
const nl=document.getElementById("themnl")
const nls=document.getElementById("hidenls")
const listnl = document.getElementById("listnl").getElementsByTagName("table")[0];
async function getAllnl(){
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
document.addEventListener("DOMContentLoaded", function() {
    getAllnl();
});
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
    function choosenl(){
        window.location.href="nhaphang.html"
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
function reloadAndFetchData(){
    window.location.reload();
}