package com.example.mvvmlogin.ui

import android.app.Activity
import android.content.Intent
import android.view.View

fun <A : Activity> Activity.startNewActivity(activity: Class<A>) {
    Intent(this, activity).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it);
    }
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enable: Boolean) {
    this.isEnabled = enable
    alpha = if (enable) 1f else .5f
}