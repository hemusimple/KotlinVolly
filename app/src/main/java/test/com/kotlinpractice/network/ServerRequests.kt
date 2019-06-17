package test.com.kotlinpractice.network

import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject
import test.com.kotlinpractice.MainApp

class ServerRequests {

    interface  GetApiResponseListner{
        fun  onSuccess(response:String)
        fun  onFailur(response:String?)
    }

    companion object {
        val BASEURL = "http://192.168.3.103:8082"
        fun get(pathEndpoint: String, getApiResponseListner: GetApiResponseListner) {
            val jsonObjReq = object : JsonObjectRequest(Method.GET, BASEURL + pathEndpoint, null,
                Response.Listener<JSONObject> { response ->
                    getApiResponseListner.onSuccess(response.toString())
                },
                Response.ErrorListener { error ->
                    getApiResponseListner.onFailur(null)
                }) {
            }

            MainApp.instance?.addToRequestQueue(jsonObjReq)
        }
    }

}