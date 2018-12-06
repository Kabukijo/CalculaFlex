package com.example.logonrmlocal.calculafiles

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.logonrmlocal.calculafiles.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btCreate.setOnClickListener {
            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(inputEmail.text.toString(), inputPassword.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            saveInDatabase()
                        } else {
                            Toast.makeText(this@SignUpActivity, it.exception?.message, Toast.LENGTH_SHORT)
                                    .show()
                        }
                    }
        }
    }

    private fun saveInDatabase() {

        val user = User(inputName.text.toString(), inputEmail.text.toString(), inputPhone.text.toString())
        FirebaseDatabase.getInstance()
                .getReference("Users")
                .child(FirebaseAuth.getInstance().currentUser!!.uid)
                .setValue(user)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this@SignUpActivity, "Usuario criado com sucesso!!!", Toast.LENGTH_SHORT)
                                .show()
                        val intent = Intent()
                        intent.putExtra("email", inputEmail.text.toString())
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    } else {
                        Toast.makeText(this@SignUpActivity, it.exception?.message, Toast.LENGTH_SHORT)
                                .show()
                    }
                }
    }
}
