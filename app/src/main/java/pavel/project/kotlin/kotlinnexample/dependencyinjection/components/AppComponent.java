package pavel.project.kotlin.kotlinnexample.dependencyinjection.components;

import android.content.Context;

import dagger.BindsInstance;
import dagger.Component;

/*@Singleton
@Component(modules = {AppModule.class})*/
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }

   // void inject(App app);
}
