package com.test.shared.model.comments


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommentResItem(
    @SerializedName("author_association")
    @Expose
    var authorAssociation: String?,
    @SerializedName("body")
    @Expose
    var body: String?,
    @SerializedName("created_at")
    @Expose
    var createdAt: String?,
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("issue_url")
    @Expose
    var issueUrl: String?,
    @SerializedName("node_id")
    @Expose
    var nodeId: String?,
    @SerializedName("performed_via_github_app")
    @Expose
    var reactions: Reactions?,
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String?,
    @SerializedName("url")
    @Expose
    var url: String?,
    @SerializedName("user")
    @Expose
    var user: User?
) : Parcelable