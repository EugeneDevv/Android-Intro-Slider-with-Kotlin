package com.kotlincodes.welcomescreenkotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.RelativeLayout
import com.shrishtionline.qikpay.fragments.WelcomeFragment
import android.view.WindowManager
import android.os.Build



class MainActivity : AppCompatActivity() {

    private lateinit var main:RelativeLayout
    private lateinit var viewpager:ViewPager
    private lateinit var tabs:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main=findViewById(R.id.main)
        viewpager=findViewById(R.id.pager)
        tabs=findViewById(R.id.tabDots)
        setupViewPager()
        changeStatusBarColor()

    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
    private fun setupViewPager() {

        val adapter = com.shrishtionline.qikpay.fragments.FragmentPagerAdapter(getSupportFragmentManager())

        var firstFragmet: WelcomeFragment = WelcomeFragment.newInstance("Test","Test",
            R.mipmap.ic_launcher
        )
        var secondFragmet: WelcomeFragment = WelcomeFragment.newInstance("Test1","Test1",
            R.mipmap.ic_launcher
        )
        var thirdFragmet: WelcomeFragment = WelcomeFragment.newInstance("Test2","Test2",
            R.mipmap.ic_launcher
        )

        adapter.addFragment(firstFragmet)
        adapter.addFragment(secondFragmet)
        adapter.addFragment(thirdFragmet)

        viewpager.adapter = adapter

        tabs.setupWithViewPager(viewpager)
        viewpager.setOnPageChangeListener(viewPagerPageChangeListener)

    }

    var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageSelected(position: Int) {

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == 1) {
                // last page. make button text to GOT IT
                main.setBackgroundColor(resources.getColor(R.color.white))
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

        }

        override fun onPageScrollStateChanged(arg0: Int) {

        }
    }
}
