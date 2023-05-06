package com.example.flowingintheroom.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.flowingintheroom.data.room_entity.Schedule

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): List<Schedule>

    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getStopByName(stopName: String): List<Schedule>

}