package githubapi.felipeacerbi.com.br.br.repos.interactors

import android.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCaseImpl
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.repos.repository.ReposRepository
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

@RunWith(MockitoJUnitRunner::class)
class ReposUseCaseTest {

    @Rule
    @JvmField
    val instantTaskRule = InstantTaskExecutorRule()

    @Mock private lateinit var reposRepository: ReposRepository
    @Mock private lateinit var items: List<Repo>
    @Mock private lateinit var throwable: Throwable

    private lateinit var reposUseCase: ReposUseCaseImpl
    private lateinit var reposResult: Result

    @Before
    fun setUp() {
        reposUseCase = ReposUseCaseImpl(reposRepository)
    }

    @Test
    fun testGetReposSuccess() {
        runBlocking {
            givenRepository(Single.just(items))
            whenReposFetched()
            thenResultIs(Result.OnSuccess(items))
        }
    }

    @Test
    fun testGetReposFail() {
        runBlocking {
            givenRepository(Single.error(throwable))
            whenReposFetched()
            thenResultIs(Result.OnError)
        }
    }

    // Givens
    private fun givenRepository(itemsSingle: Single<List<Repo>>) {
        given(reposRepository.getRepos(TEST_LANGUAGE, TEST_PAGE)).willReturn(itemsSingle)
    }

    // Whens
    private suspend fun whenReposFetched() {
        reposResult = reposUseCase.execute(TEST_LANGUAGE, TEST_PAGE)
    }

    // Thens
    private fun thenResultIs(result: Result) {
        Assert.assertEquals(reposResult, result)
    }

    companion object {
        private const val TEST_LANGUAGE = "test_language"
        private const val TEST_PAGE = 0
    }
}