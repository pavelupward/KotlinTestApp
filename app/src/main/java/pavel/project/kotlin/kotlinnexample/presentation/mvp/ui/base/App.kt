package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.base


import android.app.Application
import pavel.project.kotlin.kotlinnexample.dependencyinjection.components.AppComponent
import pavel.project.kotlin.kotlinnexample.dependencyinjection.components.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        graph = DaggerAppComponent
                .builder()
                .build()
    }

}
