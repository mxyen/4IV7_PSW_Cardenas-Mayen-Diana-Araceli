//problema 1
function problema1(){
    var p1_input = document.querySelector('#p1-input').value;
    var palabra=p1_input.split(" ");
    cadenainvertida=[];
    for(i=0;i<palabra.length;i++){
        cadenainvertida.push(invertir(palabra[i]));
    }
    document.querySelector('#p1-output').textContent="";
    for(i=0;i<cadenainvertida.length;i++){
        document.querySelector('#p1-output').textContent+='Palabra:'+palabra[i]+'='+cadenainvertida[i]+'\n';
    }
    
    function invertir(cadena){
        return cadena.split("").reverse().join("");
    }
}

function problema2(){
    var negativos=/^-/;
    //obtencion de datos
    var x1=parseInt(document.getElementById("p2-x1").value);
    var x2=parseInt(document.getElementById("p2-x2").value)
    var x3=parseInt(document.getElementById("p2-x3").value)
    var x4=parseInt(document.getElementById("p2-x4").value)
    var x5=parseInt(document.getElementById("p2-x5").value)
    var y1=parseInt(document.getElementById("p2-y1").value)
    var y2=parseInt(document.getElementById("p2-y2").value)
    var y3=parseInt(document.getElementById("p2-y3").value)
    var y4=parseInt(document.getElementById("p2-y4").value)
    var y5=parseInt(document.getElementById("p2-y5").value)
    var A=[x1,x2,x3,x4,x5];
    var B=[y1,y2,y3,y4,y5];
    var dagc=0;
    var dagc1=0;
    var suma=0
    for(i=0;i<=4;i++){
        suma+=A[i]*B[i];
    }
    dagc=suma;
    var C=A.reverse();
    var suma2=0;
    for(i=0;i<=4;i++){
        suma2+=C[i]*B[i];
    }
    dagc1=suma2;
    if(dagc1>dagc){
        document.querySelector('#p2-output').textContent="El menor producto escalar es: X.Y = "+dagc;

    }else{
        document.querySelector('#p2-output').textContent="El producto escalar es X^-1 Y="+dagc1;
    }
}















function problema3(){
    //definir un alfabeto
    var alfabeto = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O',
    'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ]
    
    //obtener la cadena del input y separar por comas

    var p3_input = document.querySelector('#p3-input').value;
    var p3_palabras = p3_input.split(',');

    //eliminar el espacio que hay entre cada palabra

    p3_palabras = p3_palabras.map(function (palabra){
        return palabra.replace(/\s/g, '').toUpperCase();
    }   )

    //calcular los caracteres unicos de cada palabra

    var p3_res = '';

    //iterar en cada palabra
    p3_palabras.forEach(function(palabra,i){
        //separar las palabras en un array para leer cada letra
        var letras_unicas = [];
        var palabra_array = palabra.split ('');
        //iteracion del alfabeto
        alfabeto.forEach(function (letra,j){
            //iterar por palabra
            palabra_array.forEach(function (letra_palabra, k){
                //para comprobar que la letra esta dentro del alfabeto
                if(letra_palabra == letra){
                    //si la letra no la hemos contado, la agregamos a un array. Para contar las letras unicas
                    if(letras_unicas.indexOf(letra) <0){
                        letras_unicas.push(letra)
                    }
                }

            })
        })
        p3_res += 'Palabra: ' + palabra + '=' + letras_unicas.length + '\n'
    })
    document.querySelector('#p3-output').textContent = p3_res;

}     

