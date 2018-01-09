<#ftl strip_whitespace = true>


<#assign charset="UTF-8">
<#assign title="Informe notas alumnos-asig">

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
        </head>
        <script>
                 function cambiarSelectAsignatura(){
                    var id = document.getElementById("id_asig_lista").value;
                    var text = document.getElementById("id_asig_lista").options[document.getElementById('id_asig_lista').selectedIndex].text;
                        document.getElementById("asignatura").value = text;
                            
                }
            </script>
    <body>
        <#escape x as x?html>
        <div class="container">
        <div class="row justify-content-center">
                <div class="col-sm-9">
                    <h2>Informe - Notas de una asignatura</h2>
                    <h5>Por favor Selecciona la asignatura que deseas ver:</h5>
                    <form action="">
                        <select name="id_asig" id="id_asig_lista" onchange="cambiarSelectAsignatura()" >
                            <option disabled selected value> -- selecciona un Curso -- </option>
                <#list listaCursos as curso>
                            <option id ="asignatura.id" value="${asignatura.id}">${asignatura.nombre}</option>
                 </#list>                
                            </select> 
                        <input type="hidden" name="ACTION" id="ACTION" value="VIEW"/>
                        <input type="hidden" name="asignatura" id="asignatura" />
                        <button type="submit" class="btn btn-primary">Ver Informe</button>
                        </form>        
                    </div>
                </div>
            <div class="row justify-content-center">
                <div class="col-sm-10">
                <#if messageToUser??>
                    <div class="alert alert-primary" role="alert">
                ${messageToUser?js_string}  
                        </div>
                        </#if>
                    <ul>

                        <#if listadoInformeNotaAlumno??>
                        <h4><div class="alert alert-success text-center" role="alert">
                                Informe de la asignatura: ${asignaturaSeleccionada}
                                </div></h4>
                    <#list listadoInformeNotaAlumno as informe>
                        <br>
                        <hr> 
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre Alumno:</th>
                                    <td scope="col">${informe.alumno}</td>
                                    <th scope="col">Nota:</th>
                                    <td scope="col">

                                        <#list informe.profesores as profesor>
                                    ${profesor.nombre}<br>
                                        </#list>   

                                        </td>
                                    </tr>
                                </thead>
                            <tbody>
                                <tr>
                                    <th colspan="2">
                                        <div class="text-center">
                                            Alumno
                                            </div>
                                        </th>
                                    <th colspan="2">
                                        <div class="text-center">
                                            Calificación
                                            </div>
                                        </th>
                                    </tr>
                                <#list informe.notas as nota>
                                <tr>
                                    <td colspan="2">
                                        ${nota.nombre_alumno}
                                        </td>
                                    <td colspan="2">
                                        <div class="text-center">
                                        ${nota.nota}
                                            </div>
                                        </td>
                                    </tr>
                                </#list> 
                                </tbody>
                            </table>


                    </#list>   
                        </#if>
                        </ul>



                    </div>
                </div>

            </div>
        </div>
</#escape>
    <#include "/footBootstrap.ftl">

    </body>
</html>

