package pavel.project.kotlin.kotlinnexample.dependencyinjection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pavel.project.kotlin.kotlinnexample.dependencyinjection.scopes.ActivityScope
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.activity.MainActivity

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [NetworkModule::class])
    fun mainActivityInjector(): MainActivity

}
