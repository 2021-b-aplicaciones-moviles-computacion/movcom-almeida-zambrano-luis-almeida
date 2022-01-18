import java.io.*
import java.util.*

fun main() {
    Persona.leerArchivoPersona()
    Certificado.leerArchivoCertificado()
    menuOpciones()
}

fun menuOpciones() {
    do {
        print(
            """
        CRUD con Kotlin
        *************************************
        *      Selecciona una opción        *
        *      1.- Modulo Personas          *
        *      2.- Modulo Certificados      *
        *      3.- Salir                    *
        *************************************
        *      Seleccione una opción: 
            """.trimIndent()
        )

        var op = readLine()?.toInt() as Int
        print("El valor seleccionado es: ${op}")
        when (op) {
            1 -> {
                do {
                    print(
                        """
                CRUD con Persona
                *************************************
                *      Selecciona una opción        *
                *      1.- Crear Persona            *
                *      2.- Consultar Persona        *
                *      3.- Editar Persona           *
                *      4.- Eliminar Persona         *
                *      5.- Salir                    *
                *************************************
                *      Seleccione una opción: 
                        """.trimIndent()
                    )
                    var opPersona = readLine()?.toInt() as Int
                    when (opPersona) {
                        1 -> {
                            print("Ingrese la cédula: ")
                            var cedulaPersona = readLine()?.toString() as String
                            print("Ingrese el Nombre: ")
                            var nombrePersona = readLine()?.toString() as String
                            var fechaPersona = Date()
                            print("Ingrese su edad: ")
                            var edadPersona = readLine()?.toInt() as Int
                            print("¿Tiene experiencia?: ")
                            var experienciaPersona = readLine().toBoolean()

                            var newPersona =
                                Persona(cedulaPersona, nombrePersona, fechaPersona, edadPersona, experienciaPersona)
                            Persona.agregarPersona(newPersona)
                            break
                        }
                        2 -> {
                            print("Ingrese la cédula: ")
                            var cedulaPersona = readLine()?.toString() as String
                            Persona.mostrarPersona(Persona.buscarPersona(cedulaPersona))
                            break
                        }
                        3 -> {
                            print("Actualizar Datos ")
                            print("Ingrese la cédula: ")
                            var cedulaPersona = readLine()?.toString() as String
                            print("Ingrese el Nombre: ")
                            var nombrePersona = readLine()?.toString() as String
                            var fechaPersona = Date()
                            print("Ingrese su edad: ")
                            var edadPersona = readLine()?.toInt() as Int
                            print("¿Tiene experiencia?: ")
                            var experienciaPersona = readLine().toBoolean()

                            Persona.actualizarPersona(
                                cedulaPersona,
                                nombrePersona,
                                fechaPersona,
                                edadPersona,
                                experienciaPersona
                            )
                            break
                        }
                        4 -> {
                            print("Ingrese la cédula de la persona a eliminar: ")
                            var cedulaPersona = readLine()?.toString() as String
                            Persona.eliminarPersona(cedulaPersona)
                            break
                        }
                    }
                } while (opPersona != 5)
            }
            2 -> {
                do {
                    print(
                        """
                CRUD con Certificado
                *************************************
                *      Selecciona una opción        *
                *      1.- Crear un Certificado     *
                *      2.- Consultar un Certificado *
                *      3.- Editar un Certificado    *
                *      4.- Eliminar un Certificado  *
                *      5.- Salir                    *
                *************************************
                *      Seleccione una opción: 
                    """.trimIndent()
                    )
                    var opCertificado = readLine()?.toInt() as Int
                    when (opCertificado) {
                        1 -> {
                            print("Ingrese el id del certificado: ")
                            var idCertificado = readLine()?.toInt() as Int
                            print("Ingrese el Nombre del certificado: ")
                            var nombreCertificado = readLine()?.toString() as String
                            print("Ingrese nombre de la plataforma: ")
                            var nombrePlataforma = readLine()?.toString() as String
                            print("Ingres el costo del certificado:")
                            var costoCertificado = readLine()?.toDouble() as Double
                            var fechaCertificado = Date()

                            var newCertificado = Certificado(
                                idCertificado,
                                nombreCertificado,
                                nombrePlataforma,
                                costoCertificado,
                                fechaCertificado
                            )
                            Certificado.addCertificado(newCertificado)
                            break
                        }
                        2 -> {
                            print("Ingrese la id del certificado: ")
                            var idCertificado = readLine()?.toInt() as Int
                            Certificado.mostrarCertificados(Certificado.buscarCertificado(idCertificado))
                        }
                        3 -> {
                            print("Actualizar Datos ")
                            print("Ingrese el id del certificado: ")
                            var idCertificado = readLine()?.toInt() as Int
                            print("Ingrese el Nombre del certificado: ")
                            var nombreCertificado = readLine()?.toString() as String
                            print("Ingrese nombre de la plataforma: ")
                            var nombrePlataforma = readLine()?.toString() as String
                            print("Ingres el costo del certificado:")
                            var costoCertificado = readLine()?.toDouble() as Double
                            var fechaCertificado = Date()
                            Certificado.actualizarCertificado(
                                idCertificado,
                                nombreCertificado,
                                nombrePlataforma,
                                costoCertificado,
                                fechaCertificado
                            )
                            break
                        }

                        4 -> {
                            print("Ingrese la id del certificado a eliminar: ")
                            var idCertificado = readLine()?.toInt() as Int
                            Certificado.eliminarcertificado(idCertificado)
                            break
                        }
                    }
                } while (opCertificado != 5)
            }
        }
    } while (op != 3)
}

// Creamos la clase Persona
class Persona(
    cedula: String,
    nombre: String,
    fechaNacimiento: Date,
    edad: Int,
    experiencia: Boolean,
) {
    var cedula: String = cedula
    var nombre: String = nombre
    var fechaNacimiento: Date = fechaNacimiento
    var edad: Int = edad
    var experiencia: Boolean = experiencia

    init {
        // Se ejecuta primero

    }

    companion object {
        var personas = ArrayList<Persona>()

        // Creamos cada uno de los métodos a utilizar

        fun agregarPersona(nuevaPersona: Persona) {
            personas.add(nuevaPersona)
            actualizarArchivoPersona()
            mostrarPersona(personas)
        }

        fun buscarPersona(cedula: String): ArrayList<Persona> {
            return personas.filter { it.cedula == cedula } as ArrayList<Persona>
        }

        fun actualizarPersona(cedula: String, nombre: String, fechaNacimiento: Date, edad: Int, experiencia: Boolean) {
            personas.filter { it.cedula == cedula }.map { it.cedula = cedula }
            personas.filter { it.cedula == cedula }.map { it.nombre = nombre }
            personas.filter { it.cedula == cedula }.map { it.fechaNacimiento = fechaNacimiento }
            personas.filter { it.cedula == cedula }.map { it.edad = edad }
            personas.filter { it.cedula == cedula }.map { it.experiencia = experiencia }
            actualizarArchivoPersona()
            mostrarPersona(personas)
        }

        fun eliminarPersona(cedula: String) {
            personas = personas.filter { it.cedula != cedula } as ArrayList<Persona>
            actualizarArchivoPersona()
            mostrarPersona(personas)
        }

        fun mostrarPersona(persona: ArrayList<Persona>) {
            println("Cedula Nombre FechaNacimiento Edad Experiencia")
            persona.forEach { personaActual: Persona ->
                println(
                    "${personaActual.cedula}," +
                            "${personaActual.nombre}," +
                            "${personaActual.fechaNacimiento}," +
                            "${personaActual.edad}," +
                            "${personaActual.experiencia}\n"
                )
            }
        }

        fun actualizarArchivoPersona() {
            val path = "src/main/kotlin/Archivos/Persona.csv"
            try {
                FileWriter(path, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            out.print("Cedula,Nombre,FechaNacimiento,Edad,Experiencia\n")
                        }
                    }
                }
            } catch (e: IOException) {
                print("Error al leer el archivo, el mensaje de error que se muestra es: ${e}")
            }

            try {
                FileWriter(path, true).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            personas.forEach { personaActual: Persona ->
                                out.print(
                                    "" +
                                            "${personaActual.cedula}" +
                                            ",${personaActual.nombre}" +
                                            ",${personaActual.fechaNacimiento}" +
                                            ",${personaActual.edad}" +
                                            ",${personaActual.experiencia}\n"
                                )
                            }
                        }
                    }
                }
            } catch (e: IOException) {
                print("Error al leer el archivo, el mensaje de error que se muestra es: ${e}")
            }
        }

        fun leerArchivoPersona() {
            var miLector = Scanner(File("src/main/kotlin/Archivos/Persona.csv"))
            var cabecera = miLector.hasNextLine()
            var fila = miLector.nextLine()
            var datos = StringTokenizer(fila, ",")
            while (datos.hasMoreTokens()) {
                datos.nextToken()
            }
            while (miLector.hasNextLine()) {
                fila = miLector.nextLine()
                datos = StringTokenizer(fila, ",")
                while (datos.hasMoreTokens()) {
                    var cedula = datos.nextToken().toString()
                    var nombre = datos.nextToken().toString()
                    var fechaNacimiento = datos.nextToken()
                    var edad = datos.nextToken().toInt()
                    var experiencia = datos.nextToken().toBoolean()
                    var persona = Persona(cedula, nombre, Date(), edad, experiencia)
                    personas.add(persona)
                }
            }
        }

    }
}


// Creamos la clase Certificado
class Certificado(
    id: Int,
    nombre: String,
    plataforma: String,
    costo: Double,
    fechaEmision: Date
) {
    var id: Int = id
    var nombre: String = nombre
    var plataforma: String = plataforma
    var costo: Double = costo
    var fechaEmision: Date = fechaEmision

    init {

    }

    companion object {
        var certificados = ArrayList<Certificado>()

        fun addCertificado(newCertificado: Certificado) {
            certificados.add(newCertificado)
            actualizarArchivoCertificado()
            mostrarCertificados(certificados)
        }

        fun buscarCertificado(id: Int): ArrayList<Certificado> {
            return certificados.filter { it.id == id } as ArrayList<Certificado>
        }

        fun actualizarCertificado(id: Int, nombre: String, plataforma: String, costo: Double, fechaEmision: Date) {
            certificados.filter { it.id == id }.map { it.id = id }
            certificados.filter { it.id == id }.map { it.nombre = nombre }
            certificados.filter { it.id == id }.map { it.plataforma = plataforma }
            certificados.filter { it.id == id }.map { it.costo = costo }
            certificados.filter { it.id == id }.map { it.fechaEmision = fechaEmision }
            actualizarArchivoCertificado()
            mostrarCertificados(certificados)

        }

        fun eliminarcertificado(id: Int) {
            certificados = certificados.filter { it.id != id } as ArrayList<Certificado>
            actualizarArchivoCertificado()
            mostrarCertificados(certificados)
        }

        fun mostrarCertificados(certificados: ArrayList<Certificado>) {

            println("id\tnombre\tplataforma\tcosto\tfechaEmision")
            certificados.forEach { certificadoActual: Certificado ->
                println(
                    "${certificadoActual.id}," +
                            "${certificadoActual.nombre}," +
                            "${certificadoActual.plataforma}," +
                            "${certificadoActual.costo}," +
                            "${certificadoActual.fechaEmision}\n"
                )
            }
        }

        fun actualizarArchivoCertificado() {
            val ruta = "src/main/kotlin/Archivos/Certificado.csv"
            try {
                FileWriter(ruta, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            out.print("id,nombre,plataforma,costo,fechaEmision\n")
                        }
                    }
                }
            } catch (e: IOException) {
                print("Error al leer el archivo, el mensaje de error que se muestra es: ${e}")
            }
            try {
                FileWriter(ruta, true).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            certificados.forEach { certificadoActual: Certificado ->
                                out.print(
                                    "" +
                                            "${certificadoActual.id}," +
                                            "${certificadoActual.nombre}," +
                                            "${certificadoActual.plataforma}," +
                                            "${certificadoActual.costo}," +
                                            "${certificadoActual.fechaEmision}\n"
                                )
                            }
                        }
                    }
                }
            } catch (e: IOException) {
                print("Error al leer el archivo, el mensaje de error que se muestra es: ${e}")
            }
        }

        fun leerArchivoCertificado() {

            var miLector = Scanner(File("src/main/kotlin/Archivos/Certificado.csv"))
            var cabecera = miLector.hasNextLine()
            var fila = miLector.nextLine()
            var datos = StringTokenizer(fila, ",")
            while (datos.hasMoreTokens()) {

                datos.nextToken()

            }
            while (miLector.hasNextLine()) {

                fila = miLector.nextLine()
                datos = StringTokenizer(fila, ",")
                while (datos.hasMoreTokens()) {

                    var id = datos.nextToken().toInt()
                    var nombre = datos.nextToken()
                    var plataforma = datos.nextToken()
                    var costo = datos.nextToken().toDouble()
                    var fechaEmision = datos.nextToken()
                    var miscertificados = Certificado(id, nombre, plataforma, costo, Date())
                    certificados.add(miscertificados)

                }
            }
        }
    }

}