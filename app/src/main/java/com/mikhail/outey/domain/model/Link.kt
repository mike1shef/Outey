package com.mikhail.outey.domain.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mikhail.outey.core.Constants.Companion.LINKS_TABLE
import com.mikhail.outey.core.Constants.Companion.LINK_COLUMN

@Entity (tableName = LINKS_TABLE)
data class Link (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo (name = LINK_COLUMN)val link : String
)