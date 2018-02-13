package pavel.project.kotlin.kotlinnexample.domain.business

import io.reactivex.Flowable
import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.data.model.ExampleModel
import pavel.project.kotlin.kotlinnexample.data.model.PhotoModel

/**
 * Created by pavel on 21.10.2017.
 */

interface NetworkInteractor {
    fun getResponseFromServer() : Flowable<List<ExampleModel>>

    fun getPhotoResponse() : Flowable<List<PhotoModel>>

    fun getAllProfile() : Flowable<List<Profile>>

}
