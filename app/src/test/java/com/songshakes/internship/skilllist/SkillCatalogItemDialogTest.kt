package com.songshakes.internship.skilllist

import com.songshakes.internship.skilllist.fragment.SkillCatalogItemDialogFragment
import junit.framework.Assert.assertEquals
import org.junit.Test

class SkillCatalogItemDialogTest {

    @Test
    fun `create list catalog`(){
        val key = null
        val expected = mutableListOf("Development","Content","Other")

        assertEquals(expected, SkillCatalogItemDialogFragment().createDataSet(key))
    }

    @Test
    fun `create list sub catalog development`(){
        val key = "Development"
        val expected = mutableListOf("Front-end Developer","Back-end Developer","iOS Developer","Android Developer")

        assertEquals(expected, SkillCatalogItemDialogFragment().createDataSet(key))
    }

    @Test
    fun `create list sub catalog Content`(){
        val key = "Content"
        val expected = mutableListOf("Content Editor","Visual Designer","Photographer")

        assertEquals(expected, SkillCatalogItemDialogFragment().createDataSet(key))
    }

    @Test
    fun `create list sub catalog Other`(){
        val key = "Other"
        val expected = mutableListOf("Social Media Officer","Event Designer","Event Coordinator")

        assertEquals(expected, SkillCatalogItemDialogFragment().createDataSet(key))
    }

    @Test
    fun `create list catalog Other`(){
        val key = "Design"
        val expected = ArrayList<String>()

        assertEquals(expected, SkillCatalogItemDialogFragment().createDataSet(key))
    }
}