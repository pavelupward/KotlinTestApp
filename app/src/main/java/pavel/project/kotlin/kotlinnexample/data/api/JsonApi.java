package pavel.project.kotlin.kotlinnexample.data.api;

import io.reactivex.Flowable;
import pavel.project.kotlin.kotlinnexample.data.model.ExampleModel;
import retrofit2.http.GET;

/**
 * Created by pavel on 20.10.2017.
 */

public interface JsonApi {

    @GET("/posts")
    Flowable<ExampleModel[]> getAllPost();

}
