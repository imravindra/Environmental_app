package com.example.richmindep.myapplication
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.content.ActivityNotFoundException
import android.net.Uri


class Pooling : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pooling)

        val butt= findViewById<Button>(R.id.ola)
        butt.setOnClickListener {
            val launchIntent = packageManager.getLaunchIntentForPackage("com.olacabs.customer")
            if (launchIntent != null) {
                startActivity(launchIntent)//null pointer check in case package name was not found
            } else {
                val uri = Uri.parse("market://details?id=com.olacabs.customer")
                val goToMarket = Intent(Intent.ACTION_VIEW, uri)

                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                try {
                    startActivity(goToMarket)
                } catch (e: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=com.olacabs.customer")))
                }

            }
        }
    }
}
