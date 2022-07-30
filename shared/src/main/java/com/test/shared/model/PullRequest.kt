package com.test.shared.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PullRequest(
    @SerializedName("diff_url")
    @Expose
    var diffUrl: String?,
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String?,
    @SerializedName("merged_at")
    @Expose
    var mergedAt: String?,
    @SerializedName("patch_url")
    @Expose
    var patchUrl: String?,
    @SerializedName("url")
    @Expose
    var url: String?
) : Parcelable