package com.simx.simplesliderintro

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData

/**
 * Created by simx on 14,September,2019
 */
class MainActivityVM: BaseObservable() {
    @Bindable var currentPosition = MutableLiveData<Int>()
}