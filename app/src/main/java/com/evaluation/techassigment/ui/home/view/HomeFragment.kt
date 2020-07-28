package com.evaluation.techassigment.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.evaluation.techassigment.R
import com.evaluation.techassigment.databinding.HomeFragmentLytBinding
import com.evaluation.techassigment.ui.base.BaseFragment

/**
 * Created by Naveen on 28-07-2020.
 */
class HomeFragment : BaseFragment() {
    private var binding: HomeFragmentLytBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment_lyt, container, false)
        return binding?.root
    }
}