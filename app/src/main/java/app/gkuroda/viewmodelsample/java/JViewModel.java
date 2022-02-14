package app.gkuroda.viewmodelsample.java;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JViewModel extends ViewModel {

    private int sampleValue = 0;

    private MutableLiveData<Integer> sampleLiveDataValue;

    // 複数のActivity・Fragmentで使うような動作をViewModelに乗せることができる
    public void plusOneValue() {
        sampleValue = sampleValue + 1;
        sampleLiveDataValue.postValue(sampleValue);
    }

    public void minusOneValue() {
        sampleValue = sampleValue - 1;
        sampleLiveDataValue.postValue(sampleValue);
    }

    public int getSampleValue() {
        return sampleValue;
    }

    public MutableLiveData<Integer> getSampleLiveDataValue(){
        if (sampleLiveDataValue == null){
            sampleLiveDataValue = new MutableLiveData<Integer>();
        }
        return sampleLiveDataValue;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // 親のonDestroyとともに実行される
        // ここでRx購読の破棄などを行う
        sampleValue = 0;
        sampleLiveDataValue.postValue(sampleValue);
    }
}
