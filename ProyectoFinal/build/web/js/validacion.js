//Adios mundo aaaa
function validarl(e){
    var tecla = document.all ? tecla = e.keyCode : tecla = e.which;
            var especiales = [8, 32, 13];/*back, space, enter */
 
            for (var i in especiales) {
            if (tecla == especiales[i]) { return true;/*break; */}
            }
            return (((tecla > 96 && tecla < 123) || (tecla > 64 && tecla < 91)) || tecla == 8);

}

function validarn(e){
    var tecla = document.all ? tecla = e.keyCode : tecla = e.which;
            return ((tecla > 47 && tecla < 58) || tecla == 8);
}

function validarnl(e){
    var teclado = (document.all)? e.keyCode : e.which;
    if(teclado === 8) return true;
    var patron = /[A-z \ a-z\ 0-9]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}
/*
function validarPassword(e){

}

function validarHora(e){
    
}

function validarFecha(e){

}*/

function validarLetras(palabra, campo){
    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm"+" ";

    var checkStr = palabra;
    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo "+campo+":");
        document.getElementsByName(campo)[0].focus();
        return false;
    }
    return true;
}

function validarNumeros(numero, campo){
    var checkOk = "1234567890";
    var checkStr = numero;  
    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOk.length; j++){
            if(ch == checkOk.charAt(j)){
                break;
            }
        }

        if(j == checkOk.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente números enteros en " + campo);
        document.getElementsByName(campo)[0].focus();
        return false;
    }
    return true;
}

function validarNumYLetras(palabra, campo){
    var checkOK = "QWERTYUIOPASDFGHJKLZXCVBNMÑ"
    +"qwertyuiopasdfghjklñzxcvbnm"+" "
    + "1234567890";

    var checkStr = palabra;
    var allValido = true;

    for(var i = 0; i < checkStr.length; i++){
        var ch = checkStr.charAt(i);
        for(var j = 0; j < checkOK.length; j++){
            if(ch == checkOK.charAt(j))
            break;
        }
        if(j == checkOK.length){
            allValido = false;
            break;
        }
    }

    if(!allValido){
        alert("Escriba unicamente letras en el campo "+campo+":");
        document.getElementsByName(campo)[0].focus();
        return false;
    }
    return true;
}
/*
function validarPassword(password, campo){

}

function validarHora(hora, campo){
    
}

function validarFecha(fecha, campo){

}*/

function validarTamaño(palabra, minimo, maximo, campo){
    if(palabra.length < minimo || palabra.length > maximo){
        alert("Debes ingresar una palabra entre 3 y 5 letras en el " + campo);
        document.getElementsByName(campo)[0].focus();
        return false;
    }

}

function validarVacio(palabra, campo){
    if (palabra === ""){
        alert("Debe ingresar un valor en el campo "+campo+":");
        document.getElementsByName(campo)[0].focus();
        return false;
    }
    else{
        return true;
    }
}

function validarRegistroMaquina(registroM){
    //var lab = document.getElementsByName("laboratorio")[0].value.trim();
    var lab = registroM.laboratorio.value.trim();
    var fecha = registroM.fecha.value.trim();
    var hora = registroM.hora.value.trim();
    var etiqueta = registroM.etiqueta.value.trim();
    var serial = registroM.serial.value.trim();
    var cpu = registroM.cpu.value.trim();
    var marca = registroM.marca.value.trim();
    var monitor = registroM.monitor.value.trim();
    var accesorios = registroM.accesorios.value.trim();
    var boleta = registroM.boleta.value.trim();
    var grupo = registroM.grupo.value.trim();
    var asignatura = registroM.asignatura.value.trim();
    var docente = registroM.docente.value.trim();
    //typeof hoy === 'object';
    //var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])([A-Za-z\d$@$!%*?&]|[^ ]){8,15}$/;
    // ^([01]?[0-9]|2[0-3]):[0-5][0-9]$
    
    if(validarVacio(lab, "laboratorio") && validarLetras(lab, "laboratorio")){
        if(validarTamaño(lab, 2, 5, "laboratorio") == false){
            return false;
        }
        else if(validarVacio(fecha, "fecha") && validarNumeros(fecha, "fecha")){
            if(validarTamaño(fecha, 2, 5, "fecha") == false){
                return false;
            }
            else if(validarVacio(hora, "hora") && validarNumeros(hora, "hora")){
                if(validarTamaño(hora, 2, 5, "hora") == false){
                    return false;
                }
                else if(validarVacio(etiqueta, "etiqueta") && validarLetras(etiqueta, "etiqueta")){
                    if(validarTamaño(etiqueta, 2, 5, "etiqueta") == false){
                        return false;
                    }
                    else if(validarVacio(serial, "serial") && validarLetras(serial, "serial")){
                        if(validarTamaño(serial, 2, 5, "serial") == false){
                            return false;
                        }
                        else if(validarLetras(cpu, "cpu")){
                            if(validarTamaño(cpu, 2, 5, "cpu") == false){
                                return false;
                            }
                            else if(validarLetras(marca, "marca")){
                                if(validarTamaño(marca, 2, 5, "marca") == false){
                                    return false;
                                }
                                else if(validarLetras(monitor, "monitor")){
                                    if(validarTamaño(monitor, 2, 5, "monitor") == false){
                                        return false;
                                    }
                                    else if(validarLetras(accesorios, "accesoriosfal")){
                                        if(validarTamaño(accesorios, 2, 5, "accesoriosfal") == false){
                                            return false;
                                        }
                                        else if(validarVacio(alumno, "alumno") && validarLetras(alumno, "alumno")){
                                            if(validarTamaño(alumno, 3, 100, "alumno") == false){
                                                return false;
                                            }
                                            else if(validarVacio(boleta, "boleta") && validarNumeros(boleta, "boleta")){
                                                if(validarTamaño(boleta, 10, 10, "boleta") == false){
                                                    return false;
                                                }
                                                else if(validarVacio(grupo, "grupo") && validarLetras(grupo, "grupo")){
                                                    if(validarTamaño(grupo, 2, 5, "grupo") == false){
                                                        return false;
                                                    }
                                                    else if(validarVacio(asignatura, "asignatura") && validarLetras(asignatura, "asignatura")){
                                                        if(validarTamaño(asignatura, 2, 5, "asignatura") == false){
                                                            return false;
                                                        }
                                                        else if(validarVacio(docente, "docente") && validarLetras(docente, "docente")){
                                                            if(validarTamaño(docente, 3, 100, "docente") == false){
                                                                return false;
                                                            }
                                                        }
                                                        else{
                                                            return false;
                                                        }
                                                    }
                                                    else{
                                                        return false;
                                                    }
                                                }
                                                else{
                                                    return false;
                                                }
                                            }
                                            else{
                                                return false;
                                            }
                                        }
                                        else{
                                            return false;
                                        }
                                    }
                                    else{
                                        return false;
                                    }
                                }
                                else{
                                    return false;
                                }
                            }
                            else{
                                return false;
                            }
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }
    
}

function validarRegistroDocente(registroD){
    
    var do_usuario = registroD.usuario.value.trim();
    var do_password = registroD.password.value.trim();
    var do_nombre = registroD.nombre.value.trim();
    var do_appat = registroD.appat.value.trim();
    var do_apmat = registroD.apmat.value.trim();
    var do_numEmpleado = registroD.empleado.value.trim();
    var do_fecha = registroD.fecha.value.trim();
    var do_sexo = registroD.sexo.value.trim();

    if(validarVacio(do_usuario, "usuario") && validarLetras(do_usuario, "usuario")){
        if(validarTamaño(do_usuario, 3, 50, "usuario") == false){
            return false;
        }
        else if(validarVacio(do_password, "password")){
            if(validarTamaño(do_password, 3, 50, "password") == false){
                return false;
            }
            else if(validarVacio(do_nombre, "nombre") && validarLetras(do_nombre, "nombre")){
                if(validarTamaño(do_nombre, 3, 50, "nombre") == false){
                    return false;
                }   
                else if(validarVacio(do_appat, "appat") && validarLetras(do_appat, "appat")){
                    if(validarTamaño(do_appat, 3, 50, "appat") == false){
                        return false;
                    }
                    else if(validarVacio(do_apmat, "apmat") && validarLetras(do_apmat, "apmat")){
                        if(validarTamaño(do_apmat, 3, 50, "apmat") == false){
                           return false;
                        }
                        else if(validarVacio(do_numEmpleado, "empleado") && validarNumeros(do_numEmpleado, "empleado")){
                            if(validarTamaño(do_numEmpleado, 1, 10, "empleado") == false){
                                return false;
                            }
                            else if(validarVacio(do_fecha, "fecha")){
                                if(validarTamaño(do_fecha, 3, 15, "fecha") == false){
                                    return false;
                                }
                                else if(validarVacio(do_sexo, "sexo")){
                
                                }
                                else{
                                    return false;
                                }
                                
                            }
                            else{
                                return false;
                            }

                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }    
                }
                    
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    else{
        return false;
    }
}

function validarModRegistroMaquina(modRegistroM){

    var id = modRegistroM.reporte.value.trim();
    var lab = modRegistroM.laboratorio.value.trim();
    var fecha = modRegistroM.fecha.value.trim();
    var hora = modRegistroM.hora.value.trim();
    var etiqueta = modRegistroM.etiqueta.value.trim();
    var serial = modRegistroM.serial.value.trim();
    var cpu = modRegistroM.cpu.value.trim();
    var marca = modRegistroM.marca.value.trim();
    var monitor = modRegistroM.monitor.value.trim();
    var accesorios = modRegistroM.accesorios.value.trim();
    var boleta = modRegistroM.boleta.value.trim();
    var grupo = modRegistroM.grupo.value.trim();
    var asignatura = modRegistroM.asignatura.value.trim();
    var docente = modRegistroM.docente.value.trim();

    if(validarVacio(id, "reporte") && validarNumeros(id, "reporte"))
    {
        if(lab == "" && fecha == "" && hora == "" && etiqueta == "" && serial == "" && cpu == ""
        && marca == "" && monitor == "" && accesorios == "" && boleta == "" && grupo == "" && asignatura == "" && docente == "")
        {
            alert("Debes escoger almenos un campo a modificar");
            modRegistroM.laboratorio.focus();
            return false;
            
        }
        else{
            if(validarLetras(lab, "laboratorio")){
                if(validarTamaño(lab, 2, 5, "laboratorio") == false){
                    return false;
                }
                else if(validarNumeros(fecha, "fecha")){
                    if(validarTamaño(fecha, 2, 5, "fecha") == false){
                        return false;
                    }
                    else if(validarNumeros(hora, "hora")){
                        if(validarTamaño(hora, 2, 5, "hora") == false){
                            return false;
                        }
                        else if(validarLetras(etiqueta, "etiqueta")){
                            if(validarTamaño(etiqueta, 2, 5, "etiqueta") == false){
                                return false;
                            }
                            else if(validarLetras(serial, "serial")){
                                if(validarTamaño(serial, 2, 5, "serial") == false){
                                    return false;
                                }
                                else if(validarLetras(cpu, "cpu")){
                                    if(validarTamaño(cpu, 2, 5, "cpu") == false){
                                        return false;
                                    }
                                    else if(validarLetras(marca, "marca")){
                                        if(validarTamaño(marca, 2, 5, "marca") == false){
                                            return false;
                                        }
                                        else if(validarLetras(monitor, "monitor")){
                                            if(validarTamaño(monitor, 2, 5, "monitor") == false){
                                                return false;
                                            }
                                            else if(validarLetras(accesorios, "accesoriosfal")){
                                                if(validarTamaño(accesorios, 2, 5, "accesoriosfal") == false){
                                                    return false;
                                                }
                                                else if(validarLetras(alumno, "alumno")){
                                                    if(validarTamaño(alumno, 3, 100, "alumno") == false){
                                                        return false;
                                                    }
                                                    else if(validarNumeros(boleta, "boleta")){
                                                        if(validarTamaño(boleta, 10, 10, "boleta") == false){
                                                            return false;
                                                        }
                                                        else if(validarLetras(grupo, "grupo")){
                                                            if(validarTamaño(grupo, 2, 5, "grupo") == false){
                                                                return false;
                                                            }
                                                            else if(validarLetras(asignatura, "asignatura")){
                                                                if(validarTamaño(asignatura, 2, 5, "asignatura") == false){
                                                                    return false;
                                                                }
                                                                else if(validarLetras(docente, "docente")){
                                                                    if(validarTamaño(docente, 3, 100, "docente") == false){
                                                                        return false;
                                                                    }
                                                                }
                                                                else{
                                                                    return false;
                                                                }
                                                            }
                                                            else{
                                                                return false;
                                                            }
                                                        }
                                                        else{
                                                            return false;
                                                        }
                                                    }
                                                    else{
                                                        return false;
                                                    }
                                                }
                                                else{
                                                    return false;
                                                }
                                            }
                                            else{
                                                return false;
                                            }
                                        }
                                        else{
                                            return false;
                                        }
                                    }
                                    else{
                                        return false;
                                    }
                                }
                                else{
                                    return false;
                                }
                            }
                            else{
                                return false;
                            }
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
    }
    else{
        return false;
    }
}

function validarModRegistroDocente(modRegistroD){

    var do_numEmpleado = modRegistroD.empleado.value.trim();
    var do_nombre = modRegistroD.nombre.value.trim();
    var do_appat = modRegistroD.appat.value.trim();
    var do_apmat = modRegistroD.apmat.value.trim();
    var do_usuario = modRegistroD.usuario.value.trim();
    var do_password = modRegistroD.password.value.trim();
    var do_numEmpleadoN = modRegistroD.empleado_nuevo.value.trim();

    if(validarVacio(do_numEmpleado, "empleado") && validarNumeros(do_numEmpleado, "empleado"))
    {
        if(do_nombre == "" && do_appat == "" && do_apmat == "" && do_usuario == ""
            && do_password == "" && do_numEmpleadoN == ""){
            alert("Debes escoger al menos un campo a cambiar");
            return false;
            
        }
        else{
            if(validarLetras(do_usuario, "usuario")){
                if(validarTamaño(do_usuario, 3, 50, "usuario") == false){
                    return false;
                }
                else if(validarLetras(do_password, "password")){
                    if(validarTamaño(do_password, 3, 50, "password") == false){
                        return false;
                    }
                    else if(validarLetras(do_nombre, "nombre")){
                        if(validarTamaño(do_nombre, 3, 50, "nombre") == false){
                            return false;
                        }   
                        else if(validarLetras(do_appat, "appat")){
                            if(validarTamaño(do_appat, 3, 50, "appat") == false){
                                return false;
                            }
                            else if(validarLetras(do_apmat, "apmat")){
                                if(validarTamaño(do_apmat, 3, 50, "apmat") == false){
                                return false;
                                }
                                else if(validarNumeros(do_numEmpleadoN, "empleado_nuevo")){
                                    if(validarTamaño(do_numEmpleadoN, 3, 10, "empleado_nuevo") == false){
                                        return false;
                                }
                            }
                            else{
                                return false;
                            }
                        }
                            else{
                                return false;
                            }    
                        }
                        
                        else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
    }
    else{
        return false;
    }
}

function validarEliminarRegistro(elimarRegistro){
    var serial = elimarRegistro.serial.value.trim();
    if(validarVacio(serial, "serial")){
        return validarLetras(serial, "serial");
    }
    else{
        return false;
    }
}