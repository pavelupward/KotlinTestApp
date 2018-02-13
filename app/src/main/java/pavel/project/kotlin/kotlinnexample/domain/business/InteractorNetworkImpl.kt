package pavel.project.kotlin.kotlinnexample.domain.business

import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.data.mapper.UserEntityDataMapper
import pavel.project.kotlin.kotlinnexample.data.model.ExampleModel
import pavel.project.kotlin.kotlinnexample.data.model.PhotoModel
import pavel.project.kotlin.kotlinnexample.data.repository.RepositoryNetworkImpl
import java.util.*

/**
 * Created by pavel on 21.10.2017.
 */

class InteractorNetworkImpl(val iNetworkRepository: RepositoryNetworkImpl,
                            val userEntityDataMapper: UserEntityDataMapper) : NetworkInteractor {

    override fun getResponseFromServer(): Flowable<List<ExampleModel>> {
        return iNetworkRepository.getResponse().map(Arrays::asList)
    }

    override fun getPhotoResponse(): Flowable<List<PhotoModel>> {
        return iNetworkRepository.getPhotoResponse().map(Arrays::asList)
    }

    override fun getAllProfile(): Flowable<List<Profile>> {

        return Flowable.combineLatest(iNetworkRepository.getPhotoResponse().map(Arrays::asList),
                iNetworkRepository.getResponse().map(Arrays::asList), BiFunction { photoModels, exampleModels ->
            userEntityDataMapper.transform(exampleModels.subList(exampleModels.size - 50, exampleModels.size),
                    photoModels.subList(photoModels.size - 50, photoModels.size))
        });


    }


}
