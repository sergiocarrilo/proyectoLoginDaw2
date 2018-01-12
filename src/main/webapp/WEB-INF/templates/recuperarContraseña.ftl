<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="recuperar contraseña">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <#include "/libreria.ftl">
        </head>
    <body>
        <form id="formrecuperacion" action="recuperar?">
            <div class="form-group">
                <label for="recipient-name" class="col-form-label">Introduzca su nombre de usuario:</label>
                <input type="text" name="name" class="form-control" id="name">
            </div>
            <div class="form-group">
                <label for="recipient-name" class="col-form-label">Introduzca su nombre de correo:</label>
                <input type="text" name="email" class="form-control" id="email">
                </div>
            <div>
                <input type="hidden" name="ACTION" class="form-control" id="ACTION" value="RECUPERAR">   
                </div>
            <div class="form-group">
                <button type="button" onclick="crearProfe();" class="btn btn-primary">Recuperar</button>
            </div>
            
        </form>
        
        <#if messageToUser??>
        <div class="alert alert-primary" role="alert">
                ${messageToUser?js_string}    
        </div>
        </br>
        </#if>
    </body>
    </html>
