<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="ProyectoLogin">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>

        function cambiarAdmin(id,idpermiso) {
                document.getElementById("iduser").value = id;
                document.getElementById("idpermiso").value = idpermiso;
                document.getElementById("op").value = "HACERADMIN";
                document.getElementById("formsupuser").submit();
            }

            
        </script>
    </head>
    
    <body>  
        <#if content??>
            <div>${content}</div>
        <#else>
            <div>No content</div>
        </#if>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Email</td>
                <td>Fecha Activacion</td>
                <td>Administrador</td>
            </tr>
            <#list usuarios as usuario>
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
            </#list>	
        </table>
        <form id="formsupuser" action="superuserservlet?">
            <input type="hidden" id="iduser" name="iduser"/>
            <input type="hidden" id="idpermiso" name="idpermiso"/>
            <input type="hidden" id="op"  name="op"/>
            

        </form>
    </body>
</html>
