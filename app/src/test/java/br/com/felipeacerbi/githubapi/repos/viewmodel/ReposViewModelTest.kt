package br.com.felipeacerbi.githubapi.repos.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.repos.interactors.ReposUseCase
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ReposViewModelTest {

    @Rule
    @JvmField
    val instantTaskRule = InstantTaskExecutorRule()

    @Mock private lateinit var reposUseCase: ReposUseCase
    @Mock private lateinit var observer: Observer<State>
    @Mock private lateinit var items: List<Repo>

    private lateinit var testReposViewModel: ReposViewModelImpl
    private val state: MutableLiveData<State> = MutableLiveData()

    @Before
    fun setUp() {
        testReposViewModel = ReposViewModelImpl(reposUseCase, state, Unconfined)
        state.observeForever(observer)
    }

    @Test
    fun testFetchRepos() {
        runBlocking {
            whenActionReceived(Action.FetchRepos(TEST_LANGUAGE, TEST_PAGE))
            thenReceiveState(arrayOf(State.ShowLoading))
            thenUseCaseShouldExecute()
        }
    }

    @Test
    fun testStateSuccess() {
        runBlocking {
            givenExecuteResult(Result.OnSuccess(items))
            whenActionReceived(Action.FetchRepos(TEST_LANGUAGE, TEST_PAGE))
            thenReceiveState(arrayOf(State.ShowLoading, State.ItemsLoaded(items), State.ShowContent))
        }
    }

    @Test
    fun testStateFail() {
        runBlocking {
            givenExecuteResult(Result.OnError)
            whenActionReceived(Action.FetchRepos(TEST_LANGUAGE, TEST_PAGE))
            thenReceiveState(arrayOf(State.ShowLoading, State.ShowError))
        }
    }

    // Givens
    private suspend fun givenExecuteResult(result: Result) {
        given(reposUseCase.execute(TEST_LANGUAGE, TEST_PAGE)).willReturn(result)
    }

    // Whens
    private fun whenActionReceived(action: Action) {
        testReposViewModel.performAction(action)
    }

    // Thens
    private fun thenReceiveState(states: Array<State>) {
        states.forEach { then(observer).should().onChanged(it) }
        then(observer).shouldHaveNoMoreInteractions()
    }

    private suspend fun thenUseCaseShouldExecute() {
        then(reposUseCase).should().execute(TEST_LANGUAGE, TEST_PAGE)
        then(reposUseCase).shouldHaveNoMoreInteractions()
    }

    companion object {
        private const val TEST_LANGUAGE = "test_language"
        private const val TEST_PAGE = 0
    }
}