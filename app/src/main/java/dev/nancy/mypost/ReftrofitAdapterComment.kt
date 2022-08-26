package dev.nancy.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import dev.nancy.mypost.databinding.CommentListItemBinding
import dev.nancy.mypost.databinding.PostListItemBinding
class ReftrofitAdapterComment(var context: Context, var commentListItemBinding: List<Comment>):
 RecyclerView.Adapter<CommentViewholder>() {
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewholder {
  var binding =
   CommentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
  return CommentViewholder(binding)
 }

 override fun onBindViewHolder(holder: CommentViewholder, position: Int) {
  var currentComment = commentListItemBinding.get(position)
  with(holder.binding) {
   tvPostid.text = currentComment.postId.toString()
   tvid.text = currentComment.id.toString()
   tvname.text = currentComment.name
   tvbody.text = currentComment.body
   val context = holder.itemView.context
   holder.binding.cvComments.setOnClickListener {
    val intent = Intent(context, CommentActivity::class.java)
    intent.putExtra("POST_ID",currentComment.id)
    context.startActivity(intent)
   }

  }
 }


 override fun getItemCount(): Int {
  return commentListItemBinding.size
 }
}
class CommentViewholder(val binding: CommentListItemBinding): RecyclerView.ViewHolder(binding.root)









