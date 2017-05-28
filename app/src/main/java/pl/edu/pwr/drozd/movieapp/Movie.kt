package pl.edu.pwr.drozd.movieapp

import android.os.Parcel
import android.os.Parcelable


data class Movie(val title: String, val genre: String, val year: String, val description: String = "BLAH BLAH", val URL: String = "URL", var watched: Boolean = false) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(genre)
        dest.writeString(year)
        dest.writeString(description)
        dest.writeString(URL)
        dest.writeInt((if (watched) 1 else 0))
    }
}
