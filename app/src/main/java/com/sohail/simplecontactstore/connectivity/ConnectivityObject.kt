package com.sohail.simplecontactstore.connectivity

import android.content.Context
import android.net.ConnectivityManager

object ConnectivityObject {
    fun isConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}