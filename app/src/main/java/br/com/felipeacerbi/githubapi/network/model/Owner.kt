package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Owner(

	@Json(name="received_events_url")
	val receivedEventsUrl: String? = null,

	@Json(name="avatar_url")
	val avatarUrl: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="login")
	val login: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="gravatar_id")
	val gravatarId: String? = null,

	@Json(name="url")
	val url: String? = null
)