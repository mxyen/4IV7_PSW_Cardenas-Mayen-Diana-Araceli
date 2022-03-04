/* 
 Javascript es un lenguaje que posee un paradigma orientado a objetos y a funciones, por
 tal motivo presenta una particularidad la cual es:
 NO TIPADO
 No existe int, float, string, ni char, ni nada

 TODO ES VAR->variable

 De acuerdo al estandar ES6 se manejan 3 tipos de variables
 
 VAR
 LET es una variable de tipo "protected"
 CONST 
 */

 function validar (formulario){
     
     if (formulario.nombre.value.length < 5){
         alert("Escriba un minimo de 5 caracteres en el campo Nombre");
         formulario.nombre.focus();
         return false

     }

     var checkOK = "QWERTYUIOPASDFGHJKLÑZXCVBNM"
     + "qwertyuiopasdfghjklñzxcvbnm";

     var checkStr = formulario.nombre.value;

     var todoesvalido = true;

     for ( var i=0; i < checkStr.length; i++){
         var ch = checkStr.charAt(i);
         for (var j=0; j < checkOK.length;j++){
             if (ch==checkOK.charAt(j)){
                 break;
             }
            
             }
             if(j == checkOK.length){
                todoesvalido = false;
                break;
         }
     }

     if(!todoesvalido){
         alert("Escriba unicamente letras en el campo Nombre");
         formulario.nombre.focus();
         return false;
     }


     var checkOK = "0123456789";

     var checkStr = formulario.edad.value;

     var todoesvalido = true;

     for ( var i=0; i < checkStr.length; i++){
         var ch = checkStr.charAt(i);
         for (var j=0; j < checkOK.length;j++){
             if (ch==checkOK.charAt(j)){
                 break;
             }
            
             }
             if(j == checkOK.length){
                todoesvalido = false;
                break;
         }
     }

     if(!todoesvalido){
         alert("Escriba unicamente numeros en el campo Edad");
         formulario.edad.focus();
         return false;
     }
     var txt = formulario.email.value;
     
     //creo mi expresion regular
     var b = /^[^@\s]+[^@\. \s]+(\.[^@\. \s]+)+$/;

     alert("Email" + (b.test(txt)?" ":" no ")+" valido ");
     return b.test;










 }