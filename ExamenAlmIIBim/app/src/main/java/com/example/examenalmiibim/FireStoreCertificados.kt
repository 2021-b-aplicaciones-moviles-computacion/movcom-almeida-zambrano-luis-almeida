package com.example.examenalmiibim

import android.os.Parcel
import android.os.Parcelable

class FireStoreCertificados(
    var certificadoId: String ?,
    var nombre: String?,
    var plataforma: String?,
    var fecha: String?
) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "${nombre}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(certificadoId)
        parcel.writeString(nombre)
        parcel.writeString(plataforma)
        parcel.writeString(fecha)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FireStoreCertificados> {
        override fun createFromParcel(parcel: Parcel): FireStoreCertificados {
            return FireStoreCertificados(parcel)
        }

        override fun newArray(size: Int): Array<FireStoreCertificados?> {
            return arrayOfNulls(size)
        }
    }
}