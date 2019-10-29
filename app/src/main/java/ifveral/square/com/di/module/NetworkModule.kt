package ifveral.square.com.di.module

import dagger.Module
import dagger.Provides
import ifveral.square.com.data.Source.NetworkApi
import javax.inject.Singleton

@Module
class NetworkAPIModule {

    @Provides
    @Singleton
    fun provideNetworkApiService() = NetworkApi.create()
}