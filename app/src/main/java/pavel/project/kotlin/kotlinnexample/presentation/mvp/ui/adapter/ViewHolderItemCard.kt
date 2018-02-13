package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.adapter

import android.app.Dialog
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.R
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig.PHOTO_URL_BASE
import pavel.project.kotlin.kotlinnexample.data.api.ApiUrlConfig.PHOTO_URL_IMAGE



/**
 * Created by pavel on 21.10.2017.
 */

class ViewHolderItemCard(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var imageLogo: ImageView = itemView.findViewById(R.id.logo_image)
    private var descriptionText: TextView = itemView.findViewById(R.id.description_text)
    private var titleText: TextView = itemView.findViewById(R.id.title_text)
    private var requestedPhotoWidth : Int
    private val requestOptions = RequestOptions()
    private var url : String? = null


    init {
        requestedPhotoWidth = itemView.context.getResources().getDisplayMetrics().widthPixels
        url = PHOTO_URL_BASE  + requestedPhotoWidth + PHOTO_URL_IMAGE
        requestOptions.placeholder(R.mipmap.ic_launcher)
        requestOptions.error(R.mipmap.ic_launcher)
    }

    fun bind(model: Profile) {
        Glide.with(itemView.context).setDefaultRequestOptions(requestOptions)
                .load(url+ model.photoModel?.id).into(imageLogo)
        titleText.text = model.photoModel?.author
        descriptionText.text = model.photoModel?.filename

        itemView.setOnClickListener({ v ->
              val dialog = Dialog(itemView.context)
              dialog.setContentView(R.layout.item_card_info)
              dialog.setCancelable(true)
              val name = dialog.findViewById<View>(R.id.title_text) as TextView
              val job = dialog.findViewById<View>(R.id.description_text) as TextView
              val icon = dialog.findViewById(R.id.logo_image) as ImageView
              name.setText(model.exModel?.bodyPost)
              job.setText(model.exModel?.titlePost)
              Glide.with(itemView.context).load(url + model.photoModel?.id).into(icon)
              dialog.show()
          })

    }

}
