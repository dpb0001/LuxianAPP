package com.dominiopersonal.luxianapp.ui.busqueda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BusquedaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BusquedaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Te encuentras en busquedas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}