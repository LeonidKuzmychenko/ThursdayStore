package my.diploma.thursdaystore.api;

import my.diploma.thursdaystore.api.parent.OkHttpHelper
import okhttp3.Response
import org.junit.Test


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
