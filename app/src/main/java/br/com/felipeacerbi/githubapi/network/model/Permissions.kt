package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Permissions(

	@Json(name="pull")
	val pull: Boolean? = null,

	@Json(name="admin")
	val admin: Boolean? = null,

	@Json(name="push")
	val push: Boolean? = null
)