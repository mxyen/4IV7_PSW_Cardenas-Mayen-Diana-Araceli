<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/registrarse.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
    </head>


    <body>
        <main>
              <form action="../SrvPersona?accion=Registrar " class="formulario" id="formulario">
            <section class="form-register">
            <h4>Registrar nuevo usuario</h4>
            
            <div class="formulario__grupo" id="grupo__usuario">                
                <div class="formulario__grupo-input">
                   <input class="controls" type="text" name="usuario" id="usuario" placeholder="Ingrese su Usuario">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">El usuario tiene que tener más de 5 dígitos.</p>
            </div>
            
            <div class="formulario__grupo" id="grupo__password">                
                <div class="formulario__grupo-input">
                    <input class="controls" type="password" name="password" id="password" placeholder="Ingrese su Contraseña">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">La contraseña tiene que ser de 4 a 12 dígitos</p>
            </div>
            
            <div class="formulario__grupo" id="grupo__password2">                
                <div class="formulario__grupo-input">
                    <input class="controls" type="password" name="password2" id="password2" placeholder="Ingrese su Contraseña nuevamente">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">No coinciden</p>
            </div>
            
            <div class="formulario__grupo" id="grupo__nombre">                
                <div class="formulario__grupo-input">
                    <input class="controls" type="text" name="nombre" id="nombre" placeholder="Ingrese su Nombre">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">Ingresa un nombre valido</p>
            </div>
            
            <div class="formulario__grupo" id="grupo__appat">                
                <div class="formulario__grupo-input">
                    <input class="controls" type="text" name="appat" id="appat" placeholder="Ingrese su Apellido Paterno">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">Ingresa un apellido válido</p>
            </div>
            
            <div class="formulario__grupo" id="grupo__apmat">                
                <div class="formulario__grupo-input">
                     <input class="controls" type="text" name="apmat" id="apmat" placeholder="Ingrese su Apellido Materno">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">Ingresa un apellido válido</p>
            </div>
            
                        
            <div class="content-select">
                <select name="sexo" id="sexo">
                <option selected disabled value="">Sexo</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
                </select>                
            </div>
            <br>
            
            <div class="formulario__grupo" id="grupo__nombre">                
                <div class="formulario__grupo-input">
                   <input class="controls" type="date" name="fecha" id="fecha" placeholder="Ingrese su Fecha de Nacimiento">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">El usuario tiene que ser de 4 a 16 dígitos y solo puede contener numeros, letras y guion bajo.</p>
            </div>
            
            
            <div class="content-select">
                <select name="tipoUsuario" id="tipoUsuario">
                <option selected disabled value="">Tipo de Usuario</option>
                <option value="1">Alumno</option>
                <option value="2">Docente</option>
                </select>                
            </div>
            <br>
            
                <div class="content-select">
                    <select name="privilegio" id="privilegio">
                        <option selected disabled value="">Privilegio</option>
                        <option value="1">Alumno</option>
                        <option value="2">Jefe de Grupo</option>
                        <option value="3">Docente</option>
                        <option value="4">Jefe Academia</option>
                    </select>                
                </div> 
            
            <div class="formulario__grupo" id="grupo__empleado">                
                <div class="formulario__grupo-input">
                    <input class="controls" type="text" name="empleado" id="empleado" placeholder="Ingrese su numero de Empleado">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">Ingresa un numero valido, minimo 5 digitos</p>
            </div>
            
             <div class="formulario__grupo" id="grupo__boleta">                
                <div class="formulario__grupo-input">
                    <input class="controls" type="text" name="boleta" id="boleta" placeholder="Ingrese su numero de Boleta">
                    <i class="formulario__validacion-estado fas fa-times-circle"></i>
                </div>
                <p class="formulario__input-error">Tu boleta debe tener minimo 10 digitos</p>
            </div>
            
            <div class="content-select">
                <br>
                <select name="grupo" id="grupo">
                    <option selected disabled value="">Grupo</option>
                    <option value="1">4IV7</option>
                    <option value="2">4IV8</option>
                </select>
                <br>
            </div>
            <p>Confirmo que mis datos sean correctos</p>
            <input class="botons" type="submit" value="Registrar">
            <p><a href="InicioSesion.jsp">¿Ya tengo Cuenta?</a></p>
        </section>
        
        <br>
            <center><a class="link" href="index.html" style="color:white">Volver</a></center>
            <br>
            
            
        </form>
            
        </main>
      
        
       
        <script src="js/validacion2.js"></script>
	<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>


    </body>
    </html>
