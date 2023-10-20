package com.latihanbyrg.tugaspertemuan8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.email
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.password
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.phone
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.username
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.viewPagerCompanion


class RegisterFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        with(view) {

            val textInputUsername = findViewById<TextInputEditText>(R.id.text_input_username)
            val textInputEmail = findViewById<TextInputEditText>(R.id.text_input_email)
            val textInputPhone = findViewById<TextInputEditText>(R.id.text_input_phone)
            val textInputPassword = findViewById<TextInputEditText>(R.id.text_input_password)
            val checkBox = findViewById<AppCompatCheckBox>(R.id.appCompatCheckBox2)
            findViewById<View>(R.id.button_register).setOnClickListener {
                if (textInputUsername.text.toString().isEmpty()) {
                    textInputUsername.error = "Mohon masukkan username"
                    return@setOnClickListener
                }
                if (textInputEmail.text.toString().isEmpty()) {
                    textInputEmail.error = "Mohon masukkan email"
                    return@setOnClickListener
                }
                if (textInputPhone.text.toString().isEmpty()) {
                    textInputPhone.error = "Mohon masukkan email"
                    return@setOnClickListener
                }
                if (textInputPassword.text.toString().isEmpty()) {
                    textInputPassword.error = "Mohon masukkan email"
                    return@setOnClickListener
                }
                if (!checkBox.isChecked) {
                    Toast.makeText(context, "Anda tidak menyetujui Term and Condition", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }


                username = textInputUsername.text.toString()
                email = textInputEmail.text.toString()
                phone = textInputPhone.text.toString()
                password = textInputPassword.text.toString()


                textInputUsername.text?.clear()
                textInputEmail.text?.clear()
                textInputPhone.text?.clear()
                textInputPassword.text?.clear()
                checkBox.isChecked = false


                viewPagerCompanion.currentItem = 1

            }

            findViewById<View>(R.id.link_to_login).setOnClickListener {
                viewPagerCompanion.currentItem = 1
            }

        }
        
        return view
    }

}