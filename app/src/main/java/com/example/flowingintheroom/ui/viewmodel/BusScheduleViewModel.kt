package com.example.flowingintheroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.flowingintheroom.data.dao.ScheduleDao
import com.example.flowingintheroom.data.room_entity.Schedule

class BusScheduleViewModel(
    private val scheduleDao: ScheduleDao
) : ViewModel() {

    fun fullSchedule() = scheduleDao.getAll()

    fun scheduleForStopName(name: String) = scheduleDao.getStopByName(name)

}