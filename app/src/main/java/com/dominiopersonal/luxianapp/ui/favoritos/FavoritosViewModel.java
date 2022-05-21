package com.dominiopersonal.luxianapp.ui.favoritos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FavoritosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el fragmento de 'favoritos'");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
