// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarUsers();
  $('#users').DataTable();
});
 async function cargarUsers(){


   const request = await fetch('api/user', {
     method: 'GET',
     headers: {
       'Accept': 'application/json',
       'Content-Type': 'application/json'

}
});

   const users = await request.json();

   console.log(users);
   let listadoHtml='';
   for(let user of users){

   let userHtml = ' <tr><td>'+user.id+'</td><td>'+user.name+''+user.lastname+'</td><td>'+user.email+'+</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'
listadoHtml += userHtml;
   }


   document.querySelector('#users tbody').outerHTML = listadoHtml;

 }