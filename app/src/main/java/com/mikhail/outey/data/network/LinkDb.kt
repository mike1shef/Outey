package com.mikhail.outey.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikhail.outey.domain.model.Link

@Database (entities = [Link::class], version = 1, exportSchema = false)
abstract class LinkDb : RoomDatabase(){
    abstract fun linkDao () : LinkDao
}