<#ftl strip_whitespace = true>
<#assign charset="UTF-8">
<#assign title="Tareas Profesor">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
                 function cogerDatosAsig(){
                    var id = document.getElementById("id_asig_lista").value;
                    document.getElementById("idasignatura").value = id; 
                    document.getElementById("ACTION").value="PONERTAREA";
                    
                }
                    
                    function crearTarea(){
                        document.getElementById("formtarea").submit(); 
                    }
        </script>
    </head>
    <body>
        <#escape x as x?html>
        <div class="container">
            <#include "/menuTemplate.ftl">
            <div class="row justify-content-center">
                <div class="col-sm-9">
                    <h2>Tareas - Asignar tareas de una asignatura</h2>
                    <h5>Por favor Selecciona la asignatura en la cual desea asignar tarea:</h5>
                    <form action="" id="form">
                        <select name="id_asig" id="id_asig_lista" onchange="mostrarListaAlumno()" >
                            <option disabled selected value> -- selecciona una Asignatura -- </option>
                <#list asignaturas as asignatura>
                            <option id ="asignatura.id_asignatura" value="${asignatura.id_asignatura}">${asignatura.nombre}</option>
                 </#list>                
                            </select> 
                        
                        
                       
                    </form>   
            </br>
            <button type="button" class="btn btn-primary" onclick="cogerDatosAsig();" data-toggle="modal" data-target="#modalTarea">Insertar Asignatura</button>
            <div class="modal fade" id="modalTarea" tabindex="-1" role="dialog" aria-labelledby="modalTarea" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" >Insertar Tarea</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form id="formtarea" action="">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Nombre Tarea:</label>
                                        <input type="text" name="name" class="form-control" id="tarea">
                                        </div>

                                   <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Fecha de Entrega:</label>
                                        <input type="date" name="fecha_entrega" class="form-control" id="fechaentrega">

                                    </div>
                                        <input type="hidden" name="ACTION" class="form-control" id="ACTION" value="VIEW">   
                                        <input type="hidden" name="idasignatura" id="idasignatura" />
                                    </div>
                                    <div class="modal-footer">
                                        <div class="form-group">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                            <button type="button" onclick="crearTarea();" class="btn btn-primary">INSERTAR</button>
                                            </div>
                                        </div>
                                    </form>
                                    </div>

                            </div>
                    </div>
                </div>
            </div>
           </div>
        </div>
        </#escape>
        <#include "/footBootstrap.ftl">

    </body>
    </html>
