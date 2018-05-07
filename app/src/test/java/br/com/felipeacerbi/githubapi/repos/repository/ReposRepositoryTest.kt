package br.com.felipeacerbi.githubapi.repos.repository

import android.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.network.model.ReposResponse
import br.com.felipeacerbi.githubapi.network.utils.Mapper
import br.com.felipeacerbi.githubapi.repos.model.Repo
import io.reactivex.Single
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.coroutines.experimental.suspendCoroutine

@RunWith(MockitoJUnitRunner::class)
class ReposRepositoryTest {

    @Rule
    @JvmField
    val instantTaskRule = InstantTaskExecutorRule()

    @Mock private lateinit var gitHubApi: GitHubApi
    @Mock private lateinit var response: ReposResponse
    @Mock private lateinit var items: List<Repo>
    @Mock private lateinit var mapper: Mapper

    private lateinit var reposRepository: ReposRepository
    private lateinit var fetchResult: Result

    @Before
    fun setUp() {
        reposRepository = ReposRepositoryImpl(gitHubApi, mapper)
    }

    @Test
    fun testGetReposSuccess() {
        runBlocking {
            givenApiResponse(Single.just(response))
            givenMap()
            whenReposFetched()
            thenResultIs(Result.OnSuccess(items))
        }
    }

    // Givens
    private fun givenApiResponse(singleResponse: Single<ReposResponse>) {
        given(gitHubApi.fetchRepos(TEST_LANGUAGE, TEST_PAGE)).willReturn(singleResponse)
    }

    private fun givenMap() {
        given(mapper.map(response)).willReturn(items)
    }

    // Whens
    private suspend fun whenReposFetched() {
        fetchResult = reposRepository.getRepos(TEST_LANGUAGE, TEST_PAGE).retrieve()
    }

    // Thens
    private fun thenResultIs(result: Result) {
        Assert.assertEquals(result, fetchResult)
    }

    private suspend fun <T> Single<List<T>>.retrieve(): Result = suspendCoroutine { continuation ->
        subscribe(
                { continuation.resume(Result.OnSuccess(it)) },
                { continuation.resume(Result.OnError) })
    }

    companion object {
        private const val TEST_LANGUAGE = "test_language"
        private const val TEST_PAGE = 0
    }
}