package app.gkuroda.viewmodelsample.kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KViewModel : ViewModel() {

    var sampleValue = 0

    val sampleLiveDataValue: MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    // 複数のActivity・Fragmentで使うような動作をViewModelに乗せることができる
    fun plusOneValue() {
        sampleValue += 1
        sampleLiveDataValue.postValue(sampleValue)
    }

    fun minusOneValue() {
        sampleValue -= 1
        sampleLiveDataValue.postValue(sampleValue)
    }

    override fun onCleared() {
        super.onCleared()
        // 親のonDestroyとともに実行される
        // ここでRx購読の破棄などを行う
        sampleValue = 0
        sampleLiveDataValue.postValue(sampleValue)
    }
}