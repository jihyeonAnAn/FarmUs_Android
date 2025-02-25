package com.example.farmus_application.ui.home

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.farmus_application.R
import com.example.farmus_application.databinding.FragmentFarmusRecFarmBinding
import com.example.farmus_application.ui.MainActivity
import com.example.farmus_application.ui.home.Adapter.FarmRVAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FarmusRecFarmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FarmusRecFarmFragment : Fragment() {

    private lateinit var binding: FragmentFarmusRecFarmBinding

    private lateinit var adapter: FarmRVAdapter

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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_farmus_rec_farm, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideBottomNavigation(true)

        //툴바 설정
        binding.toolBar.toolbarMainTitleText.text = "파머스 추천 농장"
        binding.toolBar.toolbarMainTitleText.setTextColor(resources.getColor(R.color.text_2))

        //툴바 백버튼 누르면 홈
        binding.toolBar.toolbarWithTitleBackButton.setOnClickListener {
            (activity as MainActivity).changeFragment(HomeFragment.newInstance("",""))
        }

        val dp = 16
        val px = dpToPx(requireContext(), dp.toFloat())

        adapter = FarmRVAdapter()
        val local_farm_items = mutableListOf<RVFarmDataModel>()
        adapter.submitList(local_farm_items)

        binding.rvFarm.adapter = adapter
        binding.rvFarm.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvFarm.addItemDecoration(GridSpaceItemDecoration(2, px.toInt()))

        local_farm_items.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))
        local_farm_items.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))
        local_farm_items.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))
        local_farm_items.add(RVFarmDataModel(R.drawable.farm_image_example,"고덕 주말 농장","3평","150,000"))
    }

    private fun dpToPx(context: Context, dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FarmusRecFarmFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FarmusRecFarmFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}