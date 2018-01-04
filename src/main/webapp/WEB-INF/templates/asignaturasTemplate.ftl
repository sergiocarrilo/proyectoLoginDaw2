<#ftl strip_whitespace = true>







<#assign charset="UTF-8">
<#assign title="Asignaturas© ">
<#assign content>
This is content
</#assign>
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
            function cargarAsignatura(id_as, id_ascu, id_curso) {
                document.getElementById("id").value = id_ascu;
                document.getElementById("id_asignatura_ls").value = id_as;
                //document.getElementById("nombre").value = nombre;
                //document.getElementById("comboBox").options.namedItem("3").selected=true;
                document.getElementById("id_curso_ls").value = id_curso;
                

            }
                function cambiarSelectAsignatura(){
                    var id = document.getElementById("id_asignatura_lista").value;
                    var text = document.getElementById("id_asignatura_lista").options[document.getElementById('id_asignatura_lista').selectedIndex].text;
                        document.getElementById("nombre").value = text;
                            document.getElementById("id_asignatura").value = id;
}
            function cambiarSelectCurso(){
                    var id = document.getElementById("id_curso_lista").value;
                    var text = document.getElementById("id_curso_lista").options[document.getElementById('id_curso_lista').selectedIndex].text;
                        document.getElementById("curso").value = text;
                            document.getElementById("id_curso").value = id;
}
    
            </script>
        </head>
    <body>        
        <#escape x as x?html>
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <table class="table">
                    <tr>
                        <th></th>
                        <th>Nombre</th>
                        <th>Curso</th>                

                        </tr>


            <#list listaAsignaturaCurso as asignatura>
                    <tr>

                        <td><button id="cargarAsignatura" onClick="
                cargarAsignatura(${asignatura.id_asignatura},'${asignatura.id}','${asignatura.id_curso}')">Cargar</button>
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
                </div>

            <div class="col-sm-2"></div>
            </div>
        <div class="row justify-content-center">
            <div class="col-sm-6 ">
        <#if messageToUser??>
                <div class="alert alert-primary" role="alert">
                ${messageToUser?js_string}    
                    </div>

        </#if>
                </div>
            </div>
        <div class="row">
            <div class="col-sm-4">
                <h3>Asignaturas</h3> 
                <select name="id_asignatura_lista" id="id_asignatura_lista" onchange="cambiarSelectAsignatura()">
                    <option disabled selected value> -- selecciona una Asignatura-- </option>
                <#list listaAsignaturas as asig>
                    <option id ="asig.id" value="${asig.id}">${asig.nombre}</option>
                 </#list>                
                    </select> 
                <form action="asignaturas">                    

                    <br>
                    Nombre:
                    <input type="hidden" name="id_asignatura" id="id_asignatura">
                    <input type="text" name="nombre" id="nombre">
                    <br>
                    <input type="submit" name="ACTION" value="INSERT_ASIGNATURA">
                    <input type="submit" name="ACTION" value="UPDATE_ASIGNATURA">
                    <input type="submit" name="ACTION" value="DELETE_ASIGNATURA">
                    </form>
                </div>
            <div class="col-sm-4">

                <h3>Cursos</h3>
                <select name="id_curso_lista" id="id_curso_lista" onchange="cambiarSelectCurso()">
                    <option disabled selected value> -- selecciona un Curso -- </option>
                <#list listaCursos as curso>
                    <option id ="curso.id" value="${curso.id}">${curso.curso}</option>
                 </#list>                
                    </select> 
                <form action="asignaturas">                    

                    <br>
                    Nombre:
                    <input type="hidden" name="id_curso" id="id_curso">
                    <input type="text" name="curso" id="curso">
                    <br>
                    <input type="submit" name="ACTION" value="INSERT_CURSO">
                    <input type="submit" name="ACTION" value="UPDATE_CURSO">
                    <input type="submit" name="ACTION" value="DELETE_CURSO">
                    </form>
                </div>
            <div class="col-sm-4">
                <h3>Asignaturas - Cursos</h3>
                <form action="asignaturas" >

                    Nombre:
                    <select name="id_asignatura" id="id_asignatura_ls">
                <#list listaAsignaturas as asig>
                        <option id ="asig.id" value="${asig.id}">${asig.nombre}</option>
                 </#list>                
                        </select>    
                    <br>
                    Curso:
                    <select name="id_curso" id="id_curso_ls">
                <#list listaCursos as curso>
                        <option id ="curso.id" value="${curso.id}">${curso.curso}</option>
                 </#list>                
                        </select>            
                    <input type="hidden" name="id" id="id"/>


                    <br>
                    <input type="submit" name="ACTION" value="INSERT">
                    <input type="submit" name="ACTION" value="UPDATE">
                    <input type="submit" name="ACTION" value="DELETE">
                    </form>
                </div>
            </div>



</#escape>
        </body>
    </html>
