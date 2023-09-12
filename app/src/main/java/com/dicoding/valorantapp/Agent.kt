package com.dicoding.valorantapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Agent(
    val name: String,
    val description: String,
    val photo: Int,
    val photoDetail: Int,
    val role: String,
    val origin: String,
    val gender: String,
    val biography: String
) : Parcelable