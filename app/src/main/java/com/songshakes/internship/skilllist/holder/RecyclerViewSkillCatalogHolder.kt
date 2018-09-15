package com.songshakes.internship.skilllist.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.songshakes.internship.skilllist.R

class RecyclerViewSkillCatalogHolder(view: View) : RecyclerView.ViewHolder(view) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val tvSkillCatalog = itemView.findViewById<TextView>(R.id.text_view_item_skill_catalog_name)!!
}