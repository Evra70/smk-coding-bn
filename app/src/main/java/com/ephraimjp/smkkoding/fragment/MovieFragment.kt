package com.ephraimjp.smkkoding.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ephraimjp.smkkoding.Movie
import com.ephraimjp.smkkoding.R
import com.ephraimjp.smkkoding.adapter.MovieAdapter
import com.ephraimjp.smkkoding.adapter.TvAdapter
import com.ephraimjp.smkkoding.connection.ConfigRetrofit
import com.ephraimjp.smkkoding.connection.MovieInterface
import com.ephraimjp.smkkoding.model.MovieModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movie.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)

        val category : String = arguments?.getString("CATEGORY").toString()
        if(category.equals("MOVIE")){
            getListMovie()
        }else if(category.equals("TV")){
            getListTv()
        }else{
            toast("Tidak Ada")
        }
        return rootView
    }

    private fun getListMovie(){
       val movieNowPlaying =
            ConfigRetrofit.retrofitConfig()
            .create(MovieInterface::class.java)
            .getListMovieNowPlaying("73016e0330e50ca8050f1d9662e50014","")

        movieNowPlaying
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                //sukses
                val list = response.movieResults
                val layoutmanager = LinearLayoutManager(activity)

                val adapter = MovieAdapter(list, activity!!.applicationContext)

                rootView.rv_movie.apply {
                    layoutManager = layoutmanager
                    setAdapter(adapter)
                }

            },{
                toast("Gagal saat Mengambil Data Tv")
            })
    }

    private fun getListTv(){
        val tvTopRated =
            ConfigRetrofit
            .retrofitConfig()
            .create(MovieInterface::class.java)
            .getListTvTopRated("73016e0330e50ca8050f1d9662e50014","")

        tvTopRated
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->

                val list = response.tvResults

                val layoutmanager = LinearLayoutManager(activity)

                val adapter = TvAdapter(list, activity!!.applicationContext)

                rootView.rv_movie.apply {
                    layoutManager = layoutmanager
                    setAdapter(adapter)
                }

            },{
                toast("Gagal saat Mengambil Data Tv")
            })
    }


}
