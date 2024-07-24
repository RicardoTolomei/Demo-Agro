// Call the dataTables jQuery plugin
$(document).ready(function() {

  //onready
});
 async function registerUsers(){
 let datos = {};
 datos.name = document.getElementById("txtNombre").value
 datos.lastname = document.getElementById("txtApellido").value
 datos.email = document.getElementById("txtEmail").value
 datos.password = document.getElementById("txtPassword").value

let repetirPassword = document.getElementById("txtRepetirPassword").value

if(datos.password != repetirPassword){
alert("La contraseña que escribiste es diferente")
return
}


 const request = await fetch('api/user', {
     method: 'POST',
     headers: {
       'Accept': 'application/json',
       'Content-Type': 'application/json'

},
body: JSON.stringify(datos)
});
const users = await request.json();
   }
