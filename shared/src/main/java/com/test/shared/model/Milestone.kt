package com.test.shared.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Milestone(
    @SerializedName("closed_at")
    @Expose
    var closedAt: String?,
    @SerializedName("closed_issues")
    @Expose
    var closedIssues: Int?,
    @SerializedName("created_at")
    @Expose
    var createdAt: String?,
    @SerializedName("creator")
    @Expose
    var creator: Creator?,
    @SerializedName("description")
    @Expose
    var description: String?,
    @SerializedName("due_on")
    @Expose
    var dueOn: String?,
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String?,
    @SerializedName("node_id")
    @Expose
    var nodeId: String?,
    @SerializedName("number")
    @Expose
    var number: Int?,
    @SerializedName("open_issues")
    @Expose
    var openIssues: Int?,
    @SerializedName("state")
    @Expose
    var state: String?,
    @SerializedName("title")
    @Expose
    var title: String?,
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String?,
    @SerializedName("url")
    @Expose
    var url: String?
) : Parcelable