package com.app.effectivemobiletest.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.effectivemobiletest.R
import com.app.effectivemobiletest.databinding.ActivitySingInBinding

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class SingInActivity : AppCompatActivity() {
    lateinit var binding: ActivitySingInBinding

    var database: DatabaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://registration-db-a9167-default-rtdb.firebaseio.com/")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sing_in)


        stUpUi()
    }

    private fun stUpUi(){

        binding.singInBut.apply {
            setOnClickListener {

                if(binding.firstNameInput.text.isNotEmpty()) {
                    database.apply {
                        child("user").addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.hasChild(binding.emailInput.text.toString())) {
                                    Toast.makeText(
                                        this@SingInActivity,
                                        "has already email",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    this@apply.child("user")
                                        .child(binding.emailInput.text.toString()).child("name")
                                        .setValue(binding.firstNameInput.text.toString())
                                    this@apply.child("user")
                                        .child(binding.emailInput.text.toString()).child("surname")
                                        .setValue(binding.lastNameInput.text.toString())
                                    this@apply.child("user")
                                        .child(binding.emailInput.text.toString()).child("password")
                                        .setValue("1111")
                                    startActivity(Intent(this@SingInActivity,ProfileActivity::class.java))
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                TODO("Not yet implemented")
                            }


                        })
                    }

                }

                binding.logIn.apply {
                    setOnClickListener {
                        startActivity(Intent(this@SingInActivity,LogInActivity::class.java))
                    }
                }

                }

            }
        }

}
