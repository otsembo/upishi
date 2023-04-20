package network

sealed class AppResource <T> (val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : AppResource<T>(data)
    class Loading<T>(data: T? = null) : AppResource<T>(data)
    class Error<T>(message: String, data: T? = null) : AppResource<T>(data, message)
}