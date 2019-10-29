package ifveral.square.com.di.module

import dagger.Module
import dagger.Provides
import ifveral.square.com.SquareApp
import javax.inject.Singleton

@Module
class ApplicationModule (val squareApp: SquareApp) {

    @Provides
    @Singleton
    fun provideApp() = squareApp

}