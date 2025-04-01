package com.bitcode.a17_02_25_webservicesdemo_version2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            var url = URL("https://reqres.in/api/users?page=2")
            var httpsURLConnection = url.openConnection() as HttpsURLConnection
            httpsURLConnection.connect()

            var inStream = httpsURLConnection.inputStream

            var inputStreamReader = InputStreamReader(inStream)
            var apiResponse = Gson().fromJson(inputStreamReader, APIResponse::class.java)

            Log.e("tag", "${apiResponse.page}")

            for (eachUser in apiResponse.users) {
                Log.e("tag", "${eachUser.id} -- ${eachUser.firstName} -- ${eachUser.lastName}")
            }
        }
    }
}