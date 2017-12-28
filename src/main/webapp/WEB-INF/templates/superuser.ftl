<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="ProyectoLogin">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>

        function cambiarAdmin(id,idpermiso) {
            document.getElementById("iduser").value = id;
            document.getElementById("idpermiso").value = idpermiso;
            document.getElementById("op").value = "HACERADMIN";
            document.getElementById("formsupuser").submit();
        }
        
        function previousPage(){
            var offsetacutal =  document.getElementById("offset").value;
                
            if(offsetacutal==0){

            }else{
                document.getElementById("offset").value = offsetacutal - 10;
                document.getElementById("op").value = "VIEW";
                document.getElementById("formsupuser").submit();
            }
               
        }
            
        function nextPage(){
            var offsetacutal =  document.getElementById("offset").value;
            document.getElementById("offset").value = offsetacutal + 10;
            document.getElementById("op").value = "VIEW";
            document.getElementById("formsupuser").submit();
        }
            </script>
        </head>

    <body>  

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
                        <input type="button" value="${usuario.id}"/>
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
        <form id="formsupuser" action="superuserservlet?">
            <input type="hidden" id="iduser" name="iduser"/>
            <input type="hidden" id="idpermiso" name="idpermiso"/>
            <input type="hidden" id="op"  name="op"/>
            <input type="hidden" id="offset"  name="offset" value="${offset}"/>

            </form>
        </body>
    </html>
