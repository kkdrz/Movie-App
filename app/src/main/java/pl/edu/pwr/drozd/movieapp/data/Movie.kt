package pl.edu.pwr.drozd.movieapp.data

data class Movie(val title: String, val genre: String, val year: String, val description: String = "BLAH BLAH", val URL: String = "URL", var watched: Boolean = false, var rating: Float = 0.0F)