package dev.nancy.mypost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET ("/Posts")
    fun getPosts():Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId") postId: Int): Call<Post>
}