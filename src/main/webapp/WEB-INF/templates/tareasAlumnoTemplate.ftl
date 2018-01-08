<#assign charset="UTF-8">
<#assign title="Mis Tareas - Alumno">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>

<#escape x as x?html>
        <div class="container">
            <#include "/menuTemplate.ftl">

            <div class="row justify-content-center">
                <div class="col-sm-9">
                    <h2>Mis Tareas - </h2>

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

                        <#if listaTareasAlumno??>


                        <br>
                        <hr> 
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>                                    
                                    <th scope="col">Asignatura</th>
                                    <th scope="col">Tarea</th>
                                    <th scope="col">Fecha Entrega</th>
                                    <th scope="col">HECHO</th>
                                    <th scope="col"/>                                     
                                    </tr>
                                </thead>
                            <tbody>
                                <#list listaTareasAlumno as tarea>
                                <tr>
                                    <td>
                                        <div class="text-center">
                                            ${tarea.nombre}
                                            </div>
                                        </td>
                                    <td >
                                        <div class="text-center">
                                            ${tarea.tarea}
                                            </div>
                                        </td>
                                    <td >

                                            ${tarea.fecha_entrega}

                                        </td>
                                    <td >

                                            ${tarea.hecho?string("yes", "no")}

                                        </td>
                                    <td >

                                           <button>Actualizar</button>

                                        </td>
                                    </tr>
</#list>   
                                </tbody>
                            </table>



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
