package com.example.pendapetro.di

import androidx.room.Room
import com.example.pendapetro.data.local.MainDb
import com.example.pendapetro.presentation.viewmodel.TestViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MainDb::class.java,
            "main_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single { MainDb.getInstance(get()) }
    single { get<MainDb>().questionDao() }
    single { get<MainDb>().categoryDao() }

    single { TestViewModel(get(), get()) }
}