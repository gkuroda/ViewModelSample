package app.gkuroda.viewmodelsample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import app.gkuroda.viewmodelsample.java.JSampleActivity
import app.gkuroda.viewmodelsample.kotlin.KSampleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.openJavaButton).setOnClickListener {
            startActivity(Intent(this, JSampleActivity::class.java))
        }

        findViewById<Button>(R.id.openKotlinButton).setOnClickListener {
            startActivity(Intent(this, KSampleActivity::class.java))
        }


    }
}