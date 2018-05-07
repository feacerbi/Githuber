package br.com.felipeacerbi.githubapi.utils

import android.app.Activity
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.reflect.KClass

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { action(it) } })
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun <T : Any> Fragment.launchActivityWithExtras(
        clazz: KClass<T>,
        identifiers: Array<String>,
        extras: Array<Any>,
        forResult: Boolean = false,
        resultIdentifier: Int = -1) {

    val intent = Intent(activity, clazz.java)

    for (extra in extras) {
        if (extra is String) {
            intent.putExtra(identifiers[extras.indexOf(extra)], extra)
        } else if (extra is Int) {
            intent.putExtra(identifiers[extras.indexOf(extra)], extra)
        } else if (extra is Boolean) {
            intent.putExtra(identifiers[extras.indexOf(extra)], extra)
        } else if (extra is Parcelable) {
            intent.putExtra(identifiers[extras.indexOf(extra)], extra)
        }
    }

    if(forResult) {
        startActivityForResult(intent, resultIdentifier)
    } else {
        startActivity(intent)
    }
}

fun AppCompatActivity.transact(fragment: Fragment, container: Int, tag: String, bundle: Bundle? = null) {
    val transaction = supportFragmentManager.beginTransaction()

    val addFragment = supportFragmentManager.findFragmentByTag(tag) ?: fragment

    if(bundle != null) addFragment.arguments = bundle

    transaction.replace(container, addFragment, tag)
    transaction.commit()
}

fun ImageView.loadGlide(uri: String, error: Int, placeHolder: Int) {
    if (context != null) {
        return
    }
    if (context is Activity) {
        val activity = context as Activity?
        if (activity!!.isDestroyed || activity.isFinishing) {
            return
        }
    }

    Glide.with(context)
            .load(uri)
            .apply(RequestOptions
                    .centerCropTransform()
                    .error(error)
                    .placeholder(placeHolder)
            )
            .into(this)
}