package com.simx.simplesliderintro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.simx.simplesliderintro.databinding.ItemImageBinding

/**
 * Created by simx on 14,September,2019
 */
class ImagePageAdapter(private var images:List<Int>?): PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var binding = ItemImageBinding.bind(LayoutInflater.from(container.context).inflate(R.layout.item_image, container, false))
        with(binding){
            itemImageVm = ItemImageVM(images?.get(position))
            executePendingBindings()
        }
        container.addView(binding.root)
        return binding.root
    }
    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by [.instantiateItem]. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view Page View to check for association with `object`
     * @param object Object to check for association with `view`
     * @return true if `view` is associated with the key object `object`
     */
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return images?.size!!
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}