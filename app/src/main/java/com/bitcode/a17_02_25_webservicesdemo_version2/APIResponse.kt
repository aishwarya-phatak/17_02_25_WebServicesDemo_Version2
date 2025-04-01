package com.bitcode.a17_02_25_webservicesdemo_version2

import com.google.gson.annotations.SerializedName

data class APIResponse(
    var page : Int,

    @SerializedName("per_page")
    var perPage : Int,

    var total : Int,

    @SerializedName("total_pages")
    var totalPages : Int,
    var users : ArrayList<User>,
    var support : Support
)
