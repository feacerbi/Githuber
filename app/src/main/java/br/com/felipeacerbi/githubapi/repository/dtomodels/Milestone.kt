package br.com.felipeacerbi.githubapi.repository.dtomodels

import com.squareup.moshi.Json
data class Milestone(
    @Json(name = "url") val url: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "labels_url") val labelsUrl: String,
    @Json(name = "id") val id: Int,
    @Json(name = "number") val number: Int,
    @Json(name = "state") val state: String,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String,
    @Json(name = "creator") val creator: Creator,
    @Json(name = "open_issues") val openIssues: Int,
    @Json(name = "closed_issues") val closedIssues: Int,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    @Json(name = "closed_at") val closedAt: String,
    @Json(name = "due_on") val dueOn: String
)