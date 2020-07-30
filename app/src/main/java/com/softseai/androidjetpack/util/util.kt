package com.softseai.androidjetpack.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.softseai.androidjetpack.R

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher)
//    Glide.with(context)
//        .setDefaultRequestOptions(options)
//        .load(uri)
//        .into(this)

    //Faded Animation
    Glide.with(this).load(uri)
        .transition(DrawableTransitionOptions.withCrossFade())
        .thumbnail(
            Glide.with(this)
                .load(R.mipmap.ic_launcher)
                .apply(options)
        )
        .apply(options)
//        .listener(MyImageRequestListener(this))
        .into(this)
}

@BindingAdapter("android:imageUrl")
fun loadImage(view: ImageView, url: String?){
    view.loadImage(url, getProgressDrawable(view.context))
}


//listener if we want to see message about loading image ... MainActivity
//class MyImageRequestListener(private val callback: Callback? = null)
//    : RequestListener<Drawable> {
//    constructor(callback: ImageView) : this()
//
//    interface Callback {
//        fun onFailure(message: String?)
//        fun onSuccess(dataSource: String)
//    }
//
//    override fun onLoadFailed(
//        e: GlideException?,
//        model: Any?,
//        target: com.bumptech.glide.request.target.Target<Drawable>?,
//        isFirstResource: Boolean
//    ): Boolean {
//
//        callback?.onFailure(e?.message)
//        return false
//    }
//
//    override fun onResourceReady(
//        resource: Drawable?,
//        model: Any?,
//        target: Target<Drawable>?,
//        dataSource: DataSource?,
//        isFirstResource: Boolean
//    ): Boolean {
//
//        callback?.onSuccess(dataSource.toString())
//        target?.onResourceReady(resource!!,
//            DrawableCrossFadeTransition(1000, isFirstResource)
//        )
//        return true
//    }
//}