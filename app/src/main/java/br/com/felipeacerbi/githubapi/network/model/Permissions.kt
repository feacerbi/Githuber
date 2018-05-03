package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
data class Permissions(
    @Json(name = "admin") val admin: Boolean,
    @Json(name = "push") val push: Boolean,
    @Json(name = "pull") val pull: Boolean
)