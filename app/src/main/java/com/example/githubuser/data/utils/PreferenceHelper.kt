package com.example.githubuser.data.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    const val LATEST_UPDATED_DATA_TIME = "latest_updated_data_time"

    fun customPreference(context: Context, name: String): SharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.update(operation: (SharedPreferences.Editor) -> Unit) {
        val edited = edit()
        operation(edited)
        edited.apply()
    }

    var SharedPreferences.latestUpdatedDataTime
        get() = getLong(LATEST_UPDATED_DATA_TIME, 0L)
        set(value) {
            update {
                it.putLong(LATEST_UPDATED_DATA_TIME, value)
            }
        }
}