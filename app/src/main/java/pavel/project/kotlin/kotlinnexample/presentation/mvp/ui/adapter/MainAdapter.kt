package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.R

/**
 * Created by pavel on 21.10.2017.
 */

class MainAdapter(val list: List<Profile>) : RecyclerView.Adapter<ViewHolderItemCard>() {
    private var model: List<Profile>? = null
    private var requestedPhotoWidth: Int = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemCard {
        //requestedPhotoWidth = parent.context.resources.displayMetrics.widthPixels
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_info, parent, false)
        val viewHolderItemCard = ViewHolderItemCard(view);
        return viewHolderItemCard
    }

    override fun onBindViewHolder(holder: ViewHolderItemCard, position: Int) {
        val item = list.get(position)
        holder.bind(item, holder)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}
