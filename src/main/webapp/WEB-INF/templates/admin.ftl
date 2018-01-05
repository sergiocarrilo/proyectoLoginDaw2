<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="ProyectoLogin">
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
    <body>
        <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#modalProfesor">Insertar Profesor</button>
        <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#modalAlumno">Insertar Alumno</button>
        <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#modalAsignatura">Insertar Asignatura</button>
        <div class="modal fade" id="modalProfesor" tabindex="-1" role="dialog" aria-labelledby="modalProfesor" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" >Insertar Profesor</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Nombre:</label>
                                <input type="text" name="name" class="form-control" id="professorname">
                                </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Email:</label>
                                <input type="text" name="email" class="form-control" id="professoremail">
                            </div>
                            <div>
                                <input type="hidden" name="action" class="form-control" id="action" value="INSERTARPROFESSOR">   
                            </div>
                            <div class="modal-footer">
                                <div class="form-group">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="button" onclick="" class="btn btn-primary">INSERTAR</button>
                                </div>
                            </div>
                        </form>
                    </div>
                        
                    </div>
                </div>
            </div>
        
        <div class="modal fade" id="modalAlumno" tabindex="-1" role="dialog" aria-labelledby="modalProfesor" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="">Insertar Alumno</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Nombre:</label>
                                <input type="text" name="name" class="form-control" id="alumnoname">
                                </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Email:</label>
                                <input type="text" name="email" class="form-control" id="alumnoemail">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Fecha Nacimiento:</label>
                                <input type="date" name="fecna" class="form-control" id="alumnofecna">
                               
                            </div>
                             <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Mayor de Edad:</label>
                                <input type="checkbox" name="mayor" class="form-control" id="alumnomayor">
                            </div>
                            <div>
                                <input type="hidden" name="action" class="form-control" id="action" value="INSERTARALUMNO">   
                            </div>
                            <div class="modal-footer">
                                <div class="form-group">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="button" onclick="" class="btn btn-primary">INSERTAR</button>
                                </div>
                            </div>
                        </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        <div class="modal fade" id="modalAsignatura" tabindex="-1" role="dialog" aria-labelledby="modalProfesor" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="">Insertar Asignatura</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Asignatura:</label>
                                <input type="text" name="name" class="form-control" id="asigname">
                                </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Curso:</label>
                                <input type="text" name="curso" class="form-control" id="asigcurso">
                            </div>
                            
                            <div>
                                <input type="hidden" name="action" class="form-control" id="action" value="INSERTARASIGNATURA">   
                            </div>
                            <div class="modal-footer">
                                <div class="form-group">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                    <button type="button" onclick="" class="btn btn-primary">INSERTAR</button>
                                </div>
                            </div>
                        </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        </body>
    </html>