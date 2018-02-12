package pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import pavel.project.kotlin.kotlinnexample.domain.biusness.NetworkInteractor
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.view.IViewMain
import pavel.project.kotlin.kotlinnexample.rxschedulers.rx.RxSchedulers

/**
 * Created by pavel on 20.10.2017.
 */
@InjectViewState
class PresenterMainActivity( private val networkInteractor: NetworkInteractor,
                             private val rxSchedulers: RxSchedulers) : MvpPresenter<IViewMain>() {

    fun onLoadData(){
        networkInteractor.getAllProfile().subscribeOn(rxSchedulers.io())
                .observeOn(rxSchedulers.androidThread()).subscribe()
//todo
    }
}
