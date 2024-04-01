package com.example.myapp1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp1.databinding.ActivityMainBinding
import com.example.myapp1.databinding.View2Binding

class View2Activity: AppCompatActivity() {

    lateinit var binding: View2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = View2Binding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.buttonRed.setOnClickListener {
            showColorView(binding.redview)
        }

        binding.buttonBlue.setOnClickListener {
            showColorView(binding.blueview)
        }

        binding.buttonGreen.setOnClickListener {
            showColorView(binding.greenview)
        }
    }

    private fun showColorView(viewToShow: View) {
        // Hide all color views first
        binding.redview.visibility = View.GONE
        binding.greenview.visibility = View.GONE
        binding.blueview.visibility = View.GONE

        viewToShow.visibility = View.VISIBLE
    }



}
