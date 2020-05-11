//delbut = document.getElementById('E${id}')

function func(id) {
   fetch('http://localhost:8080/deleteEmp/'+id,{
        method: 'DELETE'
    }).then(res => res.text())
        .then(res => console.log(res)).then(rel)
}
function rel() {
    location.reload();
}