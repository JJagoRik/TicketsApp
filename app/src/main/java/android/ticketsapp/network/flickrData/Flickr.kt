package com.example.example

import com.google.gson.annotations.SerializedName


data class Flickr (
  @SerializedName("photos" ) var photos : Photos? = Photos(),
  @SerializedName("extra"  ) var extra  : Extra?  = Extra(),
  @SerializedName("stat"   ) var stat   : String? = null
)