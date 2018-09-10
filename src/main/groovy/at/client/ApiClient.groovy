package at.client

import at.Configuration
import groovy.json.JsonBuilder
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpPut
import org.apache.http.client.utils.URIBuilder
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder

import static at.utils.DataUtils.httpResponseToMap

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */
class ApiClient {

    private String targetUrl

    ApiClient target(String targetEndpoint) {
        targetUrl = "${Configuration.API_URL == null ? "https://jsonplaceholder.typicode.com" : Configuration.API_URL}/${targetEndpoint}"
        this
    }

    ApiClient param(String key, String value) {
        def builder = new URIBuilder(targetUrl)
        builder.setParameter(key, value)
        targetUrl = builder.build().toString()
        this
    }

    Map get() {
        def request = new HttpGet(targetUrl)
        request.addHeader("content-type", "application/json")

        def client = HttpClientBuilder.create().build()
        def response = client.execute(request)

        httpResponseToMap(response)
    }

    Map put(Map content) {
        def request = new HttpPut(targetUrl)
        request.addHeader("content-type", "application/json")
        def jsonBody = new JsonBuilder(content).toString()
        request.setEntity(new StringEntity(jsonBody))

        def client = HttpClientBuilder.create().build()
        def response = client.execute(request)

        httpResponseToMap(response)
    }

    Map post(Map content) {
        def request = new HttpPost(targetUrl)
        request.addHeader("content-type", "application/json")
        def jsonBody = new JsonBuilder(content).toString()
        request.setEntity(new StringEntity(jsonBody))

        def client = HttpClientBuilder.create().build()
        def response = client.execute(request)

        httpResponseToMap(response)
    }
}