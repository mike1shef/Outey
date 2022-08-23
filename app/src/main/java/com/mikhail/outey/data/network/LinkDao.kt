package com.mikhail.outey.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.mikhail.outey.core.Constants.Companion.LINKS_TABLE
import com.mikhail.outey.domain.model.Link
import kotlinx.coroutines.flow.Flow

@Dao
interface LinkDao {
    @Query("SELECT * FROM $LINKS_TABLE ORDER BY id ASC")
    fun getLinks() : Flow<List<Link>>

    @Query("SELECT * FROM $LINKS_TABLE WHERE id = :id")
    fun getLink(id:Int) : Flow<Link>

    @Insert(onConflict = IGNORE)
    fun addLink(link: Link)

    @Delete
    fun deleteLink(link: Link)

    @Query("DELETE FROM $LINKS_TABLE")
    suspend fun deleteAll()
}