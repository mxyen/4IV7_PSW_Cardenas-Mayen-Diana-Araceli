function validarn(e){
    var teclado=(document.all)?e.keyCode: e.which;
    if(teclado==8) return true;
    
    var codigo=String.fromCharCode(teclado);
    return patron.test(codigo);
}
function interes(){
    var plazo=parseFloat(document.formulario1.plazo.value);
    var valor=document.formulario1.cantidad.value;
    var resul=parseInt(valor);
    var interes=(resul*0.02*plazo)/12;
    var total=interes+resul;
    if(!Number.isInteger(plazo)){
        alert("No valido");
    }else{
        if(plazo<0){
            alert("El plazo que ingresaste no es valido.");
        }if(plazo<=48){
            document.formulario1.sueldoI.value="$"+total;
        }else{
            alert("El plazo debe ser menor a 48 meses");
        }
    }    
}
function borrardatos(){
    document.formulario1.cantidad.value="";
    document.formulario1.sueldoI.value="";
    document.formulario1.plazo.value="";
}
function borrard2(){
    document.formulario2.v1.value="";
    document.formulario2.v2.value="";
    document.formulario2.v3.value="";
    document.formulario2.sueldob.value="";
    document.formulario2.sueldot.value="";
}
function borrard3(){
    document.formulario3.totalcompra.value="";
    document.formulario3.descuento.value="";
    document.formulario3.totalp.value="";
}
function borrard4(){
    document.formulario4.p1.value="";
    document.formulario4.p2.value="";
    document.formulario4.p3.value="";
    document.formulario4.califexamenf.value="";
    document.formulario4.califtrabajof.value="";
    document.formulario4.cf.value="";
}
function borrard5(){
    document.formulario5.h.value="";
    document.formulario5.m.value="";
    document.formulario5.ph.value="";
    document.formulario5.pm.value="";
}
function borrard6(){
    document.formulario6.d.value="";
    document.formulario6.select.value="Select";
    document.formulario6.a.value="";
    document.getElementById("salida").value="";
}

/*problema 2*/
function validar_ventas(){
    var venta1=parseInt(document.formulario2.v1.value);
    var venta2=parseInt(document.formulario2.v2.value);
    var venta3=parseInt(document.formulario2.v3.value);
    var sb=parseInt(document.formulario2.sueldob.value);
    if(venta1<0 || venta2<0 || venta3<0 || sb<0){
        alert("Verifica los valores introducidos");
    }else{
        var comision=0.1*(venta1+venta2+venta3);
        document.formulario2.sueldot.value="$"+(comision+sb);
    }
}

/*problema 3*/ 
function validar_compra(){
    var compra=parseInt(document.formulario3.totalcompra.value);
    if(compra<0){
        alert("Verifica el valor de la compra");
    }else{
        var desc=0.15*compra;
        document.formulario3.descuento.value="$"+desc;
        document.formulario3.totalp.value="$"+(compra-desc);
    }
}

/* problema 4*/
function validar_cals(){
    var p1=parseFloat(document.formulario4.p1.value);
    var p2=parseFloat(document.formulario4.p2.value);
    var p3=parseFloat(document.formulario4.p3.value);
    var cef=parseFloat(document.formulario4.califexamenf.value);
    var ctf=parseFloat(document.formulario4.califtrabajof.value);
    if(p1<0 || p2<0 || p3<0 || cef<0 || 
        ctf<0 || p1>10 || p2>10 || p3>10 || cef>10 || ctf>10){
        alert("Verifica la informacion introducida");
    }else{
        document.formulario4.cf.value=0.55*((p1+p2+p3)/3)+0.3*cef+0.15*ctf;
    }
}

/*problema 5 */
function validar_c(){
    var hombres=parseFloat(document.formulario5.h.value);
    var mujeres=parseFloat(document.formulario5.m.value);
    var total=hombres+mujeres;
    if(hombres<0||mujeres<0||!Number.isInteger(hombres)||!Number.isInteger(mujeres)){
        alert("Verifica la informacion introducida");
    }else{
        document.formulario5.ph.value=(100*hombres)/total + "%";
        document.formulario5.pm.value=(100*mujeres)/total + "%";
    }
}

/*problema 6 */
function validar_n(){
    var dia=parseFloat(document.formulario6.d.value);
    var año=parseFloat(document.formulario6.a.value);
    var mes=parseFloat(document.formulario6.select.value);
    var todoesvalido=true;
    fecha_actual=new Date();
    fecha_nac=new Date(año,mes-1,dia);
    if(!Number.isInteger(dia)||!Number.isInteger(mes)
    ||!Number.isInteger(año)||fecha_actual<fecha_nac
    ||dia==0||año==0){
        alert("No valido");
    }else{
        if(mes==1 && dia>=32){//enero
            alert("No valido");
            todoesvalido=false;
        }if(mes==2 && dia>=29 && año%4!=0){//febrero sin ser bisiesto
            alert("No valido");
            todoesvalido=false;
        }if(mes==2 && dia==29 && año%4==0 && año<=fecha_actual.getFullYear()){
            var años_cumplidos=0;
            //alert(años_bisiestos());
            if(fecha_actual.getMonth()==1
            && fecha_actual.getDate()==29){
                años_cumplidos=años_bisiestos();               
            }if(fecha_actual.getMonth()==1
            && fecha_actual.getDate()<29){
                años_cumplidos=años_bisiestos()-1;
            }if(fecha_actual.getMonth()>1){
                años_cumplidos=años_bisiestos();
                //alert(años_cumplidos);
            }if(fecha_actual.getMonth()<1){
                años_cumplidos=años_bisiestos()-1;
            }
            if(fecha_actual.getMonth()>fecha_nac.getMonth()){
                var meses=fecha_actual.getMonth()-fecha_nac.getMonth();
            }else if(fecha_actual.getMonth()<fecha_nac.getMonth()){
                var meses=12-(fecha_nac.getMonth()-fecha_actual.getMonth());
            }else if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()>fecha_nac.getDate()
            ){
                var meses=0;
            }else{
                var meses=11;
            }
            document.formulario6.salida.value="Años: "+años_cumplidos+" Meses: "+meses
            +" Dias: "+fecha_actual.getDate();
            todoesvalido=false;
        }if(mes==2 && dia>29 && año%4==0){//febrero siendo bisiesto
            alert("No valido");
            todoesvalido=false;
        }if(mes==3 && dia>=32){//marzo
            alert("No valido");
            todoesvalido=false;
        }if(mes==4 && dia>=31){//abril
            alert("No valido");
            todoesvalido=false;
        }if(mes==5 && dia>=32){//mayo
            alert("No valido");
            todoesvalido=false;
        }if(mes==6 && dia>=31){//junio
            alert("No valido");
            todoesvalido=false;
        }if(mes==7 && dia>=32){//julio
            alert("No valido");
            todoesvalido=false;
        }if(mes==8 && dia>=32){//agosto
            alert("No valido");
            todoesvalido=false;
        }if(mes==9 && dia>=31){//sept
            alert("No valido");
            todoesvalido=false;
        }if(mes==10 && dia>=32){//oct
            alert("No valido");
            todoesvalido=false;
        }if(mes==11 && dia>=31){//nov
            alert("No valido");
            todoesvalido=false;
        }if(mes==12 && dia>=32){//dic
            alert("No valido");
            todoesvalido=false;
        }if(todoesvalido==true){
            //alert(fecha_actual.getMonth());
            //calcular años cumplidos
            var dif_años=fecha_actual.getFullYear()-fecha_nac.getFullYear();
            if(fecha_actual.getMonth()>fecha_nac.getMonth()){
                //alert(años);
                var años_cumplidos=dif_años;
            }if(fecha_actual.getMonth()<fecha_nac.getMonth()){
                //alert(años-1);
                var años_cumplidos=dif_años-1;
            }if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()==fecha_nac.getDate()){
                //alert(años);
                var años_cumplidos=dif_años;
            }if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()>fecha_nac.getDate()){
                //alert(años);
                var años_cumplidos=dif_años;
            }if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()<fecha_nac.getDate()){
                //alert(años-1);
                var años_cumplidos=dif_años-1;
            }
            //calcular meses cumplidos
            if(fecha_actual.getMonth()>fecha_nac.getMonth()){
                var meses=fecha_actual.getMonth()-fecha_nac.getMonth();
            }else if(fecha_actual.getMonth()<fecha_nac.getMonth()){
                var meses=12-(fecha_nac.getMonth()-fecha_actual.getMonth());
            }else if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()>fecha_nac.getDate()
            ){
                var meses=0;
            }else{
                var meses=11;
            }
            //calcular dias cumplidos
            var contador=0;
            for(i=fecha_nac.getFullYear();i<=fecha_actual.getFullYear();i++){
                if(i%4==0){
                    contador++;
                }else{}
            }
            var dias_meses=[31,28,31,30,31,30,31,31,30,31,30,31]
            var dias_cumplidos=dias_meses[fecha_actual.getMonth()]-fecha_nac.getDate()+fecha_actual.getDate()+contador;
            var resul=[años_cumplidos,meses,dias_cumplidos];
            //alert(resul);
            if(resul.includes(NaN)||resul.includes(undefined)){
                alert("Revisa la informacion");
            }else{
                document.formulario6.salida.value="Tienes "+resul[0]+" años, "+resul[1]+" meses cumplidos, "+resul[2]+" dias cumplidos";
            }
            /*document.form6.salida.value="Tienes "+años_cumplidos+" años cumplidos, "+meses
            +" meses cumplidos, "+dias_cumplidos+" dias cumplidos contando años bisiestos";*/
           //alert(años_cumplidos+"/"+meses+"/"+(fecha_actual.getDate()+contador));
        }
    }
}
function años_bisiestos(){
    var contador=0;
    for(i=fecha_nac.getFullYear();i<=fecha_actual.getFullYear();i++){
        if(i%4==0){
            contador++;
        }
    }
    return contador;
}