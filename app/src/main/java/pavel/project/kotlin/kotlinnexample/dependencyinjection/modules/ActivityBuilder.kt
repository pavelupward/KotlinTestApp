package pavel.project.kotlin.kotlinnexample.dependencyinjection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.activity.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(NetworkModule::class))
    abstract fun bindMainActivity(): MainActivity
}