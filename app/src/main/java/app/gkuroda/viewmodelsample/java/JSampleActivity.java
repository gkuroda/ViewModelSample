package app.gkuroda.viewmodelsample.java;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import app.gkuroda.viewmodelsample.R;
import app.gkuroda.viewmodelsample.java.fragment.AFragment;

public class JSampleActivity extends AppCompatActivity {

    JViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);

        // ViewModelオブジェクトの生成
        mViewModel = new ViewModelProvider(this).get(JViewModel.class);

        //ライブデータの購読開始
        final Observer<Integer> sampleObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer newValue) {
                TextView textView = findViewById(R.id.valueText);
                textView.setText(String.valueOf(newValue));
            }
        };

        mViewModel.getSampleLiveDataValue().observe(this, sampleObserver);

        AFragment fragment = new AFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.add(R.id.container, fragment);
        transaction.commit();

    }
}
