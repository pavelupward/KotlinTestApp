package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.base


import android.app.Activity
import android.app.Application
import javax.inject.Inject

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import pavel.project.kotlin.kotlinnexample.dependencyinjection.components.AppComponent

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        graph = DaggerAppComponent
                .builder()
                .build().inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}
