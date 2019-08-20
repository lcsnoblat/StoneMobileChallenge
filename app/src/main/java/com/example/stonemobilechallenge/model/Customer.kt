package com.example.stonemobilechallenge.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Customer(val name: String,
           val id: Int, val status: String, val description: String) : Parcelable