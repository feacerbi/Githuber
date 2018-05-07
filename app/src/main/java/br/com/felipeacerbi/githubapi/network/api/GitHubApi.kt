package br.com.felipeacerbi.githubapi.network.api

import br.com.felipeacerbi.githubapi.network.model.PullsResponse
import br.com.felipeacerbi.githubapi.network.model.ReposResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("/search/repositories?sort=stars&per_page=10")
    fun fetchRepos(@Query("q") lang: String, @Query("page") page: Int): Single<ReposResponse>

    @GET("/repos/{owner}/{repository}/pulls")
    fun fetchPulls(@Path("owner") owner: String, @Path("repository") repo: String): Single<List<PullsResponse>>

}