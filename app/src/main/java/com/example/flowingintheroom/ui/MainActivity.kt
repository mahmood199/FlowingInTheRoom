package com.example.flowingintheroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.flowingintheroom.BusScheduleApplication
import com.example.flowingintheroom.databinding.ActivityMainBinding
import com.example.flowingintheroom.ui.viewmodel.BusScheduleViewModel
import com.example.flowingintheroom.ui.viewmodel.BusScheduleViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: BusScheduleViewModel by viewModels {
        BusScheduleViewModelFactory(
            (application as BusScheduleApplication).database.scheduleDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBusSchedule.adapter = BusStopAdapter {
            Toast.makeText(this, it.stopName, Toast.LENGTH_SHORT).show()
        }

        addItemsToRecyclerView()

    }

    private fun addItemsToRecyclerView() {
        lifecycleScope.launch {
            (binding.rvBusSchedule.adapter as BusStopAdapter).submitList(viewModel.fullSchedule())
        }
    }
}