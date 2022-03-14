package ke.co.ideagalore.mojo.data.api

import io.reactivex.Single
import ke.co.ideagalore.mojo.model.Post
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    fun getPosts(): Single<List<Post>>
}