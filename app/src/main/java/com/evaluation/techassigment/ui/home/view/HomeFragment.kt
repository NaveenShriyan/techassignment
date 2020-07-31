package com.evaluation.techassigment.ui.home.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.evaluation.techassigment.R
import com.evaluation.techassigment.application.Constants
import com.evaluation.techassigment.databinding.HomeFragmentLytBinding
import com.evaluation.techassigment.datamodel.response.Detail
import com.evaluation.techassigment.networking.helper.Status
import com.evaluation.techassigment.ui.adapters.HomeAdapter
import com.evaluation.techassigment.ui.base.BaseFragment
import com.evaluation.techassigment.ui.callbacks.ITitleCallBack
import com.evaluation.techassigment.ui.home.viewmodel.HomeViewModel
import com.evaluation.techassigment.utils.Logger
import kotlinx.android.synthetic.main.home_fragment_lyt.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Naveen on 28-07-2020.
 *
 * Home Fragment which will be responsible to show list of items dynamically
 */
class HomeFragment : BaseFragment() {
    private val visibleThreshold: Int = 4
    private var loading: Boolean = false
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0
    private lateinit var adapter: HomeAdapter
    private val homeViewModel: HomeViewModel by viewModel()
    private var binding: HomeFragmentLytBinding? = null
    private var listener: ITitleCallBack? = null
    private lateinit var recycler: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ITitleCallBack
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment_lyt, container, false)
        setupUI()
        setScrollListener()
        setUpObserver()
        return binding?.root
    }

    /**
     * method used to detect the end of the list and implement lazy loading in the recyclerview
     */
    private fun setScrollListener() {
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    totalItemCount = linearLayoutManager.itemCount
                    lastVisibleItem = linearLayoutManager
                        .findLastVisibleItemPosition()
                    if (!loading
                        && totalItemCount <= (lastVisibleItem + visibleThreshold)
                    ) {
                        //End of the items
                        bottom_progress.visibility = View.VISIBLE
                        homeViewModel.fetchDetails(true)
                        loading = true
                    }
                }
            }
        })
    }

    /**
     * method used to setup the observer and make api call
     */
    private fun setUpObserver() {
        homeViewModel.countryDetail.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Logger.d(Constants.LOGGER_NAME,"Response Recieved")
                    progressBar.visibility = View.GONE
                    bottom_progress.visibility = View.GONE
                    loading = false
                    listener?.onTittleReceived(it.data?.title,false)
                    it.data?.detailList?.let { detailsList ->
                        renderList(detailsList)
                    }
                    recycler.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recycler.visibility = View.GONE
                }
                Status.ERROR -> {
                    Logger.e(Constants.LOGGER_NAME,"Error")
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    /**
     * method used to initialize the UI components
     */
    private fun setupUI() {
        recycler = binding?.recycler as RecyclerView
        linearLayoutManager = LinearLayoutManager(activity)
        recycler.layoutManager = linearLayoutManager
        adapter = HomeAdapter(arrayListOf())
        recycler.adapter = adapter
    }

    /**
     * method used to pass the recieved list to adapter to create list of items
     */
    private fun renderList(detailList: List<Detail>) {
        adapter.addData(detailList)
        adapter.notifyDataSetChanged()
    }
}