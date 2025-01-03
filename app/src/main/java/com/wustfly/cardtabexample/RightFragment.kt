package com.wustfly.cardtabexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wustfly.cardtabexample.databinding.FragmentRightBinding

class RightFragment : Fragment() {

    private lateinit var binding: FragmentRightBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRightBinding.inflate(inflater)

        return binding.root
    }
}