package app.gkuroda.viewmodelsample.java.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import app.gkuroda.viewmodelsample.R;
import app.gkuroda.viewmodelsample.java.JViewModel;

public class BFragment extends Fragment {

    JViewModel mViewModel;

    Button mPlusButton;
    Button mMinusButton;
    TextView mTextView;
    Button mBButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // ViewModelオブジェクトの生成
        // 子側でViewModelオブジェクトを生成する場合、ViewModelProviderには親のActivity・Fragmentインスタンスを渡す必要がある
        // 子側でViewModelProvider(this)をしてしまうと、親と共有されていない新しいViewModelが生成されてしまう
        mViewModel = new ViewModelProvider(requireActivity()).get(JViewModel.class);

        return inflater.inflate(R.layout.fragment_b_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPlusButton = view.findViewById(R.id.fragmentBPlusButton);
        mMinusButton = view.findViewById(R.id.fragmentBMinusButton);
        mTextView = view.findViewById(R.id.fragmentBTextView);

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.plusOneValue();
                setSampleText();
            }
        });

        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.minusOneValue();
                setSampleText();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        setSampleText();
    }

    private void setSampleText() {
        String newValue = String.valueOf(mViewModel.getSampleValue());
        mTextView.setText(newValue);
    }
}
