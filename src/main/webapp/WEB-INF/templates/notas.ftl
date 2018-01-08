<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Notas">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/css/style.css">
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
                        ${nota.notita}
                    </td>
                </tr>
                </#list>
            </tbody>
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
        <div class="container">
            <div class="col-xs-8 col-xs-offset-2">
                <h1>Notas</h1>

                <span>Alumno: </span>
                <select id="alumno" onchange="cargarAlumno(this.value, this.options[this.selectedIndex].innerHTML)">
                    <option disabled selected>Selecciona un alumno</option>
                    <option disabled>-------------------------</option>
                    <c:forEach items="${alumnos}" var="alumno">
                        <option value="${alumno.id}" name="${alumno.nombre}">${alumno.nombre}</option>
                    </c:forEach>
                </select>

                <span>Asignatura: </span>
                <select id="asignatura" onchange="cargarAsignatura(this.value, this.options[this.selectedIndex].innerHTML)">
                    <option disabled selected>Selecciona una asignatura</option>
                    <option disabled>-------------------------</option>
                    <c:forEach items="${asignaturas}" var="asignatura">
                        <option value="${asignatura.id}">${asignatura.nombre}</option>
                    </c:forEach>
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
