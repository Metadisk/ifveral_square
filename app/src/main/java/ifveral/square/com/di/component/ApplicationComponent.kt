package ifveral.square.com.di.component

import dagger.Component
import ifveral.square.com.SquareApp
import ifveral.square.com.di.module.ApplicationModule
import ifveral.square.com.di.module.HomeModule
import ifveral.square.com.di.module.NetworkAPIModule
import ifveral.square.com.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class),(HomeModule::class),(NetworkAPIModule::class)])
interface ApplicationComponent {

    fun inject(application: SquareApp)
    fun inject(activity: MainActivity)

}