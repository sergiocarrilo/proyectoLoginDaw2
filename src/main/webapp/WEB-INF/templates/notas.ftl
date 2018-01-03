<#ftl strip_whitespace = true>

<#setting boolean_format=computer>
<#import "/libs/mylib.ftl" as my>

<#assign charset="UTF-8">
<#assign title="Notas">
<#assign content>
This is content
</#assign>
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/style.css">
        <script>
            function cargarAlumno(id, nombre) {
                document.getElementById("idAlumno").value = id;
                document.getElementById("nombreAlumno").value = nombre;
            }

        </script>
    </head>
    <body><#if content??>
        <div>${content}</div>
		<#else>
        <div>No content</div>
		</#if>
        <table  class="table">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Asignatura</th>
                    <th>Nota</th>
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
        </body>
    </html>
