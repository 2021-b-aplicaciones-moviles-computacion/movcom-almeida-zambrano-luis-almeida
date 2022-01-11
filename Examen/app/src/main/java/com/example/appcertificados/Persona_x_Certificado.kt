package com.example.appcertificados

import android.os.Parcel
import android.os.Parcelable

class Persona_x_Certificado (

    val id_persona: Int,
    val id_certificado: Int

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_persona)
        parcel.writeInt(id_certificado)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Persona_x_Certificado> {
        override fun createFromParcel(parcel: Parcel): Persona_x_Certificado {
            return Persona_x_Certificado(parcel)
        }

        override fun newArray(size: Int): Array<Persona_x_Certificado?> {
            return arrayOfNulls(size)
        }
    }
}