package com.example.appcertificados

import android.os.Parcel
import android.os.Parcelable

class Persona (
    val id_persona: Int,
    val nombre: String?,
    var edad: String?,
    var correo: String?
    ) : Parcelable {
    override fun toString(): String {
        return "${nombre}"
    }

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_persona)
        parcel.writeString(nombre)
        parcel.writeString(edad)
        parcel.writeString(correo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }
}