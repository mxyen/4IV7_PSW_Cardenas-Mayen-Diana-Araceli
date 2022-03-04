function algoritmo(){
    var valor = parseFloat (document.interescompuesto.valor.value);
    var intereses = 0.0304
    var periodo = parseInt (document.interescompuesto.periodo.value);

    var cuota = valor*Math.pow(1.0+intereses/5/100,periodo);
    document.interescompuesto.cuota.value=cuota;
    
    var checkOk = "0123456789";
    var checkStr = interescompuesto.valor.value;
    var todoesvalido = true;

    if(interescompuesto.valor.value.length <8){
        alert("Por favor escriba una cantidad en el rango de valores es de 100,000.00 a 1,000,000.00 ")
        interescompuesto.valor.focus();
        return false;
    }
        if(interescompuesto.valor.value.length >9){
            alert("Por favor escriba una cantidad en el rango de valores es de 100,000.00 a 1,000,000.00 ")
            interescompuesto.valor.focus();
            return false;
            }

            for(var i=0; i<checkStr.length; i++){
                var ch= checkStr.charAt(i);
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
                alert("Escriba unicamente numeros en el campo valor del auto:");
                interescompuesto.valor.focus();
                return false;
            }

            
     var checkOK = "0123456789";

     var checkStr = interescompuesto.cuotai.value;

     var todoesvalido = true;

     if(interescompuesto.cuotai.value !=valor*10/100){
        alert("Por favor escriba la cuota inicial correctamente")
        interescompuesto.cuotai.focus();
        return false;
    }

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
         alert("Escriba unicamente numeros en el campo cuota inicial");
         interescompuesto.cuotai.focus();
         return false;
     }

     var checkOK = "0123456789";
     var checkStr = interescompuesto.periodo.value;
     var todoesvalido=true;

     if(interescompuesto.periodo.value !=3){
        alert("Por favor escriba el periodo correctamente, de 3 en 3  hasta 18 (3-18)")
        interescompuesto.cuotai.focus();
        return false;
    }

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
        alert("Escriba unicamente numeros en el campo del periodo");
        interescompuesto.cuotai.focus();
        return false;
    }
    
}