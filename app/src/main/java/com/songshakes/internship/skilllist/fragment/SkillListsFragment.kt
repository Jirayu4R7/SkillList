package com.songshakes.internship.skilllist.fragment

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.songshakes.internship.skilllist.R
import com.songshakes.internship.skilllist.adapter.RecyclerViewSkillsListAdapter
import com.songshakes.internship.skilllist.model.SkillData


class SkillListsFragment : Fragment() {
    lateinit var mLayoutManager: LinearLayoutManager
    var skills = ArrayList<SkillData>()
    var skill: SkillData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            skill = it.getParcelable("SKILL_DETAIL")
            Log.d("SkillList", "SkillName : ${skill?.skillName} Catalog : ${skill?.skillCatalog} Sub : ${skill?.skillSubCatalog}")
        }

        loadData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_skill_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mLayoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        val rv = view.findViewById<RecyclerView>(R.id.recycler_view_skills)
        rv.layoutManager = mLayoutManager

        val adapter = RecyclerViewSkillsListAdapter(
                context!!, skills
        )

        if (skill != null) {
            skills.add(0, skill!!)
        }

        adapter.notifyItemInserted(0)

        rv.adapter = adapter

    }

    override fun onStop() {
        super.onStop()
        saveData()
    }

    private fun saveData() {
        val sharedPreferences = context!!.getSharedPreferences("shared preference skill list", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(skills)
        editor.putString("skill_list", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = context!!.getSharedPreferences("shared preference skill list", MODE_PRIVATE)
        val json = sharedPreferences.getString("skill_list", null)
        val gson = Gson()
        val type = object : TypeToken<ArrayList<SkillData>>() {
        }.type
        if (json != null) {
            skills = gson.fromJson(json, type)
        }
    }

    companion object {
        fun newInstance(skillDetail: SkillData?) = SkillListsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("SKILL_DETAIL", skillDetail)
            }
        }
    }
}
