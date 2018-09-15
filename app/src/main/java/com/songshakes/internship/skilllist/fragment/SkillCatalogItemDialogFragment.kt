package com.songshakes.internship.skilllist.fragment

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.songshakes.internship.skilllist.R
import com.songshakes.internship.skilllist.adapter.RecyclerViewSkillCatalogAdapter
import com.songshakes.internship.skilllist.holder.RecyclerViewSkillCatalogHolder
import com.songshakes.internship.skilllist.manager.BottomSheetDialogFragmentListener
import com.songshakes.internship.skilllist.model.SkillCatalogs


class SkillCatalogItemDialogFragment : BottomSheetDialogFragment(),
        RecyclerViewSkillCatalogHolder.ItemClickListener {

    private var mListener: BottomSheetDialogFragmentListener? = null
    private var mSkillCatalog: String? = null
    private var listSkillCatalog = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listSkillCatalog = createDataSet(mSkillCatalog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_skill_catalog_item_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val mLayoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        val rv = view.findViewById<RecyclerView>(R.id.recycler_view_skill_catalog)
        rv.layoutManager = mLayoutManager

        val adapter = RecyclerViewSkillCatalogAdapter(
                context!!, listSkillCatalog
                , this
        )
        rv.adapter = adapter
    }


    override fun onItemClick(view: View, position: Int) {
        when (mSkillCatalog) {
            null -> {
                mListener?.selectSkillCatalog(SkillCatalogs.SKILLCATALOGS[position])
            }
            SkillCatalogs.SKILLCATALOGS[0] -> {
                for (value in SkillCatalogs.DEVELOPMENT) {
                    mListener?.selectSkillSubCatalog(SkillCatalogs.DEVELOPMENT[position])
                }
            }
            SkillCatalogs.SKILLCATALOGS[1] -> {
                for (value in SkillCatalogs.CONTENT) {
                    mListener?.selectSkillSubCatalog(SkillCatalogs.CONTENT[position])
                }
            }
            SkillCatalogs.SKILLCATALOGS[2] -> {
                for (value in SkillCatalogs.OTHER) {
                    mListener?.selectSkillSubCatalog(SkillCatalogs.OTHER[position])
                }
            }
        }
        dismiss()
    }

    fun createDataSet(stringCatalog: String?): ArrayList<String> {

        var mListSkillCatalog = ArrayList<String>()

        when (stringCatalog) {
            null -> {
                for (value in SkillCatalogs.SKILLCATALOGS) {
                    mListSkillCatalog.add((value))
                }
                return mListSkillCatalog
            }
            SkillCatalogs.SKILLCATALOGS[0] -> {
                for (value in SkillCatalogs.DEVELOPMENT) {
                    mListSkillCatalog.add((value))
                }
                return mListSkillCatalog
            }
            SkillCatalogs.SKILLCATALOGS[1] -> {
                for (value in SkillCatalogs.CONTENT) {
                    mListSkillCatalog.add((value))
                }
                return mListSkillCatalog
            }
            SkillCatalogs.SKILLCATALOGS[2] -> {
                for (value in SkillCatalogs.OTHER) {
                    mListSkillCatalog.add((value))
                }
                return mListSkillCatalog
            }
            else -> {
                return mListSkillCatalog
            }
        }
    }


    companion object {
        fun newInstance(listener: BottomSheetDialogFragmentListener?, skillCatalog: String?) = SkillCatalogItemDialogFragment().apply {
            mListener = listener
            mSkillCatalog = skillCatalog
        }
    }
}