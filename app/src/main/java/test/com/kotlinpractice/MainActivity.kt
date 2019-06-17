package test.com.kotlinpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import test.com.kotlinpractice.network.ServerRequests

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllRecords()
    }

    fun getAllRecords() {
        ServerRequests.get("/getAllRecords", object : ServerRequests.GetApiResponseListner {
            override fun onSuccess(response: String) {
                Toast.makeText(this@MainActivity, response, Toast.LENGTH_LONG).show()
            }

            override fun onFailur(response: String?) {
                Toast.makeText(this@MainActivity, response, Toast.LENGTH_LONG).show()
            }
        })
    }
}