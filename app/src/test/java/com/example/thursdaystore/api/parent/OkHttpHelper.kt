package com.example.thursdaystore.api.parent

import okhttp3.*
import java.util.logging.Logger

abstract class OkHttpHelper {

    val logger = Logger.getLogger(this.javaClass.canonicalName)

    fun getUrl(request: String): String {
        return getUrl(request, emptyList())
    }

    fun getUrl(request: String, query: List<Pair<String, String>>): String {
        val mainUrl = "https://thursday.ml/"
        val urlBuilder = HttpUrl.parse("$mainUrl$request")!!.newBuilder()
        if (!query.isNullOrEmpty())
            query.forEach { urlBuilder.addQueryParameter(it.first, it.second) }
        return urlBuilder.build().toString()
    }

    fun getRequest(url: String): Request {
        return getRequest(url, emptyList(), null, Crud.GET)
    }

    fun getRequest(url: String, headers: List<Pair<String, String>>): Request {
        return getRequest(url, headers, null, Crud.GET)
    }

    fun getRequest(url: String, body: RequestBody, type: Crud): Request {
        return getRequest(url, emptyList(), body, type)
    }

    fun getRequest(url: String, headers: List<Pair<String, String>>, body: RequestBody?, type: Crud): Request {
        val requestBuilder = Request.Builder()
        if (!headers.isNullOrEmpty())
            headers.forEach { requestBuilder.addHeader(it.first, it.second) }

        val builder = requestBuilder.url(url)

        when (type) {
            Crud.POST -> builder.post(body)
            Crud.PUT -> builder.put(body)
            Crud.DELETE -> builder.delete(body)
            else -> {}
        }
        return requestBuilder.url(url).build()
    }

    enum class Crud {
        GET, POST, PUT, DELETE
    }

    fun getResponse(request: Request): Response {
        return OkHttpClient().newCall(request).execute()
    }

    fun getResponse(url: String): Response {
        val request = getRequest(url)
        return OkHttpClient().newCall(request).execute()
    }
}