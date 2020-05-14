
function getSectData() {
    fetch('http://localhost:8080/getAllSectors')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {id,division} = user;
                document.getElementById('resultSect').innerHTML += `<div>
                
                    <h2 hidden> ID: ${id}</h2>
                    <h2> Category : ${division}</h2>
                    <p id="C${id}"></p>
                
            </div>` ;
            });
        }).then(getEmpv2)
}

function getEmpv2() {
    fetch('http://localhost:8080/getAllEmps')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {name, certs} = user;
                if(`${certs}`<3){ document.getElementById('C1').innerHTML += `<div>
                <ul>
                    <li> Name : ${name}</li>
                </ul>
            </div>` ;
                }else if (`${certs}`<5){
                    document.getElementById('C2').innerHTML += `<div>
                <ul>
                    <li> Name : ${name}</li>
                </ul>
            </div>` ;
                }else{
                    document.getElementById('C3').innerHTML += `<div>
                <ul>
                    <li> Name : ${name}</li>
                </ul>
            </div>` ;
                }

            });

        })

}