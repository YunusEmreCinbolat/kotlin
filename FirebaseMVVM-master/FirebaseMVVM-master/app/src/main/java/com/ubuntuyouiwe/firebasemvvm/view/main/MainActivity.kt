package com.ubuntuyouiwe.firebasemvvm.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.ubuntuyouiwe.firebasemvvm.R
import com.ubuntuyouiwe.firebasemvvm.databinding.ActivityMainBinding
import com.ubuntuyouiwe.firebasemvvm.view.child_category.ChildCategoryFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment



    }
}

