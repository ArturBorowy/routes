package pl.arturborowy.rnm.base.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder =chain.request().newBuilder().apply {
            addHeader("X-KOLEO-Version", "1")
        }

        return chain.proceed(requestBuilder.build())
    }
}