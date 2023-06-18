Modern Movie App with Android Architecture Components
===========================================================

Modern Movie App => designed and built in the  architecture. App built entirely with Kotlin and Jetpack Compose that follows Android design and development best practices. It is currently in development. 

This is the repository for the Modern Movie app. It is a work in progress 🚧.

Introduction
-------------

### Feature
Modern Movie displays playing movie from https://api.themoviedb.org/3/movie/ . Users can browse for all playing now movies, can check each movie's deatil.

### Architecture
Modern Movie follows the google official architecture guidance.
### Modularization
Modern Movie app has been fully modularized and followed google official modularization learning journey.
### Testing
fully convered for unit test.

### Tech stacks 
* Minimum SDK level 24
* Kotlin based, Coroutines + Flow for asynchronous.
* Jetpack Compose : User Interface
* StateFlow: handle UI states upon the lifecycle changes.
* ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
* Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
* Hilt: for dependency injection.
* Architecture
* MVVM Architecture (Model - View - ViewModel)
* Repository Pattern
* Retrofit2 : the REST APIs.
* Moshi: A modern JSON library for Kotlin and Java.
* Material-Components: Material design components.
