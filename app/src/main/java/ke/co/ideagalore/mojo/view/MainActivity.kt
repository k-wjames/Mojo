package ke.co.ideagalore.mojo.view

import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ke.co.ideagalore.mojo.R
import ke.co.ideagalore.mojo.databinding.ActivityMainBinding
import ke.co.ideagalore.mojo.viewmodel.PostListViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostListViewModel
    private val postListAdapter = PostListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme)
        } else {
            setTheme(R.style.AppTheme)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvGreetings.text=getGreetingMessage()

        binding.switchtheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        viewModel = ViewModelProvider(this).get(PostListViewModel::class.java)
        viewModel.refresh()

        binding.rvPosts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.posts.observe(this, Observer { postList ->
            postList?.let {
                postListAdapter.updatePostList(postList)
            }
        })
    }

    fun getGreetingMessage():String{
        val c = Calendar.getInstance()
        val timeOfDay = c.get(Calendar.HOUR_OF_DAY)
        return when (timeOfDay) {
            in 0..11 -> "Good Morning"
            in 12..15 -> "Good Afternoon"
            in 16..20 -> "Good Evening"
            in 21..23 -> "Good Night"
            else -> "Hello"
        }
    }
}