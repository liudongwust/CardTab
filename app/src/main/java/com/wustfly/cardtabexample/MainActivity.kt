package com.wustfly.cardtabexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wustfly.cardtabexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val m = this

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, findViewById(android.R.id.content), false)
        setContentView(binding.root)
        Pager()
    }


    inner class Pager {

        private val adapter = object : FragmentStateAdapter(m) {
            override fun getItemCount(): Int {
                return 2
            }

            override fun createFragment(position: Int): Fragment {
                return if (position == 0) LeftFragment() else RightFragment()
            }

        }

        init {
            binding.pager.adapter = adapter
            binding.tab.bindPager(binding.pager)
        }


    }


}