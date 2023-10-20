package com.latihanbyrg.tugaspertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.latihanbyrg.tugaspertemuan8.databinding.ActivityDasborBinding

class DasborActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDasborBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDasborBinding.inflate(layoutInflater)

        title = resources.getString(R.string.app_title)


        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when {
            item.itemId == R.id.log_out_button -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}