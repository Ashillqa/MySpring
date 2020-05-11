

function getData() {
    fetch('http://localhost:8080/getAllEmps')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {id,name, certs} = user;
                document.getElementById('result').innerHTML += `<div>
                <ul>
                    <li hidden> ID: ${id}</li>
                    <li> Name : ${name}</li>
                    <li> certificates : ${certs} </li>
                    <button id="E${id}">Delete</button>
                </ul>
            </div>` ;
            });

        })
}

