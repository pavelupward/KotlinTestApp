package pavel.project.kotlin.kotlinnexample.dependencyinjection.modules

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import pavel.bogrecov.omertex.data.repository.NetworkRepository
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig.BASE_PHOTO
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig.BASE_URL
import pavel.project.kotlin.kotlinnexample.data.api.JsonApi
import pavel.project.kotlin.kotlinnexample.data.api.PhotoApi
import pavel.project.kotlin.kotlinnexample.data.mapper.UserEntityDataMapper
import pavel.project.kotlin.kotlinnexample.dependencyinjection.scopes.ActivityScope
import pavel.project.kotlin.kotlinnexample.domain.biusness.InteractorNetworkImpl
import pavel.project.kotlin.kotlinnexample.domain.biusness.NetworkInteractor
import pavel.project.kotlin.kotlinnexample.rxschedulers.rx.AppRxSchedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @ActivityScope
    @Provides
    fun provideUserEntityDataMapper(): UserEntityDataMapper {
        return UserEntityDataMapper()
    }

    @ActivityScope
    @Provides
    fun provideInteractorNetwork(iNetworkRepository: NetworkRepository, userEntityDataMapper: UserEntityDataMapper): NetworkInteractor {
        return InteractorNetworkImpl(iNetworkRepository, userEntityDataMapper)
    }

    @ActivityScope
    @Provides
    fun provideApiService(client: OkHttpClient): JsonApi {
        val retrofit = Retrofit.Builder().client(client).baseUrl(BASE_URL)
                .addConverterFactory(provideGsonClient()).addCallAdapterFactory(provideRxAdapter()).build()
        return retrofit.create(JsonApi::class.java)
    }

    @ActivityScope
    @Provides
    fun providePhotoApiService(client: OkHttpClient): PhotoApi {
        val retrofit = Retrofit.Builder().client(client).baseUrl(BASE_PHOTO)
                .addConverterFactory(provideGsonClient()).addCallAdapterFactory(provideRxAdapter()).build()
        return retrofit.create(PhotoApi::class.java)
    }

    @ActivityScope
    @Provides
    fun providerNetworkRepository(jsonAPI: JsonApi, photoApi: PhotoApi): NetworkRepository {
        return NetworkRepository(jsonAPI, photoApi)
    }

    @ActivityScope
    @Provides
    fun provideHttpClient(): OkHttpClient {

        return OkHttpClient().newBuilder().build()
    }

    @ActivityScope
    @Provides
     fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_EXECUTOR as Scheduler)
    }

    @Provides
     fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}

