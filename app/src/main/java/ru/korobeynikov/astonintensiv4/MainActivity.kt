package ru.korobeynikov.astonintensiv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.korobeynikov.astonintensiv4.databinding.ActivityMainBinding
import ru.korobeynikov.astonintensiv4.first.FirstActivity
import ru.korobeynikov.astonintensiv4.second.SecondActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.view=this
    }

    fun goToFirstActivity(){
        startActivity(Intent(this,FirstActivity::class.java))
    }

    fun goToSecondActivity(){
        startActivity(Intent(this,SecondActivity::class.java))
    }
}