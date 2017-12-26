<#ftl strip_whitespace = true>




<#assign charset="UTF-8">
<#assign title="Asignaturas">
<#assign content>
This is content
</#assign>
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
        </head>
    <body>
        <table class="table">
            <tr>
                <th></th>
                <th>Nombre</th>
                <th>Curso</th>                

                </tr>
            <#list listaAsignaturas as asignatura>
            <tr>
                <td><button id="cargarAsignatura" onClick="
                cargarAsignatura()">Cargar</button>
                    </td>
                <td>
                    ${asignatura.nombre}
                    </td>
                <td>
                    ${asignatura.curso}
                    </td>
                </tr>
  </#list>

            </table>




        </body>
    </html>
