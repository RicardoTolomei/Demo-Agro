// Call the dataTables jQuery plugin
$(document).ready(function() {

  //onready
});
 async function registerUsers(){
 let datos = {};


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
