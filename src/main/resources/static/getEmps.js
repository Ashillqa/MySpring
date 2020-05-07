

function getData() {
    fetch('http://localhost:8080/getAllEmps')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {name, jobTitle} = user;
                document.getElementById('result').innerHTML += `<div>
                <ul>
                    <li> Name : ${name}</li>
                    <li> Job : ${jobTitle} </li>
                </ul>
            </div>` ;
            });

        })
}

