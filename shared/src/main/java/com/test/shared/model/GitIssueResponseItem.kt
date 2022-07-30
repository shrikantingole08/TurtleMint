package com.test.shared.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitIssueResponseItem(
    @SerializedName("active_lock_reason")
    @Expose
    var activeLockReason: String?,
    @SerializedName("assignee")
    @Expose
    var assignee: Assignee?,
    @SerializedName("assignees")
    @Expose
    var assignees: List<Assignee?>?,
    @SerializedName("author_association")
    @Expose
    var authorAssociation: String?,
    @SerializedName("body")
    @Expose
    var body: String?,
    @SerializedName("closed_at")
    @Expose
    var closedAt: String?,
    @SerializedName("comments")
    @Expose
    var comments: Int?,
    @SerializedName("comments_url")
    @Expose
    var commentsUrl: String?,
    @SerializedName("created_at")
    @Expose
    var createdAt: String?,
    @SerializedName("draft")
    @Expose
    var draft: Boolean?,
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String?,
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("labels")
    @Expose
    var labels: List<Label?>?,
    @SerializedName("labels_url")
    @Expose
    var labelsUrl: String?,
    @SerializedName("locked")
    @Expose
    var locked: Boolean?,
    @SerializedName("milestone")
    @Expose
    var milestone: Milestone?,
    @SerializedName("node_id")
    @Expose
    var nodeId: String?,
    @SerializedName("number")
    @Expose
    var number: Int?,
    @SerializedName("performed_via_github_app")
    @Expose
    var performedViaGithubApp: String?,
    @SerializedName("pull_request")
    @Expose
    var pullRequest: PullRequest?,
    @SerializedName("reactions")
    @Expose
    var reactions: Reactions?,
    @SerializedName("repository_url")
    @Expose
    var repositoryUrl: String?,
    @SerializedName("state")
    @Expose
    var state: String?,
    @SerializedName("state_reason")
    @Expose
    var stateReason: String?,
    @SerializedName("timeline_url")
    @Expose
    var timelineUrl: String?,
    @SerializedName("title")
    @Expose
    var title: String?,
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