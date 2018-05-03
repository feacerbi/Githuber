package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json

data class PullsResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "url") val url: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "diff_url") val diffUrl: String,
    @Json(name = "patch_url") val patchUrl: String,
    @Json(name = "issue_url") val issueUrl: String,
    @Json(name = "commits_url") val commitsUrl: String,
    @Json(name = "review_comments_url") val reviewCommentsUrl: String,
    @Json(name = "review_comment_url") val reviewCommentUrl: String,
    @Json(name = "comments_url") val commentsUrl: String,
    @Json(name = "statuses_url") val statusesUrl: String,
    @Json(name = "number") val number: Int,
    @Json(name = "state") val state: String,
    @Json(name = "title") val title: String,
    @Json(name = "body") val body: String,
    @Json(name = "assignee") val assignee: Assignee,
    @Json(name = "labels") val labels: List<Label>,
    @Json(name = "milestone") val milestone: Milestone,
    @Json(name = "locked") val locked: Boolean,
    @Json(name = "active_lock_reason") val activeLockReason: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    @Json(name = "closed_at") val closedAt: String,
    @Json(name = "merged_at") val mergedAt: String,
    @Json(name = "head") val head: Head,
    @Json(name = "base") val base: Base,
    @Json(name = "_links") val links: Links,
    @Json(name = "user") val user: User
)