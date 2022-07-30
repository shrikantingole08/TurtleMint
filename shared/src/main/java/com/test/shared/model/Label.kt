package com.test.shared.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Label(
    @SerializedName("color")
    @Expose
    var color: String?,
    @SerializedName("default")
    @Expose
    var default: Boolean?,
    @SerializedName("description")
    @Expose
    var description: String?,
    @SerializedName("id")
    @Expose
    var id: Long?,
    @SerializedName("name")
    @Expose
    var name: String?,
    @SerializedName("node_id")
    @Expose
    var nodeId: String?,
    @SerializedName("url")
    @Expose
    var url: String?
) : Parcelable