package network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object APIConfig {
    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    // client
    val client = HttpClient {
        // configuration parameters
        install(ContentNegotiation){
           json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                prettyPrint = true
            })
        }

    }

}