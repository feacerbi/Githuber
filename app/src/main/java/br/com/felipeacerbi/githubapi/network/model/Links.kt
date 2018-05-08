package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Links(

	@Json(name="comments")
	val comments: Comments? = null,

	@Json(name="issue")
	val issue: Issue? = null,

	@Json(name="self")
	val self: Self? = null,

	@Json(name="review_comments")
	val reviewComments: ReviewComments? = null,

	@Json(name="commits")
	val commits: Commits? = null,

	@Json(name="statuses")
	val statuses: Statuses? = null,

	@Json(name="html")
	val html: Html? = null,

	@Json(name="review_comment")
	val reviewComment: ReviewComment? = null
)