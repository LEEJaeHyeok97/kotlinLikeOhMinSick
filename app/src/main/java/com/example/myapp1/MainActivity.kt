package com.example.myapp1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.add.setOnClickListener {
//            performOperation { a, b -> a + b }
//        }
//
//        binding.sub.setOnClickListener {
//            performOperation { a, b -> a - b }
//        }
//
//        binding.mul.setOnClickListener {
//            performOperation { a, b -> a * b }
//        }
//
//        binding.div.setOnClickListener {
//            performOperation { a, b ->
//                if (b == 0.0) throw ArithmeticException("Cannot divide by zero")
//                a / b
//            }
//        }
//    }
//
//    private fun performOperation(operation: (Double, Double) -> Double) {
//        try {
//            val num1 = binding.num1.text.toString().toDoubleOrNull() ?: throw NumberFormatException("Please enter a valid number for num1")
//            val num2 = binding.num2.text.toString().toDoubleOrNull() ?: throw NumberFormatException("Please enter a valid number for num2")
//            if (num1 > Int.MAX_VALUE || num2 > Int.MAX_VALUE) throw IllegalArgumentException("Input number is too large")
//            val result = operation(num1, num2)
//            binding.result.text = getString(R.string.results, result.toString())
//        } catch (e: ArithmeticException) {
//            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
//        } catch (e: NumberFormatException) {
//            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
//        } catch (e: IllegalArgumentException) {
//            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
//        }
//    }
}
