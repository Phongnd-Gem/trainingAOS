package com.example.mycore.modules.main;

import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.os.Handler;

import com.example.mycore.common.core.ActivityView;
import com.example.mycore.databinding.ActivityMainBinding;
import com.example.mycore.models.UserProfile;
import com.example.mycore.modules.home.HomeActivity;
import com.example.mycore.modules.net.ApiService;
import com.example.mycore.modules.trailer.TrailerActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ActivityView<MainActivityModel, MainActivityState, MainActivityAction, ActivityMainBinding> {

    @Override
    protected void setup() {
        super.setup();
//        getBinding().button.setOnClickListener(view -> {
//            getViewModel().performAction(MainActivityAction.createSetTextAction("Test"));
//        });
//
//        getBinding().button2.setOnClickListener(view -> {
//            getViewModel().performAction(MainActivityAction.createSetTextAction("Test 1"));
//        });

//        ApiService.githubAPI().getInfo("luongdx").enqueue(new Callback<UserProfile>() {
//            @Override
//            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
//                Log.d("AAA", response.body().login);
//            }
//
//            @Override
//            public void onFailure(Call<UserProfile> call, Throwable t) {
//                Log.d("AAA", t.getMessage());
//            }
//        });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 2s = 2000ms
                Intent intent = new Intent(MainActivity.this, TrailerActivity.class);

                startActivity(intent);
            }
        }, 2000);
    }

    @Override
    public void onViewStateChanged(MainActivityState mainActivityState) {
//        getBinding().textView.setText(mainActivityState.text);
    }
}