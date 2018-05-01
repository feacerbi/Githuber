package br.com.felipeacerbi.githubapi.repository.dtomodels

import com.squareup.moshi.Json
data class Comments(
    @Json(name = "href") val href: String
)