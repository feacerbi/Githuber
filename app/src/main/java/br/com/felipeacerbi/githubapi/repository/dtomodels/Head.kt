package br.com.felipeacerbi.githubapi.repository.dtomodels

import com.squareup.moshi.Json
data class Head(
    @Json(name = "label") val label: String,
    @Json(name = "ref") val ref: String,
    @Json(name = "sha") val sha: String,
    @Json(name = "user") val user: User,
    @Json(name = "repo") val repo: Repo
)