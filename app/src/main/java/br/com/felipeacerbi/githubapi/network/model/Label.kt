package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Label(

	@Json(name="default")
	val jsonMemberDefault: Boolean? = null,

	@Json(name="color")
	val color: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="description")
	val description: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="url")
	val url: String? = null
)