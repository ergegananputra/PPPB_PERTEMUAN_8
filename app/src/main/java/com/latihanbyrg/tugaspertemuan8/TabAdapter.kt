package com.latihanbyrg.tugaspertemuan8

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
    private val page = mapOf<String, Fragment>(
        "register" to RegisterFragment(),
        "login" to LoginFragment()
    )

    override fun getItemCount(): Int = page.size

    override fun createFragment(position: Int): Fragment {
        return page.values.elementAt(position)
    }
}