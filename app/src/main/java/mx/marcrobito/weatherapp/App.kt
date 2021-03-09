package mx.marcrobito.weatherapp

import android.app.Application
import mx.marcrobito.weatherapp.di.AppComponent
import mx.marcrobito.weatherapp.di.DaggerAppComponent

class App:Application(){

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().build()
    }



}