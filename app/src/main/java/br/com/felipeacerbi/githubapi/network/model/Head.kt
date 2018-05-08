package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Head(

        @Json(name="ref")
	val ref: String? = null,

        @Json(name="repo")
	val repo: Repository? = null,

        @Json(name="label")
	val label: String? = null,

        @Json(name="sha")
	val sha: String? = null,

        @Json(name="user")
	val user: User? = null
)