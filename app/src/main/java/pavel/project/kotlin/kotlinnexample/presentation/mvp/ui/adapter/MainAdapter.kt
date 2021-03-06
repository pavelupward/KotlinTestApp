package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pavel.bogrecov.omertex.data.model.Profile
import pavel.project.kotlin.kotlinnexample.R

/**
 * Created by pavel on 21.10.2017.
 */

class MainAdapter(val profile: List<Profile>) : RecyclerView.Adapter<ViewHolderItemCard>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemCard {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_info, parent, false)
        val viewHolderItemCard = ViewHolderItemCard(view);
        return viewHolderItemCard
    }

    override fun onBindViewHolder(holder: ViewHolderItemCard, position: Int) {
        val item = profile.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return profile.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}
