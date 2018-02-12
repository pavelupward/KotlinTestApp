package pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

import pavel.project.kotlin.kotlinnexample.data.mapper.UserEntityDataMapper
import pavel.project.kotlin.kotlinnexample.domain.biusness.NetworkInteractor
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.view.IViewMain
import pavel.project.kotlin.kotlinnexample.rxschedulers.rx.RxSchedulers

/**
 * Created by pavel on 20.10.2017.
 */
@InjectViewState
class PresenterMainActivity : MvpPresenter<IViewMain>() {
    private val networkInteractor: NetworkInteractor? = null
    private val rxSchedulers: RxSchedulers? = null

    init {

    }

    fun onLoadData(){
        networkInteractor?.getAllProfile()?.subscribeOn(rxSchedulers?.io())
                .observeOn(rxSchedulers?.androidThread()).subscribe
           /* iViewMainActivity.showList(lists);
            iViewMainActivity.hideProgress();

        }, throwable -> iViewMainActivity.showError(throwable.toString()));

        iViewMainActivity.showError(String.valueOf(R.string.check_your_internet_connection));
        iViewMainActivity.hideProgress();
        iViewMainActivity.showErrorInActivity();*/
    }
}
