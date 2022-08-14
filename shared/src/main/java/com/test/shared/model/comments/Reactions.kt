package com.test.shared.model.comments


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Reactions(
    @SerializedName("confused")
    @Expose
    var confused: Int?,
    @SerializedName("eyes")
    @Expose
    var eyes: Int?,
    @SerializedName("heart")
    @Expose
    var heart: Int?,
    @SerializedName("hooray")
    @Expose
    var hooray: Int?,
    @SerializedName("laugh")
    @Expose
    var laugh: Int?,
    @SerializedName("rocket")
    @Expose
    var rocket: Int?,
    @SerializedName("total_count")
    @Expose
    var totalCount: Int?,
    @SerializedName("url")
    @Expose
    var url: String?
) : Parcelable