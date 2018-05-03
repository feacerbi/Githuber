package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
data class Comments(
    @Json(name = "href") val href: String
)