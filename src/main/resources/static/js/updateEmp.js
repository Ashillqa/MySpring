function upd(id, name){
    let certs = document.getElementById(`U${id}`).value

    fetch('http://localhost:8080/updateEmp/'+id, {
        method: 'PUT',
        headers : {'Content-Type': 'application/json'},
        body:JSON.stringify({id:id,name:name,certs:certs})
    }).then((res) => res.json())
        .then((data) =>  console.log(data)).then(relU)
        .catch((err)=>console.log(err))
}


function relU() {
    location.reload();
}



