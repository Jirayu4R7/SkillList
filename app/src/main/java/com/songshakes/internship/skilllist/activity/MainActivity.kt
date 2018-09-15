package com.songshakes.internship.skilllist.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.songshakes.internship.skilllist.R
import com.songshakes.internship.skilllist.fragment.AddSkillFragment
import com.songshakes.internship.skilllist.fragment.SkillListsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var menuAddSkill: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            supportFragmentManager.apply {
                beginTransaction().add(R.id.contentContainer, SkillListsFragment.newInstance(null))
                        .commit()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        menuAddSkill = menu?.findItem(R.id.menu_add_skill)!!
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add_skill -> {
                checkFragment()
                return true
            }
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.apply {
            beginTransaction().replace(R.id.contentContainer, fragment)
                    .addToBackStack(null)
                    .commit()
        }
    }

    private fun checkFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.contentContainer)
        if (fragment is AddSkillFragment == false) {
            replaceFragment(AddSkillFragment.newInstance())
//            menuAddSkill.isVisible = false
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)
//            supportActionBar?.setHomeButtonEnabled(true)
        }
//        if (fragment is SkillListsFragment == false) {
//            menuAddSkill.isVisible = true
//            supportActionBar?.setDisplayHomeAsUpEnabled(false)
//        }
    }
}
