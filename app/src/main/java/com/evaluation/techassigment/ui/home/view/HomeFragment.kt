package com.evaluation.techassigment.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.evaluation.techassigment.R
import com.evaluation.techassigment.databinding.HomeFragmentLytBinding
import com.evaluation.techassigment.datamodel.response.Detail
import com.evaluation.techassigment.networking.helper.Status
import com.evaluation.techassigment.ui.base.BaseFragment
import com.evaluation.techassigment.ui.home.viewmodel.HomeViewModel
import com.evaluation.techassigment.utils.Logger
import kotlinx.android.synthetic.main.home_fragment_lyt.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Naveen on 28-07-2020.
 */
class HomeFragment : BaseFragment() {
    private val TAG:String = HomeFragment::class.java.name;
    private val homeViewModel : HomeViewModel by viewModel()
    private var binding: HomeFragmentLytBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment_lyt, container, false)
        setUpObserver()
        return binding?.root
    }

    private fun setUpObserver() {
        homeViewModel.countryDetail.observe(viewLifecycleOwner, Observer { it ->
            when (it.status) {
                Status.SUCCESS -> {
                   /* progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE*/
                    
                    progressBar.visibility = View.GONE
                    it.data?.let {
                       var detailList: List<Detail> = it.detailList
                        Logger.d(TAG,"The Size of list is ${detailList?.size}")
                    }
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}