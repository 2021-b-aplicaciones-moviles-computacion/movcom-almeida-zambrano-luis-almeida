package com.example.appcertificados

import android.os.Parcel
import android.os.Parcelable

class Certificado (

    val id_certificado: Int,
    var nombre_curso:String?,
    var nombre_plataforma: String?,
    var fecha: String?

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_certificado)
        parcel.writeString(nombre_curso)
        parcel.writeString(nombre_plataforma)
        parcel.writeString(fecha)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Certificado> {
        override fun createFromParcel(parcel: Parcel): Certificado {
            return Certificado(parcel)
        }

        override fun newArray(size: Int): Array<Certificado?> {
            return arrayOfNulls(size)
        }
    }


}