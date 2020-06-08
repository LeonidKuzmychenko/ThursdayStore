package my.diploma.thursdaystore.api;

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import my.diploma.thursdaystore.api.parent.OkHttpHelper
import my.diploma.thursdaystore.retrofit.dto.category.CategoryResponse
import okhttp3.Response
import org.junit.Assert
import org.junit.Test

class Categories : OkHttpHelper() {

    @Test
    fun get() {
        val url = getUrl("/categories", listOf(Pair("lang", "eng")))
        val response: Response = getResponse(url)
        val responseJson = response.body()!!.string()

        Assert.assertEquals("Response type is valid", 200 , response.code())
        logger.info("Response code = ${response.code()}")
        logger.info("Response body = $responseJson")
        val listType = Types.newParameterizedType(List::class.java, CategoryResponse::class.java)
        val adapter: JsonAdapter<List<CategoryResponse>> = Moshi.Builder().build().adapter(listType)
        val type = adapter.fromJson(responseJson)

        Assert.assertEquals("Response type is valid", true , type is List<CategoryResponse>)
        logger.info("Response type is valid = ${type is List<CategoryResponse>}")
    }

}
