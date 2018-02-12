package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.adapter

import android.app.Dialog
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.R
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig.PHOTO_URL_IMAGE

/**
 * Created by pavel on 21.10.2017.
 */

class ViewHolderItemCard(itemView: View) : RecyclerView.ViewHolder(itemView) {
     var imageLogo: ImageView
     var descriptionText: TextView
     var titleText: TextView


    init {
        imageLogo = itemView.findViewById(R.id.logo_image)
        descriptionText = itemView.findViewById(R.id.description_text)
        titleText = itemView.findViewById(R.id.title_text)
    }


    fun bind(model: Profile, holderItem: ViewHolderItemCard) {
      Glide.with(itemView.context)
                .load(ApiUrlConfig.PHOTO_URL_BASE + PHOTO_URL_IMAGE + model.idProfile).into(imageLogo)
        titleText.setText(model.photoModel)
        description.setText(model.photoModel!!.getFilename())

        holderItem.getView().setOnClickListener({ v ->
            val dialog = Dialog(activity)
            dialog.setContentView(R.layout.detail_layout)
            dialog.setTitle("Name " + model.photoModel!!.getFilename())
            dialog.setCancelable(true)
            val name = dialog.findViewById<View>(R.id.some_text) as TextView
            val job = dialog.findViewById<View>(R.id.description) as TextView
            val icon = dialog.findViewById(R.id.item_hero_image) as ImageView
            name.setText(model.exModel!!.getBody())
            job.setText(model.exModel!!.getTitle())
            Glide.with(view.context)
                    .load(URLAPI.PHOTO_URL_BASE + requestedPhotoWidth + PHOTO_URL_IMAGE +
                            model.photoModel!!.getId()).into(icon)
            dialog.show()
        })

    }

}
