package mx.marcrobito.weatherapp.di

import dagger.Component
import mx.marcrobito.weatherapp.presentation.MainActivity
import mx.marcrobito.weatherapp.presentation.MainViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(main:MainActivity)
}