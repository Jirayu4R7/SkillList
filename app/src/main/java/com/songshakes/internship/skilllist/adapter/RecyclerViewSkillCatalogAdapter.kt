package com.songshakes.internship.skilllist.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.songshakes.internship.skilllist.R
import com.songshakes.internship.skilllist.holder.RecyclerViewSkillCatalogHolder

class RecyclerViewSkillCatalogAdapter(val context: Context,
                                      val itemList: ArrayList<String>,
                                      val itemClickListener: RecyclerViewSkillCatalogHolder.ItemClickListener) : RecyclerView.Adapter<RecyclerViewSkillCatalogHolder>() {

    var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewSkillCatalogHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.layout_item_skill_catalog, parent, false)

        mView.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickListener.onItemClick(view,
                        it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewSkillCatalogHolder(mView)
    }

    override fun getItemCount(): Int {
        Log.d("SkillList", "size catalog " + itemList.size.toString())
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewSkillCatalogHolder, position: Int) {
        holder.let {
            it.tvSkillCatalog.text = itemList[position]
        }
    }

}