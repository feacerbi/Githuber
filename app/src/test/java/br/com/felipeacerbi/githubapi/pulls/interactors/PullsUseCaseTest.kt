package br.com.felipeacerbi.githubapi.pulls.interactors

import android.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.pulls.repository.PullsRepository
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

@RunWith(MockitoJUnitRunner.Silent::class)
class PullsUseCaseTest {

    @Rule
    @JvmField
    val instantTaskRule = InstantTaskExecutorRule()

    @Mock private lateinit var pullsRepository: PullsRepository
    @Mock private lateinit var items: List<Pull>
    @Mock private lateinit var throwable: Throwable

    private lateinit var pullsUseCase: PullsUseCaseImpl
    private lateinit var pullsResult: Result

    @Before
    fun setUp() {
        pullsUseCase = PullsUseCaseImpl(pullsRepository)
    }

    @Test
    fun testGetReposSuccess() {
        runBlocking {
            givenRepository(Single.just(items))
            whenPullsFetched()
            thenResultIs(Result.OnSuccess(items))
        }
    }

    @Test
    fun testGetReposFail() {
        runBlocking {
            givenRepository(Single.error(throwable))
            whenPullsFetched()
            thenResultIs(Result.OnError)
        }
    }

    // Givens
    private fun givenRepository(itemsSingle: Single<List<Pull>>) {
        given(pullsRepository.getPulls(TEST_OWNER, TEST_REPO)).willReturn(itemsSingle)
    }

    // Whens
    private suspend fun whenPullsFetched() {
        pullsResult = pullsUseCase.execute(TEST_OWNER, TEST_REPO)
    }

    // Thens
    private fun thenResultIs(result: Result) {
        Assert.assertEquals(pullsResult, result)
    }

    companion object {
        private const val TEST_OWNER = "test_owner"
        private const val TEST_REPO = "test_repo"
    }
}