package com.simx.simplesliderintro

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

/**
 * Created by simx on 14,September,2019
 */
class ItemImageVM(asset:Int?): BaseObservable() {
    @Bindable var image = ObservableField(asset)
}