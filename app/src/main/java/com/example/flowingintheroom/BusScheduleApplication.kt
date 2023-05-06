package com.example.flowingintheroom

import android.app.Application
import com.example.flowingintheroom.data.AppDatabase

class BusScheduleApplication: Application() {

    val database by lazy {
        AppDatabase.getDatabase(this)
    }

}