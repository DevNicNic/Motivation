package com.nicnicdev.motivation.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nicnicdev.motivation.Ui.Infra.MotivationConstants
import com.nicnicdev.motivation.R
import com.nicnicdev.motivation.Ui.Infra.SecurityPreferences
import com.nicnicdev.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()

        binding.buttonNewSentece.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_sentece) {
            var s = ""
        }
    }
    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Ola, $name!"

    }
}