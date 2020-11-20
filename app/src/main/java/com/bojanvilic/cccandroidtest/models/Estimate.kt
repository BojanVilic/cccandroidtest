package com.bojanvilic.cccandroidtest.models


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "estimate_table")
data class Estimate(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("contact")
    val contact: String,
    @SerializedName("created_by")
    val createdBy: String,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("requested_by")
    val requestedBy: String,
    @SerializedName("revision_number")
    val revisionNumber: Int
)