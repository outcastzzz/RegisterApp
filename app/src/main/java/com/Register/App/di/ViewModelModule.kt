package com.Register.App.di

import androidx.lifecycle.ViewModel
import com.Register.App.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindCoinViewModel(viewModel: MainViewModel): ViewModel
}