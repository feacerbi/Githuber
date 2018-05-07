package br.com.felipeacerbi.githubapi.pulls.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase.Result
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.pulls.interactors.PullsUseCase
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action.FetchPulls
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
class PullsViewModelTest {

    @Rule
    @JvmField
    val instantTaskRule = InstantTaskExecutorRule()

    @Mock private lateinit var pullsUseCase: PullsUseCase
    @Mock private lateinit var observer: Observer<State>
    @Mock private lateinit var items: List<Pull>

    private lateinit var testPullsViewModel: PullsViewModelImpl
    private val state: MutableLiveData<State> = MutableLiveData()

    @Before
    fun setUp() {
        testPullsViewModel = PullsViewModelImpl(pullsUseCase, state, Unconfined)
        state.observeForever(observer)
    }

    @Test
    fun testFetchPulls() {
        runBlocking {
            whenActionReceived(FetchPulls(TEST_OWNER, TEST_REPO))
            thenReceiveState(arrayOf(State.ShowLoading))
            thenUseCaseShouldExecute()
        }
    }

    @Test
    fun testStateSuccess() {
        runBlocking {
            givenExecuteResult(Result.OnSuccess(items))
            whenActionReceived(FetchPulls(TEST_OWNER, TEST_REPO))
            thenReceiveState(arrayOf(State.ShowLoading, State.ItemsLoaded(items), State.ShowContent))
        }
    }

    @Test
    fun testStateFail() {
        runBlocking {
            givenExecuteResult(Result.OnError)
            whenActionReceived(FetchPulls(TEST_OWNER, TEST_REPO))
            thenReceiveState(arrayOf(State.ShowLoading, State.ShowError))
        }
    }

    // Givens
    private suspend fun givenExecuteResult(result: Result) {
        given(pullsUseCase.execute(TEST_OWNER, TEST_REPO)).willReturn(result)
    }

    // Whens
    private fun whenActionReceived(action: Action) {
        testPullsViewModel.performAction(action)
    }

    // Thens
    private fun thenReceiveState(states: Array<State>) {
        states.forEach { then(observer).should().onChanged(it) }
        then(observer).shouldHaveNoMoreInteractions()
    }

    private suspend fun thenUseCaseShouldExecute() {
        then(pullsUseCase).should().execute(TEST_OWNER, TEST_REPO)
        then(pullsUseCase).shouldHaveNoMoreInteractions()
    }

    companion object {
        private const val TEST_OWNER = "test_owner"
        private const val TEST_REPO = "test_repo"
    }
}