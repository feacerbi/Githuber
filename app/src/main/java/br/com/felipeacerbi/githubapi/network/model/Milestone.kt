package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Milestone(

	@Json(name="creator")
	val creator: Creator? = null,

	@Json(name="closed_at")
	val closedAt: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="created_at")
	val createdAt: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="closed_issues")
	val closedIssues: Int? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="due_on")
	val dueOn: String? = null,

	@Json(name="labels_url")
	val labelsUrl: String? = null,

	@Json(name="number")
	val number: Int? = null,

	@Json(name="updated_at")
	val updatedAt: String? = null,

	@Json(name="html_url")
	val htmlUrl: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="state")
	val state: String? = null,

	@Json(name="open_issues")
	val openIssues: Int? = null
)