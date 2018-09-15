package com.songshakes.internship.skilllist.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.songshakes.internship.skilllist.R

class RecyclerViewSkillsListHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvSkillName = itemView.findViewById<TextView>(R.id.text_view_item_skill_name)
    val tvSubCatalog = itemView.findViewById<TextView>(R.id.text_view_item_sub_catalog)
    val ivCatalog = itemView.findViewById<ImageView>(R.id.image_view_item_catalog)

}