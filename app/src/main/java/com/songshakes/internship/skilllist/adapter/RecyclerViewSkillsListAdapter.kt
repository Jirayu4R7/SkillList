package com.songshakes.internship.skilllist.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.songshakes.internship.skilllist.R
import com.songshakes.internship.skilllist.holder.RecyclerViewSkillsListHolder
import com.songshakes.internship.skilllist.model.SkillCatalogs
import com.songshakes.internship.skilllist.model.SkillData

class RecyclerViewSkillsListAdapter(val context: Context, val itemList: ArrayList<SkillData>) : RecyclerView.Adapter<RecyclerViewSkillsListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewSkillsListHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.layout_item_skill, parent, false)
        return RecyclerViewSkillsListHolder(mView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewSkillsListHolder, position: Int) {
        holder.let {
            it.tvSkillName.text = itemList[position].skillName
            it.tvSubCatalog.text = itemList[position].skillSubCatalog

            when (itemList[position].skillCatalog) {
                SkillCatalogs.SKILLCATALOGS[0] -> {
                    it.ivCatalog.setImageResource(R.drawable.ic_catalog_1)
                }
                SkillCatalogs.SKILLCATALOGS[1] -> {
                    it.ivCatalog.setImageResource(R.drawable.ic_catalog_2)
                }
                SkillCatalogs.SKILLCATALOGS[2] -> {
                    it.ivCatalog.setImageResource(R.drawable.ic_catalog_3)
                }
                else -> {
                    it.ivCatalog.visibility = View.INVISIBLE
                }
            }
        }
    }

}