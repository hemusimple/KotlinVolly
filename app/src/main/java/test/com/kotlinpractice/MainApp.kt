package test.com.kotlinpractice

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MainApp : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val requestQue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    fun <T> addToRequestQueue(request: Request<T>) {
        requestQue?.add(request)
    }

    fun cancelPendingRequests(tag: Any) {
        if (requestQue != null) {
            requestQue!!.cancelAll(tag)
        }
    }

    companion object {
        @get:Synchronized
        var instance: MainApp? = null
            private set
    }
}