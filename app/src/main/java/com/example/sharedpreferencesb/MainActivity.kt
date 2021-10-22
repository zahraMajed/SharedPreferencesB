package com.example.sharedpreferencesb

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var text1:TextView
    lateinit var text2:TextView
    lateinit var btnShare:Button
    lateinit var btnSave:Button

    /*
        Shared Preferences allow us to save data to the user's device.
        We can then load the data when we launch our application.
         */

    //step 1: declare our Shared Preferences variable.
    private lateinit var SharedPreferencesVariable: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1=findViewById(R.id.etOne)
        text2=findViewById(R.id.edTwo)
        btnSave=findViewById(R.id.btnSave)
        btnShare=findViewById(R.id.btnShareData)

        btnShare.setOnClickListener(){
            if (text1.text.isNotEmpty() && text2.text.isNotEmpty()){
                val msg=" Data from intent: \n ${text1.text} \n ${text2.text}"
                intent= Intent(this,MainActivity2::class.java)
                intent.putExtra("data", msg)
                startActivity(intent)
            }

        }//end listener

        btnSave.setOnClickListener(){
            if (text1.text.isNotEmpty() && text2.text.isNotEmpty()) {
                val msg=" Data from SHPS: \n ${text1.text} \n ${text2.text}"
                //step 3: initialize Shared Preferences, then save or get data
               SharedPreferencesVariable= this.getSharedPreferences(getString(
                    R.string.preference_file_key), Context.MODE_PRIVATE)

                //after step 1, 2 ,3 only we can load (get) and/or save data.
                //to save data to sharedPreferences:
                with(SharedPreferencesVariable.edit()) {
                    putString("myData", msg)
                    apply()
                }
            }
        }//end listener

    }//end onCreate()

}//end class