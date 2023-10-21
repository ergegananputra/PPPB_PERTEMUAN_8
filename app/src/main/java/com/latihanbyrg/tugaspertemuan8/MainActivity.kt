package com.latihanbyrg.tugaspertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.latihanbyrg.tugaspertemuan8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        title = resources.getString(R.string.app_title)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            viewPager2 = viewPager
            viewPager2.adapter = TabAdapter(this@MainActivity)

            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = when(position) {
                    0 -> "Register"
                    1 -> "Login"
                    else -> ""
                }
            }.attach()

            viewPagerCompanion = viewPager2

        }
    }


    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASSWORD = "extra_password"

        var username : String = ""
        var email : String = ""
        var phone : String = ""
        var password : String = ""

        lateinit var viewPagerCompanion : ViewPager2
    }

}