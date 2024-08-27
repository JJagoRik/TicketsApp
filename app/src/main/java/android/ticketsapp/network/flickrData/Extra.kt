package com.example.example

import com.google.gson.annotations.SerializedName


data class Extra (
  @SerializedName("explore_date"          ) var exploreDate         : String? = null,
  @SerializedName("next_prelude_interval" ) var nextPreludeInterval : Int?    = null
)