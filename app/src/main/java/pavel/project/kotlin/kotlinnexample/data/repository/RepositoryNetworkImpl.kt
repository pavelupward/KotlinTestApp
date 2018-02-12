package pavel.project.kotlin.kotlinnexample.data.repository

import io.reactivex.Flowable
import pavel.project.kotlin.kotlinnexample.data.model.ExampleModel
import pavel.project.kotlin.kotlinnexample.data.model.PhotoModel

/**
 * Created by pavel on 21.10.2017.
 */

interface RepositoryNetworkImpl {

    fun getResponse() : Flowable<Array<ExampleModel>>

    fun getPhotoResponse() : Flowable<Array<PhotoModel>>

}
