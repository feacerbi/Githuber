package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class PullsResponse(

		@Json(name="issue_url")
	val issueUrl: String? = null,

		@Json(name="_links")
	val links: Links? = null,

		@Json(name="diff_url")
	val diffUrl: String? = null,

		@Json(name="created_at")
	val createdAt: String? = null,

		@Json(name="title")
	val title: String? = null,

		@Json(name="body")
	val body: String? = null,

		@Json(name="head")
	val head: Head? = null,

		@Json(name="number")
	val number: Int? = null,

		@Json(name="patch_url")
	val patchUrl: String? = null,

		@Json(name="updated_at")
	val updatedAt: String? = null,

		@Json(name="comments_url")
	val commentsUrl: String? = null,

		@Json(name="review_comment_url")
	val reviewCommentUrl: String? = null,

		@Json(name="active_lock_reason")
	val activeLockReason: String? = null,

		@Json(name="id")
	val id: Int? = null,

		@Json(name="state")
	val state: String? = null,

		@Json(name="locked")
	val locked: Boolean? = null,

		@Json(name="commits_url")
	val commitsUrl: String? = null,

		@Json(name="closed_at")
	val closedAt: String? = null,

		@Json(name="statuses_url")
	val statusesUrl: String? = null,

		@Json(name="merged_at")
	val mergedAt: String? = null,

		@Json(name="url")
	val url: String? = null,

		@Json(name="labels")
	val labels: List<Label?>? = null,

		@Json(name="milestone")
	val milestone: Milestone? = null,

		@Json(name="html_url")
	val htmlUrl: String? = null,

		@Json(name="review_comments_url")
	val reviewCommentsUrl: String? = null,

		@Json(name="assignee")
	val assignee: Assignee? = null,

		@Json(name="user")
	val user: User? = null,

		@Json(name="base")
	val base: Base? = null
)