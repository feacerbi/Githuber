package br.com.felipeacerbi.githubapi.network.model

import com.squareup.moshi.Json
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class ReposResponse(

	@Json(name="total_count")
	val totalCount: Int,

	@Json(name="incomplete_results")
	val incompleteResults: Boolean,

	@Json(name="items")
	val items: List<Item?>)
