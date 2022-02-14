package app.gkuroda.viewmodelsample.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.gkuroda.viewmodelsample.R
import app.gkuroda.viewmodelsample.kotlin.KViewModel

class BFragment : Fragment() {
    private lateinit var mViewModel: KViewModel
    private lateinit var mPlusButton: Button
    private lateinit var mMinusButton: Button
    private lateinit var mTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ViewModelオブジェクトの生成
        // 子側でViewModelオブジェクトを生成する場合、ViewModelProviderには親のActivity・Fragmentインスタンスを渡す必要がある
        // 子側でViewModelProvider(this)をしてしまうと、親と共有されていない新しいViewModelが生成されてしまう
        mViewModel = ViewModelProvider(requireActivity()).get(KViewModel::class.java)
        return inflater.inflate(R.layout.fragment_b_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPlusButton = view.findViewById(R.id.fragmentBPlusButton)
        mMinusButton = view.findViewById(R.id.fragmentBMinusButton)
        mTextView = view.findViewById(R.id.fragmentBTextView)

        mPlusButton.setOnClickListener {
            mViewModel.plusOneValue()
            setSampleText()
        }

        mMinusButton.setOnClickListener {
            mViewModel.minusOneValue()
            setSampleText()
        }
    }

    override fun onResume() {
        super.onResume()
        setSampleText()
    }

    private fun setSampleText() {
        val newValue = mViewModel.sampleValue.toString()
        mTextView.text = newValue
    }
}
