// Call the dataTables jQuery plugin
$(document).ready(function() {
cargarUsers();
  $('#users').DataTable();
});
 async function cargarUsers(){


   const request = await fetch('api/user', {
     method: 'GET',
     headers: getHeaders()
  });
  const users = await request.json();



   let listadoHtml='';
   for(let user of users){
    let botonEliminar = '<a href="#" onclick="eliminarUsuario('+user.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

   let userHtml = ' <tr><td>'+user.id+'</td><td>'+user.name+''+user.lastname+'</td><td>'+user.email+'+</td><td>'+botonEliminar+'</td></tr>'
listadoHtml += userHtml;
   }
     document.querySelector('#users tbody').outerHTML = listadoHtml;
     }
     function getHeaders(){
     return{
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
       };
    }

    async function eliminarUsuario(id) {

         if (!confirm('¿Desea eliminar este usuario?')) {
           return;
         }

    const request = await fetch('api/users/' + id, {
       method: 'DELETE',
       headers: getHeaders()
     });

     location.reload()
   }

