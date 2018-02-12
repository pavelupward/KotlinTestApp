package pavel.project.kotlin.kotlinnexample.data.api;

import io.reactivex.Flowable;
import pavel.project.kotlin.kotlinnexample.data.model.PhotoModel;
import retrofit2.http.GET;

/**
 * Created by pavel on 21.10.2017.
 */

public interface PhotoApi {

    @GET("/list")
    Flowable<PhotoModel[]> getAllPhoto();
}
