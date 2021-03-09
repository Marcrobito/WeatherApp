package mx.marcrobito.weatherapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mx.marcrobito.weatherapp.ViewModelFactory
import mx.marcrobito.weatherapp.presentation.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun  bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindingMainViewModel(viewModel: MainViewModel):ViewModel
}