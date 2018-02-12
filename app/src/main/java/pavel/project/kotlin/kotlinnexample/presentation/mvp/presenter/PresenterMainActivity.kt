package pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

import pavel.project.kotlin.kotlinnexample.data.mapper.UserEntityDataMapper
import pavel.project.kotlin.kotlinnexample.domain.biusness.InteractorNetworkImpl
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.view.IViewMain
import pavel.project.kotlin.kotlinnexample.rxschedulers.rx.RxSchedulers

/**
 * Created by pavel on 20.10.2017.
 */
@InjectViewState
class PresenterMainActivity(private val interactorNetworkImpl: InteractorNetworkImpl, private val rxSchedulers: RxSchedulers) : MvpPresenter<IViewMain>() {
    private val userEntityDataMapper: UserEntityDataMapper? = null

    override fun onDestroy() {

    }
}
