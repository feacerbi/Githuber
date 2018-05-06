package githubapi.felipeacerbi.com.br.br.pulls.repository

import android.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.network.api.GitHubApi
import br.com.felipeacerbi.githubapi.network.model.PullsResponse
import br.com.felipeacerbi.githubapi.network.utils.Mapper
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.pulls.repository.PullsRepository
import br.com.felipeacerbi.githubapi.pulls.repository.PullsRepositoryImpl
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
class PullsRepositoryTest {

    @Rule
    @JvmField
    val instantTaskRule = InstantTaskExecutorRule()

    @Mock private lateinit var gitHubApi: GitHubApi
    @Mock private lateinit var response: List<PullsResponse>
    @Mock private lateinit var mapper: Mapper
    @Mock private lateinit var items: List<Pull>

    private lateinit var pullsRepository: PullsRepository
    private lateinit var fetchResult: Result

    @Before
    fun setUp() {
        pullsRepository = PullsRepositoryImpl(gitHubApi, mapper)
    }

    @Test
    fun testGetPullsSuccess() {
        runBlocking {
            givenApiResponse(Single.just(response))
            givenMap()
            whenPullsFetched()
            thenResultIs(Result.OnSuccess(items))
        }
    }

    // Givens
    private fun givenApiResponse(singleResponse: Single<List<PullsResponse>>) {
        given(gitHubApi.fetchPulls(TEST_OWNER, TEST_REPO)).willReturn(singleResponse)
    }

    private fun givenMap() {
        given(mapper.map(response)).willReturn(items)
    }

    // Whens
    private suspend fun whenPullsFetched() {
        fetchResult = pullsRepository.getPulls(TEST_OWNER, TEST_REPO).retrieve()
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
        private const val TEST_OWNER = "test_owner"
        private const val TEST_REPO = "test_repo"
    }
}