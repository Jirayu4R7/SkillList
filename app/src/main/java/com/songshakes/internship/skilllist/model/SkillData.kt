package com.songshakes.internship.skilllist.model

import android.os.Parcel
import android.os.Parcelable

class SkillData(val skillName: String,
                val skillCatalog: String,
                val skillSubCatalog: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(dest: Parcel?, p1: Int) {
        dest?.writeString(skillName)
        dest?.writeString(skillCatalog)
        dest?.writeString(skillSubCatalog)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SkillData> {
        override fun createFromParcel(parcel: Parcel): SkillData {
            return SkillData(parcel)
        }

        override fun newArray(size: Int): Array<SkillData?> {
            return arrayOfNulls(size)
        }
    }
}