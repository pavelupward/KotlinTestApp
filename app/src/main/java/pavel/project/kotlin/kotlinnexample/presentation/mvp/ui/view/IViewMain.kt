package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.view

import com.arellomobile.mvp.MvpView

import pavel.bogrecov.omertex.data.model.Profile

/**
 * Created by pavel on 20.10.2017.
 */

interface IViewMain : MvpView {
    fun showList(exampleModels: List<Profile>)

    fun showError(error: String)

    fun hideProgress()

    fun showErrorInActivity()

}
