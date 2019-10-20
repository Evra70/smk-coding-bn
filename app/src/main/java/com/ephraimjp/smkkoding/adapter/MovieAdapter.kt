package com.ephraimjp.smkkoding.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.activity.DetailMovieActivity
import com.ephraimjp.smkkoding.model.MovieResultsItem
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class MovieAdapter(
    val list: List<MovieResultsItem?>?,
    val context: Context
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    lateinit var itemView: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, list?.get(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(context: Context, movieModel: MovieResultsItem?) {
            Log.d("ADAPTER", movieModel.toString())

            itemView.film_title.text = movieModel?.title

            Glide.with(context).load("https://image.tmdb.org/t/p/w500" + movieModel?.posterPath).into(itemView.film_poster)

            itemView.onClick {
                itemView.context.startActivity(
                    itemView.context.intentFor<DetailMovieActivity>("movie" to movieModel)
                )
            }
        }

    }


}