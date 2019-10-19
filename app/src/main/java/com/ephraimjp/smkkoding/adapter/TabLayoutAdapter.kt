package com.ephraimjp.smkkoding.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ephraimjp.smkkoding.fragment.MovieFragment

class TabLayoutAdapter
    (fm: FragmentManager, context: Context) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val movieFragment = MovieFragment()
        val bundle = Bundle()

        when (position) {
            0 -> bundle.putString("CATEGORY", "MOVIE")
            1 -> bundle.putString("CATEGORY", "TV")
        }

        movieFragment.arguments = bundle

        return movieFragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "MOVIE"
            1 -> "TV"
            else -> "BELUM ADA"
        }
    }

}