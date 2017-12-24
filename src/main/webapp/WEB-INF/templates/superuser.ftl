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

        function hacerAdmin() {

                document.getElementById("op").value = "HACERADMIN";
            }

            function cargarUsuario(id, nombre) {
                document.getElementById("nombre").value = nombre;
                document.getElementById("iduser").value = id;
                
               

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
                    <input type="button" value="cargar ${usuario.id}" 
                               onclick="cargarUsuario('${usuario.id}',
                                                   '${usuario.nombre}');"/>
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
                       <input type="checkbox" id="id_permiso" name="id_permiso"  <#if usuario.id_permiso == 2> checked <#else>
                        
                    </#if>/>
                    
                </td>
            </tr>
            </#list>	
        </table>
        <form id="formalum" action="alumnos?">
            <input type="hidden" id="iduser" name="iduser"/>
            <input type="hidden" id="op"  name="op"/>
            <label>Nombre</label><input type="text" id="nombre" name="nombre" size="12"/>
            <label>Admin</label><input type="checkbox" id="admin" name="admin" />
            <br>
            <button type="submit" onclick="hacerAdmin();" >Hacer admin.</button>

        </form>
    </body>
</html>
