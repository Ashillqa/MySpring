document.getElementById('LogData').addEventListener('submit',Lfun);
let unsLen,i,x,y;
let uns = [];
let pswds =[];
unsLen = 0;
pswLen = 0;


function redir(){
   // event.preventDefault();
   // let url= 'http://localhost:8080/index.html';
   // document.write("Redirecting to the url in 3 seconds...");
   // setTimeout(function(){window.location = url;}, 3000);
    for(i=0; i<unsLen; i++){
        if(uns[i]===x && pswds[i]===y){
            outcome();
        }else{
           document.getElementById('messing').innerHTML = ` Create a user`;
        }
    }
}

function Lfun(event) {

    event.preventDefault();
     x = document.getElementById('useName').value;
     y = document.getElementById('pwd').value;

    fetch('http://localhost:8080/getAllUsers')
        .then(function (res) {
            return res.json();
        })
        .then(function (data) {
            data.forEach((user) => {
                const {id, username, password} = user;
                uns.push(`${username}`);
                unsLen=uns.length;
                pswds.push(`${password}`);
            });
        }).then(redir)
}

function outcome(){
     let url= 'http://localhost:8080/index.html';
     document.write("Redirecting to the url in 3 seconds...");
     setTimeout(function(){window.location = url;}, 3000);
}