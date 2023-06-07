package com.example.okeyplay.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> email;

    public ProfileViewModel() {
        email = new MutableLiveData<>();
        email.setValue("");

    }

    public LiveData<String> getEmail() {
        return email;
    }


}