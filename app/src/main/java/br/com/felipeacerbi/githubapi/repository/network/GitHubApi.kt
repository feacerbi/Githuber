package br.com.felipeacerbi.githubapi.repository.network

import br.com.felipeacerbi.githubapi.repository.dtomodels.PullsResponse
import br.com.felipeacerbi.githubapi.repository.dtomodels.ReposResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("/search/repositories?sort=stars")
    fun fetchRepos(@Query("q") lang: String, @Query("page") page: Int): Single<ReposResponse>

    @GET("/repos/{owner}/{repo}/pulls")
    fun fetchPulls(@Path("owner") owner: String, @Path("repo") repo: String): Single<List<PullsResponse>>

}