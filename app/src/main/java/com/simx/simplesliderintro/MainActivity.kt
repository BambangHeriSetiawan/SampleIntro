package com.simx.simplesliderintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.simx.simplesliderintro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var vm:MainActivityVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        vm = MainActivityVM()
        binding.lifecycleOwner = this
        binding.mainVm = vm
        var images = listOf(R.drawable.opening_one,R.drawable.opening_two,R.drawable.opening_three,R.drawable.opening_four)
        binding.vpIntro.adapter = ImagePageAdapter(images)
        binding.tabs.setupWithViewPager(binding.vpIntro, true)
        binding.vpIntro.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            /**
             * Called when the scroll state changes. Useful for discovering when the user
             * begins dragging, when the pager is automatically settling to the current page,
             * or when it is fully stopped/idle.
             *
             * @param state The new scroll state.
             * @see ViewPager.SCROLL_STATE_IDLE
             *
             * @see ViewPager.SCROLL_STATE_DRAGGING
             *
             * @see ViewPager.SCROLL_STATE_SETTLING
             */
            override fun onPageScrollStateChanged(state: Int) {
                Log.e("MainActivity","onPageScrollStateChanged -> $state")
            }

            /**
             * This method will be invoked when the current page is scrolled, either as part
             * of a programmatically initiated smooth scroll or a user initiated touch scroll.
             *
             * @param position Position index of the first page currently being displayed.
             * Page position+1 will be visible if positionOffset is nonzero.
             * @param positionOffset Value from [0, 1) indicating the offset from the page at position.
             * @param positionOffsetPixels Value in pixels indicating the offset from position.
             */
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.e("MainActivity","onPageScrolled -> $position")
                Log.e("MainActivity","onPageScrolled -> $positionOffset")
                Log.e("MainActivity","onPageScrolled -> $positionOffsetPixels")
            }

            /**
             * This method will be invoked when a new page becomes selected. Animation is not
             * necessarily complete.
             *
             * @param position Position index of the new selected page.
             */
            override fun onPageSelected(position: Int) {
                Log.e("MainActivity","onPageSelected -> $position")
                vm.currentPosition.postValue(position)
            }
        })
        Toast.makeText(this,"${binding.vpIntro.currentItem}", Toast.LENGTH_SHORT).show()
        vm.currentPosition.observe(this, Observer { pos -> run {
            if (pos == 3)binding.btnGetStarted.visibility = View.VISIBLE
            else binding.btnGetStarted.visibility = View.GONE
        } })

    }
}
