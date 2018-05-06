package githubapi.felipeacerbi.com.br.br.base

import br.com.felipeacerbi.githubapi.base.interactors.BaseUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BaseUseCaseTest {

    class TestUseCase(compositeDisposable: CompositeDisposable) : BaseUseCase(compositeDisposable) {
        fun testAdd(testDisposable: Disposable) {
            testDisposable.addToPool()
        }
    }

    @Mock private lateinit var compositeDisposable: CompositeDisposable
    @Mock private lateinit var testDisposable: Disposable

    private lateinit var testUseCase: TestUseCase

    @Before
    fun setUp() {
        testUseCase = TestUseCase(compositeDisposable)
    }

    @Test
    fun testAddSubscriptionsToPool() {
        whenDisposablesAdded()
        thenPoolShouldHaveAdded()
    }

    @Test
    fun testClearSubscriptions() {
        whenDisposablesAdded()
        whenDisposablesCleared()
        thenPoolShouldBeEmpty()
    }

    // Whens
    private fun whenDisposablesCleared() {
        testUseCase.cleanUp()
    }

    private fun whenDisposablesAdded() {
        testUseCase.testAdd(testDisposable)
    }

    // Thens
    private fun thenPoolShouldHaveAdded() {
        then(compositeDisposable).should().add(testDisposable)
        then(compositeDisposable).shouldHaveNoMoreInteractions()
    }

    private fun thenPoolShouldBeEmpty() {
        then(compositeDisposable).should().add(testDisposable)
        then(compositeDisposable).should().clear()
        then(compositeDisposable).shouldHaveNoMoreInteractions()
    }

}