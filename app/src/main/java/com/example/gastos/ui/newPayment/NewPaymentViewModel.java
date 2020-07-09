package com.example.gastos.ui.newPayment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewPaymentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewPaymentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is nuevo Pago fragment");
    }





    public LiveData<String> getText() {
        return mText;
    }
}