package pavel.project.kotlin.kotlinnexample.dependencyinjection.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import pavel.project.kotlin.kotlinnexample.dependencyinjection.modules.AppModule
import pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter.PresenterMainActivity
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.base.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
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
