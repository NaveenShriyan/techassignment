package com.evaluation.techassigment.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.evaluation.techassigment.R
import com.evaluation.techassigment.application.Constants
import com.evaluation.techassigment.databinding.ItemLytBinding
import com.evaluation.techassigment.datamodel.response.Detail
import com.evaluation.techassigment.ui.home.view.HomeFragmentDirections
import com.evaluation.techassigment.utils.Logger
import kotlinx.android.synthetic.main.item_lyt.view.*

/**
 * Created by Naveen on 29-07-2020.
 */
class HomeAdapter(private val detailList: ArrayList<Detail>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(var binding: ItemLytBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detail: Detail) {
            binding.item = detail
            binding.root.setOnClickListener {
                val direction = HomeFragmentDirections.actionHome(detail)
                it.findNavController().navigate(direction)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var binding: ItemLytBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_lyt, parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int = detailList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(detailList[position])
    }

    fun addData(details: List<Detail>) {
        Logger.d("LAZY", "Size of List first ${detailList.size}")
        detailList.addAll(details)
        Logger.d("LAZY", "Size of List after add ${detailList.size}")
    }
}