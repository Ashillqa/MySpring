
function getSectData() {
    fetch('http://localhost:8080/getAllSectors')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {id,division} = user;
                document.getElementById('resultSect').innerHTML += `<div>
                <ul>
                    <li hidden> ID: ${id}</li>
                    <li> Category : ${division}</li>
                </ul>
            </div>` ;
            });
        })
}