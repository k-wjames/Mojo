package ke.co.ideagalore.mojo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ke.co.ideagalore.mojo.R
import ke.co.ideagalore.mojo.model.Post

class PostListAdapter(private val postList:ArrayList<Post>):
    RecyclerView.Adapter<PostViewHolder>() {

    fun updatePostList(newUpdatedPosts:List<Post>) {
        postList.clear()
        postList.addAll(newUpdatedPosts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.post_child,parent, false)
        return  PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.id.text=postList[position].id.toString()
        holder.title.text=postList[position].title
        holder.body.text=postList[position].body
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}

class PostViewHolder(view:View):RecyclerView.ViewHolder(view){
    val id: TextView=view.findViewById(R.id.tv_one);
    val title: TextView=view.findViewById(R.id.tv_two);
    val body: TextView=view.findViewById(R.id.tv_three);
}