package ifveral.square.com.di.module

import dagger.Module
import dagger.Provides
import ifveral.square.com.ui.main.MainPresenter

@Module
class HomeModule {

    @Provides
    fun providesMainPresenter() = MainPresenter()

}