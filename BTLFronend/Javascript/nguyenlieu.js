document.addEventListener("DOMContentLoaded", function () {
    getHd();
    getnl()
});
const tbody = document.querySelector('.listnl tbody');
async function getHd() {
    const idhdn = JSON.parse(localStorage.getItem('idhdn'));
    try {
        const response = await fetch(`http://localhost:8080/api/hoadonnhap`, {
            headers: {
                "Content-Type": "application/json"
            }
        });
        
        const data = await response.json();
        data.forEach(item => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${item.id}</td>
                <td>${item.ngayxuatdon}</td>
                <td>${item.tennv}</td>
                <td>${item.tenncc}</td>
                <td>${item.tongtien}</td>
            `;
            tbody.appendChild(tr);
        });
    } catch (err) {
        console.error(err);
    }
}
