package com.example.farmus_application.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.farmus_application.R
import com.example.farmus_application.databinding.FragmentFavoriteBinding
import com.example.farmus_application.ui.home.Adapter.FarmRVAdapter
import com.example.farmus_application.ui.home.RVFarmDataModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : Fragment() {

    private lateinit var binding : FragmentFavoriteBinding

    private lateinit var adapter : FarmRVAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)

        //툴바 설정
        binding.toolBar.toolbarMainTitleText.text = "좋아요"
        binding.toolBar.toolbarMainTitleText.setTextColor(resources.getColor(R.color.text_2))

        val farmItems = mutableListOf<RVFarmDataModel>()
        adapter = FarmRVAdapter()
        binding.rvFarm.adapter = adapter
        adapter.submitList(farmItems)
        binding.rvFarm.layoutManager = GridLayoutManager(requireActivity(), 2)
        farmItems.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))
        farmItems.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))
        farmItems.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))
        farmItems.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}