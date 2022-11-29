package com.beerfind.beerfind.Data

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.serialization.Serializable
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class BeerData {
    private val url = "https://api.punkapi.com/v2/beers"
    val urlIncreasedPageSize = "$url?per_page=80"
    val urlRand = "$url/random"

    private val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    private fun getRequest(url: String): String {
        val client = HttpClient.newBuilder().build()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body()
    }

    fun GetResponse(url: String): List<Beer> {
        val json = getRequest(url)
        val beers: List<Beer> = mapper.readValue(json)
        return beers
    }
}

@Serializable
data class Beer(
    val name: String,
    @JsonProperty("first_brewed")
    val firstBrewed: String,
    val description: String,
    val abv: Float,
    val ibu: Float,
    val ebc: Float,
    val srm: Float,
    @JsonProperty("food_pairing")
    val food: List<String?>,
    @JsonProperty("brewers_tips")
    val brewersTips: String
)