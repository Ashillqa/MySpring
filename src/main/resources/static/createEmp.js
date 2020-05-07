document.getElementById('postData').addEventListener('submit', postData);

function postData(event){
    event.preventDefault();

    let empName = document.getElementById('name').value;
    let tittle = document.getElementById('tittle').value;
    let contL = document.getElementById('contL').value;


    fetch('http://localhost:8080/createEmp', {
        method: 'POST',
        headers : {'Content-Type': 'application/json'},
        body:JSON.stringify({name:empName,jobTitle:tittle, contLength:contL})
    }).then((res) => res.json())
        .then((data) =>  console.log(data))
        .catch((err)=>console.log(err))

    document.getElementById('message').innerHTML=`we have created ${empName} as an employee`;
}