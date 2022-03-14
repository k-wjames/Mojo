package ke.co.ideagalore.mojo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ke.co.ideagalore.mojo.R
import ke.co.ideagalore.mojo.model.Post

class PostListAdapter(private val postList:ArrayList<Post>):
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.post_child,parent, false)
        return  PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class PostViewHolder(val view:View):RecyclerView.ViewHolder(view){

}