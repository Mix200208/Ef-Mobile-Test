package com.app.effectivemobiletest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.app.effectivemobiletest.R
import com.app.effectivemobiletest.databinding.ActivityLogInBinding
import com.app.effectivemobiletest.databinding.ActivityMainBinding
import com.google.firebase.database.*

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    var databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://registration-db-a9167-default-rtdb.firebaseio.com/")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_log_in)

        stUpUi()

    }

    fun stUpUi(){
        binding.button.apply {
            setOnClickListener {
                databaseReference.apply {
                    child("user").addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.hasChild(binding.emailInput.text.toString())) {

                                var password = snapshot.child(binding.emailInput.text.toString()).child("password").getValue(String::class.java)
                                if (password!! == binding.passwordInput.text.toString()){
                                    startActivity(Intent(this@LogInActivity,ProfileActivity::class.java))

                                }else{
                                    Toast.makeText(this@LogInActivity,"invalid password ",Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                Toast.makeText(this@LogInActivity,"invalid login ",Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }


                    })
                }
            }
        }


    }
}