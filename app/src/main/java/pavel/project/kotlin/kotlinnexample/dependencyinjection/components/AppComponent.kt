package pavel.project.kotlin.kotlinnexample.dependencyinjection.components

import dagger.Component
import pavel.project.kotlin.kotlinnexample.dependencyinjection.modules.NetworkModule
import pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter.PresenterMain
import javax.inject.Singleton



@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(presenterMain: PresenterMain)
}
