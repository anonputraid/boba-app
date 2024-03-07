package com.zulkarnaen.submission_api_30_android_pemula

import android.os.Parcel
import android.os.Parcelable

data class Boba(val name: String?, val description: String?, val photo: Int, val harga: String?, val photoStr: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(photo)
        parcel.writeString(harga)
        parcel.writeString(photoStr)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Boba> {
        override fun createFromParcel(parcel: Parcel): Boba {
            return Boba(parcel)
        }

        override fun newArray(size: Int): Array<Boba?> {
            return arrayOfNulls(size)
        }
    }
}
