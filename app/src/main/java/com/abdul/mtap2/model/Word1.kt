package com.abdul.mtap2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word1(@PrimaryKey @ColumnInfo val word: String)