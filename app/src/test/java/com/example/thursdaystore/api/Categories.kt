package com.example.thursdaystore.api;

import com.example.thursdaystore.api.parent.OkHttpHelper
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.junit.Test


class Categories : OkHttpHelper() {

    @Test
    fun get() {
        val url = getUrl("/categories", listOf(Pair("lang", "eng")))
        val response: Response = getResponse(url)
        logger.info("response = $response")
        logger.info("string = ${response.body()!!.string()}")
        logger.info("code = ${response.code()}")
        logger.info("categories get")
    }

//    @Test
//    fun post() {
//        val requestBody: RequestBody = MultipartBody.Builder()
//            .setType(MultipartBody.FORM)
//            .addFormDataPart("title", "value")
//            .build()
//        val url = getUrl("/categories")
//        val request: Request = getRequest(url, requestBody, Crud.PUT)
//        val response: Response = getResponse(request)
//    }

}
