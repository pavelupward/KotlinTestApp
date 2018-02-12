package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import pavel.project.kotlin.kotlinnexample.R

class MainActivity : AppCompatActivity() {

    @InjectPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
