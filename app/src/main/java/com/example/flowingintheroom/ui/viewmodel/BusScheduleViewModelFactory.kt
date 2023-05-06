package com.example.flowingintheroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flowingintheroom.data.dao.ScheduleDao

class BusScheduleViewModelFactory(
   private val scheduleDao: ScheduleDao
) : ViewModelProvider.Factory {

   override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if(modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
         @Suppress("UNCHECKED_CAST")
         return BusScheduleViewModel(scheduleDao) as T
      }
      throw java.lang.IllegalArgumentException("Unknown ViewModel class")
   }

}