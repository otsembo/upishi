package data.repository

import data.models.CategoryResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import network.APIConfig

class AppRepository {
    private val config = APIConfig
    // test response
    private suspend fun  getTestResponse(): HttpResponse {
        return config.client.get("${config.BASE_URL}categories.php"){
            header(HttpHeaders.Accept, ContentType.Application.Json)
        }
    }

    // execute network calls
    fun executeNetworkCall(call: suspend () -> HttpResponse = ::getTestResponse) {
        CoroutineScope(Dispatchers.Main).launch {
            val x = call()
            println("RESPONSE: ${x.body<CategoryResponse>()}")
        }
    }

}