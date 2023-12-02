package ru.korobeynikov.astonintensiv4.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.korobeynikov.astonintensiv4.R
import ru.korobeynikov.astonintensiv4.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityFirstBinding>(this,R.layout.activity_first)
    }
}