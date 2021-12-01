 fun main(){
     println("Hola Mundo")
 }



 //funcion imprimir nombre
 fun imprimirnombre(nombre: String){
     println("Nombre: ${nombre}")
 }

 // función calcular sueldo
 fun calcularSueldo(
     sueldo: Double, // Requerida
    tasa: Double = 12.00, // Opciones (por defecto)
    bonoEspecial: Double? = null, //Opcional (Null)->nullable
 ):Double{
     if(bonoEspecial == null){
         return sueldo*(100/tasa)
     } else {
         return sueldo*(100/tasa)+bonoEspecial
     }


     val respuestaFilter: List <Int> =

 }


