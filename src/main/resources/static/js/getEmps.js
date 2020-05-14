

function getData() {
    fetch('http://localhost:8080/getAllEmps')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {id,name, certs,sector} = user;
                document.getElementById('result').innerHTML += `<div>
                <ul>
                    <li hidden> ID: ${id}</li>
                    <li> Name : ${name}</li>
                    <li> certificates : ${certs} </li>
                    <button onclick="func(${id})">Delete</button><span>
                    <p>Update certificates</p><input id="U${id}" type="number" min="0">
                    <button onclick="upd(${id},'${name}')">Update</button></span>
                </ul>
            </div>` ;
            });

        })
}

