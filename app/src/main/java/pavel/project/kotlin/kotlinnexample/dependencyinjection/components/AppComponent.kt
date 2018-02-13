package pavel.project.kotlin.kotlinnexample.dependencyinjection.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import pavel.project.kotlin.kotlinnexample.dependencyinjection.modules.ActivityBuilder
import pavel.project.kotlin.kotlinnexample.dependencyinjection.modules.NetworkModule
import pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter.PresenterMainActivity
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.base.App
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, NetworkModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
    fun inject(presenterMainActivity: PresenterMainActivity)
}
