package com.latihanbyrg.tugaspertemuan8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.password
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.username
import com.latihanbyrg.tugaspertemuan8.MainActivity.Companion.viewPagerCompanion
import com.latihanbyrg.tugaspertemuan8.databinding.FragmentLoginBinding


private const val USERNAME = "EXTRA_USERNAME"
private const val PASSWORD = "EXTRA_PASSWORD"


class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(USERNAME)
            param2 = it.getString(PASSWORD)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        with(view) {

            val textInputUsername = findViewById<TextInputEditText>(R.id.text_input_username)
            val textInputPassword = findViewById<TextInputEditText>(R.id.text_input_password)
            findViewById<View>(R.id.button_login).setOnClickListener {
                if (textInputUsername.text.toString().isEmpty()) {
                    textInputUsername.error = "Mohon masukkan username"
                    return@setOnClickListener
                }
                if (textInputPassword.text.toString().isEmpty()) {
                    textInputPassword.error = "Mohon masukkan password"
                    return@setOnClickListener
                }

                // validation
                if (textInputUsername.text.toString() != username || textInputPassword.text.toString() != password) {
                    Toast.makeText(context, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
                }
                else {
                    val intentToDasbor = Intent(activity, DasborActivity::class.java)
                    startActivity(intentToDasbor)
                }
            }

            findViewById<TextView>(R.id.link_to_register).setOnClickListener {
                viewPagerCompanion.currentItem = 0
            }

            findViewById<TextView>(R.id.link_to_forget_password).setOnClickListener {
                Toast.makeText(context, "Kok bisa bang? Coba inget lagi", Toast.LENGTH_LONG).show()
            }
        }
        // Inflate the layout for this fragment
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(username: String, password: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(USERNAME, username)
                    putString(PASSWORD, password)
                }
            }
    }
}