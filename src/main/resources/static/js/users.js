//document.getElementById('LogData').addEventListener("submit", getUse);
function getUse() {
    fetch('http://localhost:8080/getAllUsers')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {id,username, password} = user;
               document.getElementById('messing').innerHTML += `<div>
                <ul>
                    <li > ID: ${id}</li>
                    <li> Name : ${username}</li>
                </ul>
            </div>` ;
            });

        })
}