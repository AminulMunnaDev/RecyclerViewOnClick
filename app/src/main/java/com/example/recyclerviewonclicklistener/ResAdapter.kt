package com.example.recyclerviewonclicklistener

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResAdapter(private var itemList: List<ResModel>, mainActivity: MainActivity) :
    RecyclerView.Adapter<ResAdapter.ResViewHolder>() {


    private var mOnClickListener: OnClickListener? = null

    class ResViewHolder(resView: View) : RecyclerView.ViewHolder(resView) {
        fun anim(view: View) {
            val animation = AlphaAnimation(0.0f, 1.0f)
            animation.duration = 1000
            view.startAnimation(animation)
        }

        val profileImage: ImageView = resView.findViewById(R.id.item_image)
        val resName: TextView = resView.findViewById(R.id.restaurant_name)
        val resAddress: TextView = resView.findViewById(R.id.restaurant_address)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResViewHolder {
        val resView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ResViewHolder(resView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ResViewHolder, position: Int) {

        //animationApplied
        holder.anim(holder.itemView)
        //way 1
        holder.profileImage.setImageResource(itemList[position].resImage)
        //way 2
        val currentItem = itemList[position]
        holder.resName.text = currentItem.resName
        holder.resAddress.text = currentItem.resAddress

        //Click Listener
        holder.itemView.setOnClickListener {
            if (mOnClickListener != null) {
                mOnClickListener!!.onClick(position, currentItem)
            }
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: ResModel)
    }

    fun anim(view: View) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1000
        view.startAnimation(animation)
    }
}



