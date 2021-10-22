package com.example.sharedpreferencesb

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var tvData:TextView
    lateinit var btnGet:Button

    private lateinit var SharedPreferencesVariable: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvData=findViewById(R.id.tvData)
        btnGet=findViewById(R.id.btnGet)

        getInetntData()

        btnGet.setOnClickListener(){
            getSHPSdata()
        }
    }//endonCreate()

    fun getInetntData(){
        tvData.text=intent.getStringExtra("data")
    }//end getInetntData()

    fun getSHPSdata(){
        //step 3: initialize Shared Preferences, then save or get data
        SharedPreferencesVariable= this.getSharedPreferences(getString(
            R.string.preference_file_key), Context.MODE_PRIVATE)
        //after step 1, 2 ,3 only we can load (get) and/or save data.
        //to retrieves data from Shared Preferences:
        tvData.text= SharedPreferencesVariable.getString("myData","").toString()
    }//end getSHPSdata()

}//end class