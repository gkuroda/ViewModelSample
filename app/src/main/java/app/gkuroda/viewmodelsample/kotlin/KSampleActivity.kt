package app.gkuroda.viewmodelsample.kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.gkuroda.viewmodelsample.R
import app.gkuroda.viewmodelsample.kotlin.fragment.AFragment

class KSampleActivity : AppCompatActivity() {

    private lateinit var mViewModel: KViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample_activity)

        // ViewModelオブジェクトの生成
        mViewModel = ViewModelProvider(this).get(KViewModel::class.java)

        //ライブデータの購読開始
        val sampleObserver: Observer<Int> =
            Observer { newValue ->
                val textView = findViewById<TextView>(R.id.valueText)
                textView.text = newValue.toString()
            }

        mViewModel.sampleLiveDataValue.observe(this, sampleObserver)

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.container, AFragment())
            .commit()
    }


}