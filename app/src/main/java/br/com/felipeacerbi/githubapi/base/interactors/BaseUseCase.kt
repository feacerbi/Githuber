package br.com.felipeacerbi.githubapi.base.interactors

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlin.coroutines.experimental.suspendCoroutine

abstract class BaseUseCase (
        private val pool: CompositeDisposable = CompositeDisposable()
) : UseCase {

    sealed class Result {
        data class OnSuccess<T>(val items: List<T>) : Result()
        object OnError : Result()
    }

    fun Disposable.addToPool() = pool.add(this)

    suspend fun <T> Single<List<T>>.retrieve(): Result = suspendCoroutine { continuation ->
        subscribe(
                { continuation.resume(Result.OnSuccess(it)) },
                { it.printStackTrace()
                    continuation.resume(Result.OnError) })
                .addToPool()
    }

    override fun cleanUp() {
        pool.clear()
    }
}