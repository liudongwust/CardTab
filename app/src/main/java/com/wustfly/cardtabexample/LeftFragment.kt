package com.wustfly.cardtabexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wustfly.cardtabexample.databinding.FragmentLeftBinding

class LeftFragment : Fragment() {

    private lateinit var binding: FragmentLeftBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLeftBinding.inflate(inflater)

        return binding.root
    }
}