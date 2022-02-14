package com.example.mycore.modules.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mycore.common.core.ActivityView;
import com.example.mycore.databinding.ActivityHomeBinding;
import com.example.mycore.databinding.ActivityMainBinding;
import com.example.mycore.modules.main.MainActivityAction;
import com.example.mycore.modules.main.MainActivityModel;
import com.example.mycore.modules.main.MainActivityState;

public class HomeActivity extends ActivityView<MainActivityModel, MainActivityState, MainActivityAction, ActivityHomeBinding> {

    @Override
    protected void setup() {
        super.setup();

    }
}