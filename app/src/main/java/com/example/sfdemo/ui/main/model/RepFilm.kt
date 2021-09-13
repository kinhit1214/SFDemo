package com.example.sfdemo.ui.main.model


import org.json.JSONObject
import java.net.URL


class RepFilm {

   val tokenUrl : String =  "/token/03f091418e8a7446b19a064aeb15ec86"
   val cloudUrl : String = "https://api.kinopoisk.cloud/movies/"
   val pageUrl : String = "all/page/1"

   val url = cloudUrl + pageUrl +tokenUrl

   fun getDataFilms(): String {
     val apiResopnse = URL(url).readText()
     val jsonObj =JSONObject(apiResopnse).getJSONArray("movies").getJSONObject(1).getString("title")
      return jsonObj
   }

}