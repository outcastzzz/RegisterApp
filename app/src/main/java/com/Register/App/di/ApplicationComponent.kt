package com.Register.App.di

import android.app.Application
import com.Register.App.domain.entities.Payment
import com.Register.App.presentation.AuthApp
import com.Register.App.presentation.LoginFragment
import com.Register.App.presentation.MainActivity
import com.Register.App.presentation.PaymentFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: LoginFragment)

    fun inject(fragment: PaymentFragment)

    fun inject(application: AuthApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}