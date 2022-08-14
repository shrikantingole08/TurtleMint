package com.test.shared.model.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class GitListItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "desc")
    var desc: String?,
    @ColumnInfo(name = "Author")
    var Author: String?,
    @ColumnInfo(name = "avatarUrl")
    var avatarUrl: String?,
    @ColumnInfo(name = "date")
    var date: String?,
    @ColumnInfo(name = "commentUrl")
    var commentUrl: String?
) : Parcelable

