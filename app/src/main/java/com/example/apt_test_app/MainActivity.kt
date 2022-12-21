package com.example.apt_test_app

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adobe.adobepass.accessenabler.api.AccessEnabler
import com.adobe.adobepass.accessenabler.api.IAccessEnablerDelegate
import com.adobe.adobepass.accessenabler.api.callback.model.AdvancedStatus
import com.adobe.adobepass.accessenabler.models.Event
import com.adobe.adobepass.accessenabler.models.MetadataKey
import com.adobe.adobepass.accessenabler.models.MetadataStatus
import com.adobe.adobepass.accessenabler.models.Mvpd
import com.example.apt_test_app.ui.theme.APT_TEST_APPTheme
import java.util.ArrayList

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context: Context = getApplication()

        val adobePrimetimeService = AdobePrimetimeService(context)

        adobePrimetimeService.setRequestor()

        setContent {
            APT_TEST_APPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    APT_TEST_APPTheme {
        Greeting("Android")
    }
}

class AdobePrimetimeService (context: Context): IAccessEnablerDelegate {

    private val accessEnabler: AccessEnabler

    private val ss =
        ""
    private val environmentHost: String = "sp.auth-staging.adobe.com"
    private val requestorId: String = ""
    private val redirectUrl: String = ""

    init {
        AccessEnabler.setDelegate(this)
        accessEnabler = AccessEnabler.Factory.getInstance(
            context, environmentHost, ss, redirectUrl
        )
    }

    fun setRequestor () {
        accessEnabler.setRequestor(requestorId)
    }

    override fun setRequestorComplete(p0: Int) {
        Log.d(
            "TAG",
            "****************** setRequestorComplete ****************** >>> ${p0.toString()}"
        )
    }

    override fun setAuthenticationStatus(p0: Int, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun setToken(p0: String?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun tokenRequestFailed(p0: String?, p1: String?, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun selectedProvider(p0: Mvpd?) {
        TODO("Not yet implemented")
    }

    override fun displayProviderDialog(p0: ArrayList<Mvpd>?) {
        TODO("Not yet implemented")
    }

    override fun navigateToUrl(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun sendTrackingData(p0: Event?, p1: ArrayList<String>?) {
        TODO("Not yet implemented")
    }

    override fun setMetadataStatus(p0: MetadataKey?, p1: MetadataStatus?) {
        TODO("Not yet implemented")
    }

    override fun preauthorizedResources(p0: ArrayList<String>?) {
        TODO("Not yet implemented")
    }

    override fun status(p0: AdvancedStatus?) {
        TODO("Not yet implemented")
    }

}