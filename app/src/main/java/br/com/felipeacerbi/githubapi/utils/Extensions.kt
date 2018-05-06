package br.com.felipeacerbi.githubapi.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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