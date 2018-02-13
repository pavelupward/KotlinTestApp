package pavel.project.kotlin.kotlinnexample.dependencyinjection.modules

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import pavel.bogrecov.omertex.data.repository.NetworkRepository
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig.BASE_PHOTO
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig.BASE_URL
import pavel.project.kotlin.kotlinnexample.data.api.JsonApi
import pavel.project.kotlin.kotlinnexample.data.api.PhotoApi
import pavel.project.kotlin.kotlinnexample.data.mapper.UserEntityDataMapper
import pavel.project.kotlin.kotlinnexample.domain.business.InteractorNetworkImpl
import pavel.project.kotlin.kotlinnexample.domain.business.NetworkInteractor
import pavel.project.kotlin.kotlinnexample.rxschedulers.rx.AppRxSchedulers
import pavel.project.kotlin.kotlinnexample.rxschedulers.rx.RxSchedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideUserEntityDataMapper(): UserEntityDataMapper {
        return UserEntityDataMapper()
    }

    @Singleton
    @Provides
    fun provideInteractorNetwork(iNetworkRepository: NetworkRepository, userEntityDataMapper: UserEntityDataMapper): NetworkInteractor {
        return InteractorNetworkImpl(iNetworkRepository, userEntityDataMapper)
    }
    /**/

    @Singleton
    @Provides
    fun provideApiService(client: OkHttpClient): JsonApi {
        val retrofit = Retrofit.Builder().client(client).baseUrl(BASE_URL)
                .addConverterFactory(provideGsonClient()).addCallAdapterFactory(provideRxAdapter()).build()
        return retrofit.create(JsonApi::class.java)
    }

    @Singleton
    @Provides
    fun providePhotoApiService(client: OkHttpClient): PhotoApi {
        val retrofit = Retrofit.Builder().client(client).baseUrl(BASE_PHOTO)
                .addConverterFactory(provideGsonClient()).addCallAdapterFactory(provideRxAdapter()).build()
        return retrofit.create(PhotoApi::class.java)
    }

    @Singleton
    @Provides
    fun providerNetworkRepository(jsonAPI: JsonApi, photoApi: PhotoApi): NetworkRepository {
        return NetworkRepository(jsonAPI, photoApi)
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {

        return OkHttpClient().newBuilder().build()
    }

    @Singleton
    @Provides
    fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS)
    }

    @Singleton
    @Provides
    fun provideAppRxSchedulers(): RxSchedulers {
        return AppRxSchedulers();
    }

    @Provides
    fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}

