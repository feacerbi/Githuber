package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
data class Base(
    @Json(name = "label") val label: String,
    @Json(name = "ref") val ref: String,
    @Json(name = "sha") val sha: String,
    @Json(name = "user") val user: User,
    @Json(name = "repo") val repo: Repo
)