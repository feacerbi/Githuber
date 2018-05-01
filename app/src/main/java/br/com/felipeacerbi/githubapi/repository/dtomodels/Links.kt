package br.com.felipeacerbi.githubapi.repository.dtomodels

import com.squareup.moshi.Json
data class Links(
    @Json(name = "self") val self: Self,
    @Json(name = "html") val html: Html,
    @Json(name = "issue") val issue: Issue,
    @Json(name = "comments") val comments: Comments,
    @Json(name = "review_comments") val reviewComments: ReviewComments,
    @Json(name = "review_comment") val reviewComment: ReviewComment,
    @Json(name = "commits") val commits: Commits,
    @Json(name = "statuses") val statuses: Statuses
)