package com.example.calculator2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    var all_value_box : String = ""
    var current_value : String = ""
    val regex1 = "-?\\d+(?:[\\.,]\\d+)?".toRegex()
    val regex2 = "\\b[\\+\\-\\*\\/]\\b".toRegex()

    fun btn_one(view: View){

        current_value += 1
        all_value_box += 1
        binding.textViewResult.text = all_value_box
    }
    fun btn_two(view: View){
        current_value += 2
        all_value_box += 2
        binding.textViewResult.text = all_value_box
    }
    fun btn_three(view: View){
        current_value += 3
        all_value_box += 3
        binding.textViewResult.text = all_value_box
    }
    fun btn_four(view: View){
        current_value += 4
        all_value_box += 4
        binding.textViewResult.text = all_value_box
    }
    fun btn_five(view: View){
        current_value += 5
        all_value_box += 5
        binding.textViewResult.text = all_value_box
    }
    fun btn_six(view: View){
        current_value += 6
        all_value_box += 6
        binding.textViewResult.text = all_value_box
    }
    fun btn_seven(view: View){
        current_value += 7
        all_value_box += 7
        binding.textViewResult.text = all_value_box
    }
    fun btn_eight(view: View){
        current_value += 8
        all_value_box += 8
        binding.textViewResult.text = all_value_box
    }
    fun btn_nine(view: View){
        current_value += 9
        all_value_box += 9
        binding.textViewResult.text = all_value_box
    }
    fun btn_zero(view: View){
        current_value += 0
        all_value_box += 0
        binding.textViewResult.text = all_value_box
    }
    fun btn_dot(view: View){
        if (!current_value.contains(".") && current_value != "") {
            current_value += "."
            all_value_box += "."
            binding.textViewResult.text = all_value_box
        }
    }
    fun btn_plus(view: View){
        var temp = regex2.find(all_value_box)?.value.toString()
        if (current_value.toDoubleOrNull() is Double && !temp.contains("*") && !temp.contains("/") && !temp.contains("-") && !temp.contains("+")) {
            current_value = ""
            all_value_box += "+"
            binding.textViewResult.text = all_value_box
        }
        else if (regex2.find(all_value_box)?.value.toString().count() == 1 ){
            btn_calculate(view)
            all_value_box += "+"
            current_value += "+"
            binding.textViewResult.text = all_value_box
        }
        else {

        }
    }
    fun btn_minus(view: View){
        var temp = regex2.find(all_value_box)?.value.toString()
        if (current_value.toDoubleOrNull() is Double && !temp.contains("*") && !temp.contains("/") && !temp.contains("-") && !temp.contains("+")) {
            current_value = ""
            all_value_box += "-"
            binding.textViewResult.text = all_value_box
        }
        else if (current_value == "" && all_value_box == "") {
            current_value = "-"
            all_value_box += "-"
            binding.textViewResult.text = all_value_box
        }
        else if (regex2.find(all_value_box)?.value.toString().count() == 1 ){
            btn_calculate(view)
            all_value_box += "-"
            current_value += "-"
            binding.textViewResult.text = all_value_box
        }
        else {

        }
    }
    fun btn_del(view: View){
        var temp = regex2.find(all_value_box)?.value.toString()
        if (current_value.toDoubleOrNull() is Double && !temp.contains("*") && !temp.contains("/") && !temp.contains("-") && !temp.contains("+")) {
            current_value = ""
            all_value_box += "/"
            binding.textViewResult.text = all_value_box
        }
        else if (regex2.find(all_value_box)?.value.toString().count() == 1 ){
            btn_calculate(view)
            all_value_box += "/"
            current_value += "/"
            binding.textViewResult.text = all_value_box
        }

        else {

        }
    }
    fun btn_ymnoj(view: View){
        var temp = regex2.find(all_value_box)?.value.toString()
        if (current_value.toDoubleOrNull() is Double && !temp.contains("*") && !temp.contains("/") && !temp.contains("-") && !temp.contains("+") ) {
            current_value = ""
            all_value_box += "*"
            binding.textViewResult.text = all_value_box
        }
        else if (regex2.find(all_value_box)?.value.toString().count() == 1 ){
            btn_calculate(view)
            all_value_box += "*"
            current_value += "*"
            binding.textViewResult.text = all_value_box
        }
        else {

        }
    }
    fun btn_CE(view: View){

            current_value = ""
            all_value_box = ""
            binding.textViewResult.text = all_value_box

    }
    fun btn_calculate(view: View){
        var primer = regex1.findAll(all_value_box).map{it.value}.toMutableList()
        var znak = (regex2.find(all_value_box) )

//        println(primer[0].toDouble())
//        println(primer[1].toDouble())
//        println(znak?.value)
        if (primer.count() == 2 && znak?.value != null){
            when (znak.value){
                "+" -> all_value_box = (primer[0].toDouble() + primer[1].toDouble()).toString()
                "-" -> all_value_box = (primer[0].toDouble() + primer[1].toDouble()).toString()
                "*" -> all_value_box = (primer[0].toDouble() * primer[1].toDouble()).toString()
                "/" -> all_value_box = (primer[0].toDouble() / primer[1].toDouble()).toString()
                else -> "err"
            }
            current_value = all_value_box
            binding.textViewResult.text = all_value_box
        }
        else{
            // всплывалка о ошибке
        }
    }
}