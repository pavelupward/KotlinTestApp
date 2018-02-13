package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.activity

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.ProgressBar
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_internet_view.*
import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.R
import pavel.project.kotlin.kotlinnexample.presentation.mvp.presenter.PresenterMain
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.adapter.MainAdapter
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.adapter.SubscribeDecoration
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.base.BaseActivity
import pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.view.IViewMain

class MainActivity : BaseActivity(), IViewMain {

    @InjectPresenter
    lateinit var presenterMain: PresenterMain
    private var progressBar : ProgressBar ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewCard.layoutManager = StaggeredGridLayoutManager(3, 1)
        recyclerViewCard.addItemDecoration(SubscribeDecoration(this))

    }

    override fun onStart() {
        super.onStart()
        presenterMain.onLoadData()
    }

    override fun showList(exampleModels: List<Profile>) {
        recyclerViewCard.adapter = MainAdapter(exampleModels)
    }

    override fun showError(error: String) {
        errorLayout.visibility = View.VISIBLE
        errorTextFromServer?.text = error
    }

    override fun hideError() {
        errorLayout.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenterMain.onDestroyView()
    }

}
