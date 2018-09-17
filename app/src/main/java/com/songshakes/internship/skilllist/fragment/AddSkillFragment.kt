package com.songshakes.internship.skilllist.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.songshakes.internship.skilllist.R
import com.songshakes.internship.skilllist.manager.BottomSheetDialogFragmentListener
import com.songshakes.internship.skilllist.model.SkillData
import kotlinx.android.synthetic.main.fragment_add_skill.*


class AddSkillFragment : Fragment(), BottomSheetDialogFragmentListener {
    private val TAG = "AddSkillFragment"

    private lateinit var editTextSkillName: EditText
    private lateinit var editTextSkillCatalog: EditText
    private lateinit var editTextSkillSubCatalog: EditText
    private lateinit var buttonSave: Button

    private var item: MenuItem? = null
    private lateinit var listener: BottomSheetDialogFragmentListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        listener = this
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_add_skill, container, false)
        initInstance(rootView)
        return rootView
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        item = menu?.findItem(R.id.menu_add_skill)
        item?.let {
            it.isVisible = false
        }
    }

    private fun initInstance(rootView: View) {
        editTextSkillName = rootView.findViewById(R.id.edit_text_skill_name)
        editTextSkillCatalog = rootView.findViewById(R.id.edit_text_skill_catalog)
        editTextSkillSubCatalog = rootView.findViewById(R.id.edit_text_skill_sub_catalog)
        buttonSave = rootView.findViewById(R.id.button_save)

        editTextSkillCatalog.setFocusable(false)
        editTextSkillSubCatalog.setFocusable(false)
        editTextSkillCatalog.setText(getString(R.string.label_skill_catalog))
        editTextSkillSubCatalog.setText(getString(R.string.label_skill_sub_catalog))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        editTextSkillCatalog.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (before != count) {
                    editTextSkillSubCatalog.setText(getString(R.string.label_skill_sub_catalog))
                }
            }
        })

        editTextSkillCatalog.setOnClickListener {
            val bottomSheetFragment = SkillCatalogItemDialogFragment.newInstance(listener, null)
            bottomSheetFragment.show(activity?.supportFragmentManager, bottomSheetFragment.tag)
        }

        editTextSkillSubCatalog.setOnClickListener {
            if (catalogSelected(editTextSkillCatalog.text.toString())) {
                val bottomSheetFragment = SkillCatalogItemDialogFragment.newInstance(listener, editTextSkillCatalog.text.toString())
                bottomSheetFragment.show(activity?.supportFragmentManager, bottomSheetFragment.tag)
            } else {
                showToast(getString(R.string.label_toast_slips_select_catalog))
            }
        }

        button_save.setOnClickListener {

            if (editTextNameSkillNotBlank(editTextSkillName.text.toString()) &&
                    subCatalogSelected(editTextSkillSubCatalog.text.toString()) &&
                    catalogSelected(editTextSkillCatalog.text.toString())) {
                val skillDetail = SkillData(editTextSkillName.text.toString(),
                        editTextSkillCatalog.text.toString(),
                        editTextSkillSubCatalog.text.toString())

                val fragment = SkillListsFragment()
                val args = Bundle()
                args.putParcelable("SKILL_DETAIL", skillDetail)
                fragment.arguments = args
                fragmentManager?.apply {
                    popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    beginTransaction().replace(R.id.contentContainer, fragment)
                            .commit()
                }
            } else {
                showToast(getString(R.string.label_toast_slips_fill_all_fields))
            }
        }
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun catalogSelected(value: String) = value != "Select Catalog"

    fun subCatalogSelected(value: String) = value != "Select Sub Catalog"

    fun editTextNameSkillNotBlank(value: String) = value != ""

    override fun selectSkillCatalog(skillCatalog: String) {
        editTextSkillCatalog.setText(skillCatalog)
    }

    override fun selectSkillSubCatalog(skillSubCatalog: String) {
        editTextSkillSubCatalog.setText(skillSubCatalog)
    }

    companion object {
        fun newInstance() = AddSkillFragment().apply {

        }
    }
}

