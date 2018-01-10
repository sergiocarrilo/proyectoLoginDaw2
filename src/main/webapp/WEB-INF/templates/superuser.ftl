<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="ProyectoLogin">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <script>

        function cambiarAdmin(id,idpermiso) {
            var comprobacion = document.getElementById("id_permiso").checked;
                
            if(idpermiso == 0){
                
                document.getElementById("iduser").value = id;
                document.getElementById("idpermiso").value = idpermiso;
                document.getElementById("ACTION").value = "HACERADMIN";
                document.getElementById("formsupuser").submit();
            }else{
                
                document.getElementById("iduser").value = id;
                document.getElementById("idpermiso").value = idpermiso;
                document.getElementById("ACTION").value = "QUITARADMIN";
                document.getElementById("formsupuser").submit();
            }
        }

        
        function previousPage(){
            var offsetacutal =  document.getElementById("offset").value;
                
            if(offsetacutal==0){

            }else{
                document.getElementById("offset").value = offsetacutal - 10;
                document.getElementById("ACTION").value = "VIEW";
                document.getElementById("formsupuser").submit();
            }
               
        }
            
        function nextPage(){
            var offsetacutal =  parseInt(document.getElementById("offset").value);
            document.getElementById("offset").value = offsetacutal + 10;
            document.getElementById("ACTION").value = "VIEW";
            document.getElementById("formsupuser").submit();
        }
            </script>
        </head>

    <body>  
        <#include "/menuTemplate.ftl">
        <h2>SuperUsuario</h2>
        <table  class="table">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Fecha Activacion</th>
                    <th>Administrador</th>
                    </tr>
                </thead>
            <#list usuarios as usuario>
            <tbody>
                <tr>
                    <td>
                       ${usuario.id}
                        </td> 
                    <td>
                        ${usuario.nombre}
                        </td>
                    <td>
                        ${usuario.email}
                        </td>
                    <td>
                        ${usuario.fecha_activacion?string["dd-MM-yyyy"]}
                        </td>
                    <td>
                        <input type="checkbox" id="id_permiso" name="id_permiso"  
                            <#if usuario.permiso == 2> checked <#else>                      
                            </#if> onchange="cambiarAdmin('${usuario.id}','${usuario.permiso}');"/>
                        </td>
                    </tr>
                </tbody>
            </#list>	
            </table>
        <div class="pagination">
            <button onclick="previousPage();">&larr; Previous</button>
            <button onclick="nextPage();">Next &rarr;</button>
        </div>
        <#if messageToUser??>
                    <div class="alert alert-primary" role="alert">
                ${messageToUser?js_string}    
                        </div>

        </#if>

        <form id="formsupuser" action="superuser?">
            <input type="hidden" id="iduser" name="iduser"/>
            <input type="hidden" id="idpermiso" name="idpermiso"/>
            <input type="hidden" id="ACTION"  name="ACTION"/>
            <input type="hidden" id="offset"  name="offset" value="${offset}"/>

            </form>
        </body>
    </html>
