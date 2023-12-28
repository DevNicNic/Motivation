package com.nicnicdev.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.nicnicdev.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()

        }
    }
    private fun handleSave() {
        val name = binding.editWhatIsYourName.text.toString()
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java)) // responsavel por fazer a navegação entre as telas.
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}