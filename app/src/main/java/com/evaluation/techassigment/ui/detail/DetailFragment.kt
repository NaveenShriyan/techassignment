package com.evaluation.techassigment.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.evaluation.techassigment.R
import com.evaluation.techassigment.databinding.DetailFragmentBinding
import com.evaluation.techassigment.datamodel.response.Detail
import com.evaluation.techassigment.ui.base.BaseFragment
import com.evaluation.techassigment.ui.callbacks.ITitleCallBack
import com.evaluation.techassigment.utils.DataBindingUtility.setTitle

/**
 * Created by Naveen on 30-07-2020.
 */
class DetailFragment : BaseFragment() {
    private lateinit var binding: DetailFragmentBinding
    val detailArgs:DetailFragmentArgs by navArgs()
    private var listener: ITitleCallBack? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ITitleCallBack
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        binding.detail = detailArgs.detailArg
        setToolBarTitle(detailArgs.detailArg.title)
        return binding.root
    }

    private fun setToolBarTitle(title: String?) {
            listener?.onTittleReceived(title,true)
    }

}