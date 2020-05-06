package com.example.mvvmcomponentdemo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmcomponentdemo.databinding.ActivityGardenBinding

class GardenActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityGardenBinding>(this,R.layout.activity_garden)
    }
}