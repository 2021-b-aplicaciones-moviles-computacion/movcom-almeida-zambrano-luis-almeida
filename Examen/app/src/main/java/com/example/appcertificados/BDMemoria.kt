package com.example.appcertificados

class BDMemoria {
    companion object{
        var arr_persona = arrayListOf<Persona>()
        var arr_certificado = arrayListOf<Certificado>()
        var arr_persona_x_certificado = arrayListOf<Persona_x_Certificado>()

        init {
            // Cargamos los datos de la Persona
            arr_persona.add(Persona(1,"Luis Almeida", "23", "luis.almeida@mail.com"))
            arr_persona.add(Persona(2,"Zaida Caisapanta", "24", "zaida.caisapanta@mail.com"))
            arr_persona.add(Persona(3,"Edison Cabrera", "23", "edison.cabrera@mail.com"))
            arr_persona.add(Persona(4,"Guillermo Lasso", "45", "guillermo.lasso@mail.com"))
            arr_persona.add(Persona(5,"Brayan Fernandez", "28", "brayan.fernandez@mail.com"))
            arr_persona.add(Persona(6,"Ernesto Almeida", "56", "ernesto.almeida@mail.com"))

            // Cargamos los datos del Certificado

            arr_certificado.add(Certificado(1, "Android desde 0", "Udemy", "02/02/2019"))
            arr_certificado.add(Certificado(2, "Python desde 0", "Platzi", "05/03/2020"))
            arr_certificado.add(Certificado(3, "Boot Camp Golang", "Coursera", "17/12/2021"))
            arr_certificado.add(Certificado(4, "Universidad de Java", "Udemy", "12/12/2021"))
            arr_certificado.add(Certificado(5, "Profesional de Git & GitHub", "CodigoFacilito", "19/11/2021"))
            arr_certificado.add(Certificado(6, "Figma desde 0", "Platzi", "16/08/2017"))

            // Cargamos la información de Persona x Certificado

            arr_persona_x_certificado.add(Persona_x_Certificado(1,1))
            arr_persona_x_certificado.add(Persona_x_Certificado(1,3))
            arr_persona_x_certificado.add(Persona_x_Certificado(1,5))
            arr_persona_x_certificado.add(Persona_x_Certificado(1,6))

            arr_persona_x_certificado.add(Persona_x_Certificado(2,1))
            arr_persona_x_certificado.add(Persona_x_Certificado(2,2))
            arr_persona_x_certificado.add(Persona_x_Certificado(2,3))

            arr_persona_x_certificado.add(Persona_x_Certificado(3,5))
            arr_persona_x_certificado.add(Persona_x_Certificado(3,3))
            arr_persona_x_certificado.add(Persona_x_Certificado(3,4))

            arr_persona_x_certificado.add(Persona_x_Certificado(4,2))
            arr_persona_x_certificado.add(Persona_x_Certificado(4,4))
            arr_persona_x_certificado.add(Persona_x_Certificado(4,6))

            arr_persona_x_certificado.add(Persona_x_Certificado(5,1))
            arr_persona_x_certificado.add(Persona_x_Certificado(5,2))
            arr_persona_x_certificado.add(Persona_x_Certificado(5,3))
            arr_persona_x_certificado.add(Persona_x_Certificado(5,5))
            arr_persona_x_certificado.add(Persona_x_Certificado(5,6))

            arr_persona_x_certificado.add(Persona_x_Certificado(6,1))
            arr_persona_x_certificado.add(Persona_x_Certificado(6,3))
            arr_persona_x_certificado.add(Persona_x_Certificado(6,5))
            arr_persona_x_certificado.add(Persona_x_Certificado(6,2))
        }
    }
}