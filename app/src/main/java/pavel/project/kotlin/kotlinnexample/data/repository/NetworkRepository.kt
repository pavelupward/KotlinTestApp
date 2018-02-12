package pavel.bogrecov.omertex.data.repository

import io.reactivex.Flowable
import pavel.project.kotlin.kotlinnexample.data.api.JsonApi
import pavel.project.kotlin.kotlinnexample.data.api.PhotoApi
import pavel.project.kotlin.kotlinnexample.data.model.ExampleModel
import pavel.project.kotlin.kotlinnexample.data.model.PhotoModel
import pavel.project.kotlin.kotlinnexample.data.repository.RepositoryNetworkImpl

/**
 * Created by pavel on 21.10.2017.
 */

class NetworkRepository(val jsonAPI: JsonApi, val photoApi: PhotoApi) : RepositoryNetworkImpl {

    override fun getResponse(): Flowable<Array<ExampleModel>> {
        return jsonAPI.allPost
    }

    override fun getPhotoResponse(): Flowable<Array<PhotoModel>> {
        return photoApi.allPhoto
    }

}
