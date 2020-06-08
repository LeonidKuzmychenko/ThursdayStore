package my.diploma.thursdaystore.retrofit;

class RetrofitApi {

    companion object{
        private var URL = "https://thursday.ml/"
        fun server(): ServerRequest = RetrofitCreator.get(URL).create(ServerRequest::class.java)
    }

}