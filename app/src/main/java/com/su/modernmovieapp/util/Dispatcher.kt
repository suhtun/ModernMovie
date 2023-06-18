package com.su.modernmovieapp.util

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val movieDispatcher: MovieDispatchers)

enum class MovieDispatchers {
    IO
}
