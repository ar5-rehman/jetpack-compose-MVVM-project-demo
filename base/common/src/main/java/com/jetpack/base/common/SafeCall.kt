package com.jetpack.base.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import timber.log.Timber
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

suspend fun <T> api(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall())
        } catch (throwable: Throwable) {
            Timber.e(throwable)
            ResultWrapper.Error(throwable)
        }
    }
}

suspend fun <T> safeDataQuery(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    dataQuery: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(dataQuery())
        } catch (throwable: Throwable) {
            Timber.e(throwable)
            ResultWrapper.Error(throwable)
        }
    }
}

fun <T> flowDataQuery(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    dataQuery: suspend () -> T
): Flow<ResultWrapper<T>> {
    return flow {
        emit(ResultWrapper.Loading)
        emit(ResultWrapper.Success(dataQuery()))
    }
        .catch { emit(ResultWrapper.Error(it)) }
        .flowOn(dispatcher)
}

@Composable
fun <T : R, R> Flow<T>.collectAsState(
    initial: R,
    key: Any?,
    context: CoroutineContext = EmptyCoroutineContext
): State<R> = produceState(initial, key, context) {
    if (context == EmptyCoroutineContext) {
        collect { value = it }
    } else withContext(context) {
        collect { value = it }
    }
}
