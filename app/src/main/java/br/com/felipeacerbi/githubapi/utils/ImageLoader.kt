package br.com.felipeacerbi.githubapi.utils

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageLoader {

    private fun isValidContextForGlide(context: Context?): Boolean {
        if (context == null) {
            return false
        }
        if (context is Activity) {
            val activity = context as Activity?
            if (activity!!.isDestroyed || activity.isFinishing) {
                return false
            }
        }
        return true
    }

    fun loadWithGlide(context: Context, photoPath: String, errorImage: Int, intoView: ImageView) {
        if (isValidContextForGlide(context)) {
            Glide.with(context)
                    .load(photoPath)
                    .apply(RequestOptions.centerCropTransform())
                    .apply(RequestOptions.errorOf(errorImage))
                    .into(intoView)
        }
    }
}