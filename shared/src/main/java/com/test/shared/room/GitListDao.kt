package com.test.shared.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.shared.model.room.GitListItem

@Dao
interface GitListDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(deletedMedia: GitListItem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(deletedMedia: List<GitListItem>)

    @Query("SELECT * FROM gitlistitem")
    fun list(): List<GitListItem>?
//
//    @Delete
//    fun delete(deletedMedia: GitListItem)
//
//
//    @Query("delete FROM gitlistitem where id == :itemId")
//    fun deleteItemById(itemId: Int)
//
//    @Query("SELECT * FROM gitlistitem where id == :id")
//    fun listWhere(id: String): List<String>

}