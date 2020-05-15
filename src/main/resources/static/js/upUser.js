

function details() {
    fetch('http://localhost:8080/getAllUsers')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {id, username, password} = user;
                document.getElementById('resultUser').innerHTML += `<div>
                <ul>
                    <li hidden>${id}</li>
                    <li> Hello ${username}</li>
                    <button onclick="func(${id})">Delete</button><span>
                    <p>New Password</p><input id="P${id}" type="password" required>
                    <button onclick="updP(${id},'${name}','${password}')">Update</button></span>
                </ul>
            </div>` ;
            });
        })
}