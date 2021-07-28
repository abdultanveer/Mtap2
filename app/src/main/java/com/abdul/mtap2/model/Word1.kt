package com.abdul.mtap2.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Word1( @NonNull @PrimaryKey @ColumnInfo val word: String?)