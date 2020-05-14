document.getElementById('postData').addEventListener('submit', postData);



function postData(event){
    event.preventDefault();

    let empName = document.getElementById('name').value
    let certifs = document.getElementById('certificates').value;
    fetch('http://localhost:8080/createEmp', {
        method: 'POST',
        headers : {'Content-Type': 'application/json'},
        body:JSON.stringify({name:empName,certs:certifs})
            }).then((res) => res.json())
            .then((data) =>  console.log(data)).then(EmpToSect)
            .catch((err)=>console.log(err))

        document.getElementById('message').innerHTML=`we have created ${empName} as an employee`;
}


