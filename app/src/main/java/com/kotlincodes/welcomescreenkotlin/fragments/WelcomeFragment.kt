package com.shrishtionline.qikpay.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.TextureView
import android.widget.TextView
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.ImageView
import com.kotlincodes.welcomescreenkotlin.R


class WelcomeFragment : Fragment() {
    companion object {
        fun newInstance(title: String,descri:String ,imageId :Int): WelcomeFragment {

            val f = WelcomeFragment()

            val bdl = Bundle(1)

            bdl.putString("title", title)
            bdl.putString("content",descri)
            bdl.putInt("image",imageId)

            f.setArguments(bdl)

            return f

        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View? = inflater.inflate(R.layout.fragment_welcome, container, false);

        val textViewTitle: TextView = view!!.findViewById(R.id.txt_heading)
        val textDescr:TextView=view.findViewById(R.id.txt_descri)
        val imageView:ImageView=view.findViewById(R.id.imageview_welcom)

        textViewTitle.text =  arguments!!.getString("title")
        textDescr.text=arguments!!.getString("content")
        imageView.setImageResource(arguments!!.getInt("image"))

        return view
    }


}