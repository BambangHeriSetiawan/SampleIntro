package com.simx.simplesliderintro


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

/**
 * Created by simx on 14,September,2019
 */
class BindAdapter {
    companion object {
        @BindingAdapter ("bind:image_asset")@JvmStatic fun bindImage(view:ImageView, asset:Int){
            view.load(asset){
                error(R.mipmap.ic_launcher)
            }
        }
    }

}