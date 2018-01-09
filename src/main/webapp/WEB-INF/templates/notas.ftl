<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Notas">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
        <title>Notas</title>
        
        <script>
            function cargarAlumno(id, nombre) {
                document.getElementById("idAlumno").value = id;
                document.getElementById("nombreAlumno").value = nombre;
            }
            function cargarAsignatura(id, nombre) {
                document.getElementById("idAsignatura").value = id;
                document.getElementById("nombreAsignatura").value = nombre;
            }
            function guardar() {
                document.getElementById("accion").value = "guardar";
            }
            function borrar() {
                document.getElementById("accion").value = "borrar";
            }
            function cargar() {
                document.getElementById("accion").value = "cargar";
            }
        </script>
        
        <script>
            function previousPage(){
                var offsetacutal =  document.getElementById("offset").value;

                if(offsetacutal==0){

                }else{
                    document.getElementById("offset").value = offsetacutal - 10;
                    document.getElementById("ACTION").value = "VIEW";
                    document.getElementById("formnotas").submit();
                }

            }

            function nextPage(){
                var offsetacutal =  document.getElementById("offset").value;
                document.getElementById("offset").value = offsetacutal + 10;
                document.getElementById("ACTION").value = "VIEW";
                document.getElementById("formnotas").submit();
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-inverse" style="border-radius: 0">
            <div class="container-fluid">
                <div style=" margin-right: 100px" class="navbar-header">
                    <span style="cursor: default" class="navbar-brand"><strong>${nombreUsuario}</strong></span>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="/sesion/alumnos">Alumnos</a></li>
                    <li><a href="/sesion/asignaturas">Asignaturas</a></li>
                    <li class="active"><a style="cursor: default; pointer-events: none" href="#">Notas</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="../users?accion=logout"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a>
                    </li>
                </ul>
            </div>
        </nav>
        
        <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID Alumno</th>
                        <th>Nombre Alumno</th>
                        <th>ID Asignatura</th>
                        <th>Nombre Asignatura</th>
                        <th>Nota</th>
                        </tr>
                </thead>
                <tbody>
                    <#list notas as nota>  
                    <tr>
                        <td>
                            ${nota.idAlumno}
                        </td> 
                            ${nota.alumno}
                        <td>
                            ${nota.idAsignatura}   
                        </td>
                            ${nota.asignatura}
                        <td>
                            ${nota.nota}
                        </td>
                    </tr>
                    </#list>
                </tbody>
        </table>

        <div class="pagination">
            <button onclick="previousPage();">&larr; Atrás</button>
            <button onclick="nextPage();">Siguiente &rarr;</button>
        </div>
        
        <#if messageToUser??>
            <div class="alert alert-primary" role="alert">
                ${messageToUser?js_string}    
            </div>
        </#if>
        
        <form id="formnotas" action="notas?">
            <input type="hidden" id="ACTION"  name="ACTION"/>
            <input type="hidden" id="offset"  name="offset" value="${offset}"/>
        </form>
        
        
        
        
        
        
        
        
        
        
        
        
            <div class="container">
            <div class="col-xs-8 col-xs-offset-2">
                <h1>Notas</h1>

                <span>Alumno: </span>
                <select id="alumno" onchange="cargarAlumno(this.value, this.options[this.selectedIndex].innerHTML)">
                    <option disabled selected>Selecciona un alumno</option>
                    <option disabled>-------------------------</option>
                    <#list alumnos as alumno> 
                        <option value="${alumno.id}" name="${alumno.nombre}">${alumno.nombre}</option>
                    </#list>
                </select>

                <span>Asignatura: </span>
                <select id="asignatura" onchange="cargarAsignatura(this.value, this.options[this.selectedIndex].innerHTML)">
                    <option disabled selected>Selecciona una asignatura</option>
                    <option disabled>-------------------------</option>
                    <#list asignaturas as asignatura> 
                        <option value="${asignatura.id}">${asignatura.nombre}</option>
                    </#list>
                </select>
                <br>
                <br>
                <br>
                <form action="notas">
                    <table class="table-condensed" style="margin: auto">
                        <tr>
                            <td>
                                ALUMNO
                                <br>
                                <input type="hidden" id="idAlumno" name="idAlumno" size="1" value="${idAlu}">
                                <input type="text" name="nombreAlumno" id="nombreAlumno" value="${nomAlu}">
                            </td>
                            <td>
                                ASIGNATURA
                                <br>
                                <input type="hidden" id="idAsignatura" name="idAsignatura" size="1" value="${idAsig}">
                                <input type="text" name="nombreAsignatura" id="nombreAsignatura" value="${nomAsig}">
                            </td>
                            <td>
                                <br>
                                <button onclick="cargar()">Cargar</button>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                NOTA <input type="text" value="${nota.nota}" id="nota" name="nota" size="1">
                            </td>
                            <td>
                                <br>
                                <input type="hidden" id="accion" name="accion" value="">
                                <button onclick="guardar()">Guardar</button>
                                <button onclick="borrar()">Borrar</button>
                            </td>
                        </tr>
                    </table>
                </form>
                <br>
                <h3>${mensaje}</h3>
            </div>
        </div>
    </body>
</html>
