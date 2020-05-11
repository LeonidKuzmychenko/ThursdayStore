package com.example.thursdaystore.api;

import com.example.thursdaystore.api.parent.OkHttpHelper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.junit.Test
import java.util.logging.Logger


class Languages : OkHttpHelper() {

    @Test
    fun test(){
        val response: Response = getResponse(getUrl("/languages"))
        logger.info("response = $response")
        logger.info("string = ${response.body()!!.string()}")
        logger.info("code = ${response.code()}")
        logger.info("test 1")
    }
}
