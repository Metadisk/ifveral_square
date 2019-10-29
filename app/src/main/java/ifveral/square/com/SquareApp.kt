package ifveral.square.com

import android.app.Application
import ifveral.square.com.di.component.ApplicationComponent
import ifveral.square.com.di.component.DaggerApplicationComponent
import ifveral.square.com.di.module.ApplicationModule
import ifveral.square.com.di.module.HomeModule
import ifveral.square.com.di.module.NetworkAPIModule

class SquareApp : Application(){

    val component: ApplicationComponent by lazy {

        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .homeModule(HomeModule())
            .networkAPIModule(NetworkAPIModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}