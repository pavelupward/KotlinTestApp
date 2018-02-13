package pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import pavel.project.kotlin.kotlinnexample.domain.biusness.NetworkInteractor
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.base.App
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.view.IViewMain
import pavel.project.kotlin.kotlinnexample.rxschedulers.rx.RxSchedulers
import javax.inject.Inject

/**
 * Created by pavel on 20.10.2017.
 */
@InjectViewState
class PresenterMainActivity : MvpPresenter<IViewMain>() {

    @Inject
    lateinit var networkInteractor: NetworkInteractor
    @Inject
    lateinit var rxSchedulers: RxSchedulers


    init {
        App.graph.inject(this)
    }

    fun onLoadData(){
        networkInteractor.getAllProfile().subscribeOn(rxSchedulers.io())
                .observeOn(rxSchedulers.androidThread()).subscribe()

    }
    /* if (NetworkUtils.INSTANCE.isNetworkAvailable()) {
            interactorNetwork.getRezult().subscribeOn(rxSchedulers.io())
                    .observeOn(rxSchedulers.androidThread()).subscribe(lists -> {
                iViewMainActivity.showList(lists);
                iViewMainActivity.hideProgress();

            }, throwable -> iViewMainActivity.showError(throwable.toString()));
        } else {
            iViewMainActivity.showError(String.valueOf(R.string.check_your_internet_connection));
            iViewMainActivity.hideProgress();
            iViewMainActivity.showErrorInActivity();

        }*/
}
