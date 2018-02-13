package pavel.project.kotlin.kotlinnexample.presentation.mvp.ui.adapter

import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View

class SubscribeDecoration(context: Context) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val spacing = dpToPx(5)
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.top = spacing
            outRect.bottom = spacing
            outRect.left = spacing
            outRect.right = spacing
        } else {
            outRect.bottom = spacing
            outRect.left = spacing
            outRect.right = spacing
        }
    }

    fun dpToPx(dp: Int): Int {
        val resultPix = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
                Resources.getSystem().displayMetrics)
        return resultPix.toInt()
    }
}
