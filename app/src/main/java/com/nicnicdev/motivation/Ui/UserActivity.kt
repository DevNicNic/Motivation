package com.nicnicdev.motivation.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.nicnicdev.motivation.Ui.Infra.MotivationConstants
import com.nicnicdev.motivation.R
import com.nicnicdev.motivation.Ui.Infra.SecurityPreferences
import com.nicnicdev.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                ))
            finish()
        }
    }

    private fun handleSave() {
        val name = binding.editWhatIsYourName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name) // responsavel por salvar o nome do usuário

            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            ) // responsavel por fazer a navegação entre as telas.
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}