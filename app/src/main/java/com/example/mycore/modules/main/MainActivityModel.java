package com.example.mycore.modules.main;

import com.example.mycore.common.core.ViewModel;

public class MainActivityModel extends ViewModel<MainActivityState, MainActivityAction> {
    @Override
    public void performAction(MainActivityAction mainActivityAction) {
        super.performAction(mainActivityAction);
        switch (mainActivityAction.getAction()) {
            case MainActivityAction.ACTION_TEXT:
                if ("Test".equalsIgnoreCase(mainActivityAction.text)) {
                    setState(new MainActivityState(MainActivityState.TAG_TEXT, "Test 2"));
                } else {
                    setState(new MainActivityState(MainActivityState.TAG_TEXT, mainActivityAction.text));
                }
                break;
        }
    }
}
