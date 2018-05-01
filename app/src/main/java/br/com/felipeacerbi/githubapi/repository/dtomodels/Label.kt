package br.com.felipeacerbi.githubapi.repository.dtomodels

import com.squareup.moshi.Json
data class Label(
    @Json(name = "id") val id: Int,
    @Json(name = "url") val url: String,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "color") val color: String,
    @Json(name = "default") val default: Boolean
)