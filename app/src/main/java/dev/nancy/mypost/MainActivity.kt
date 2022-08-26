package dev.nancy.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.nancy.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }

    fun fetchPosts() {
        val ApiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = ApiClient.getPosts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>,
                response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    Toast.makeText(
                        baseContext, "${post!!.size} posts", Toast.LENGTH_LONG).show()
                    var postsRVAdapter = postsRVAdapter(baseContext, post)
                    binding.rvPosts.layoutManager = LinearLayoutManager(baseContext)
                    binding.rvPosts.adapter = postsRVAdapter
                }


            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()

            }
        })


    }
}











