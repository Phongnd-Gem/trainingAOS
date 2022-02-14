package com.example.mycore.modules.main;

import com.example.mycore.common.core.FragmentView;
import com.example.mycore.databinding.FragmentMainBinding;

public class MainFragment extends FragmentView<MainFragmentModel, MainFragmentState, MainFragmentAction, FragmentMainBinding> {
    @Override
    protected void setup() {
        super.setup();
        getBinding().button.setOnClickListener(view1 -> {
            getViewModel().performAction(new MainFragmentAction(MainFragmentAction.ACTION_TEXT, "yeah right"));
        });
    }

    @Override
    public void onViewStateChanged(MainFragmentState mainFragmentState) {
        getBinding().textView.setText(mainFragmentState.text);
    }
}