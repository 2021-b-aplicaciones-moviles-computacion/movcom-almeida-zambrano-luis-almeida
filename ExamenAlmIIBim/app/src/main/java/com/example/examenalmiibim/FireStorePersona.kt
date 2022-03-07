package com.example.examenalmiibim

import android.os.Parcel
import android.os.Parcelable

class FireStorePersona (
    var nombre: String?,
    var email: String?,
    var edad: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    ) {
    }

    override fun toString(): String {
        return "${nombre}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(email)
        parcel.writeString(edad)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FireStorePersona> {
        override fun createFromParcel(parcel: Parcel): FireStorePersona {
            return FireStorePersona(parcel)
        }

        override fun newArray(size: Int): Array<FireStorePersona?> {
            return arrayOfNulls(size)
        }
    }

}