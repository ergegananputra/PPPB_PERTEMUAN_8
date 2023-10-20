package com.latihanbyrg.latihanpertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.latihanbyrg.latihanpertemuan8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerVal:ViewPager2

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Latihan"


        // untuk hide action bar
        supportActionBar?.hide()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewPager.adapter = TabAdapter(this@MainActivity)
            viewPagerVal = viewPager

            TabLayoutMediator(tabLayout, viewPager) {
                tab, position ->
                tab.text = when(position) {
                    0 -> "Home"
                    1 -> "Material"
                    2 -> "Quiz"
                    else -> ""
                }
            }.attach()


        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                viewPagerVal.currentItem = 0
                true
            }
            R.id.action_material -> {
                Toast.makeText(this, "Material", Toast.LENGTH_SHORT).show()
                viewPagerVal.currentItem = 1
                true
            }
            R.id.action_quiz -> {
                Toast.makeText(this, "Quiz", Toast.LENGTH_SHORT).show()
                viewPagerVal.currentItem = 2
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }


}