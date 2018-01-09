<#assign baseUrl="${baseUrlServer}">
<#assign super=1 admin=2 profe=3 alumno=4>


<!--Pendiente de Terminar -->

<nav class="navbar navbar-expand-lg navbar-light bg-light  ">
    <a class="navbar-brand" href="${baseUrl}">CRUD</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item ">
                <a class="nav-link" href="#">Alumnos <span class="sr-only">(current)</span></a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="${baseUrl}${endpoint_asignaturas}">Asignaturas</a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="${baseUrl}${endpoint_administrador}">Administrador</a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="${baseUrl}${endpoint_superuser}">SuperUsuario</a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Cambiar Contraseña</a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Crear Tareas(profe)</a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Ver Tareas(alum)</a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Ver Notas (alum)</a>
                </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Asociar
                    </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">Alumnos - Asignaturas</a>
                    <a class="dropdown-item" href="${baseUrl}${endpoint_profesor_asignaturas}">Profesor - Asignatura</a>                              
                    </div>
                </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Informes
                    </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="${baseUrl}${endpoint_informe_notas_asignaturas}">Notas Asignaturas</a>
                    <a class="dropdown-item" href="#">Notas Alumnos</a>
                    <a class="dropdown-item" href="#">Notas Alumno</a>
                    </div>
                </li>
            

            </ul>


        </div>
    <#if loginOnFromServer??>
        <#if (loginOnFromServer.nombre)??>
            <#if (levelAccess)??>

    <form action="${baseUrl}/index" class="form-inline my-2 my-lg-0">
        <span class="navbar-text">

                    ${loginOnFromServer.nombre}
                        <#if levelAccess == alumno>
                       Filtro                       
                       ${levelAccess}
                        </#if>
                    
            <input type="hidden" class="form-control" name="ID" id="exampleInputEmail1" value="${loginOnFromServer.id}">

            </span>
        <button class="btn btn-outline-info my-2 my-sm-0" type="submit" name="ACTION" value="LOGOUT">Logout</button>
        </form>

            </#if>
        </#if>
    </#if>
    </nav>