package com.jk.mvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jk.mvp.databinding.ActivityMainBinding
import com.jk.mvp.presenter.Presenter
import com.jk.mvp.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    var presenter = Presenter()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnPlus.setOnClickListener {
                presenter.increment()
            }
            btnMinus.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun changeCount(count: Int) {
        binding.tvCounter.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show()
    }

    override fun setColor() {
        binding.tvCounter.setTextColor(Color.GREEN)
    }
}