package com.inter.evaluation.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.inter.evaluation.AlbunsActivity
import com.inter.evaluation.R
import com.inter.evaluation.data.User
import com.inter.evaluation.databinding.ListItemUserBinding
import com.inter.evaluation.ui.main.MainFragment
import com.inter.evaluation.ui.main.MainViewModel
import okhttp3.internal.userAgent

class UserAdapter : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ListItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(
        private val binding: ListItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: User) {
            binding.apply {
                user = item
                btnAlbuns.setOnClickListener{
                    navigateToAlbuns(item, it)
                }
                executePendingBindings()
            }
        }

        private fun navigateToAlbuns(user:User,view: View){

            val intent = Intent(view.context, AlbunsActivity::class.java)
            intent.putExtra("usuarioId", user.id)
            intent.putExtra("usuarioNome", user.username)
            view.context.startActivity(intent)
        }

        private fun navigateToPost(userId:String,view: View){

        }
    }
}

private class UserDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}