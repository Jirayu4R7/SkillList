package com.songshakes.internship.skilllist

import com.songshakes.internship.skilllist.fragment.AddSkillFragment
import junit.framework.Assert.assertEquals
import org.junit.Test

class AddSkillFragmentUnitTest {
    @Test
    fun `edit text name skill blank`() {
        val skillName = ""
        val expected = false
        assertEquals(expected, AddSkillFragment.newInstance().editTextNameSkillNotBlank(skillName))
    }

    @Test
    fun `edit text name skill not blank`() {
        val skillName = "Develop Application"
        val expected = true
        assertEquals(expected, AddSkillFragment.newInstance().editTextNameSkillNotBlank(skillName))
    }

    @Test
    fun `catalog not selected`() {
        val catalog = "Select Catalog"
        val expected = false
        assertEquals(expected, AddSkillFragment.newInstance().catalogSelected(catalog))
    }

    @Test
    fun `catalog was selected`() {
        val catalog = "Development"
        val expected = true
        assertEquals(expected, AddSkillFragment.newInstance().catalogSelected(catalog))
    }

    @Test
    fun `catalog not sub selected`() {
        val catalog = "Select Sub Catalog"
        val expected = false
        assertEquals(expected, AddSkillFragment.newInstance().subCatalogSelected(catalog))
    }

    @Test
    fun `catalog was sub selected`() {
        val catalog = "Back-end Developer"
        val expected = true
        assertEquals(expected, AddSkillFragment.newInstance().subCatalogSelected(catalog))
    }

}