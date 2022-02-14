package com.example.mycore.modules.main;

import com.example.mycore.common.core.ViewModel;

public class MainFragmentModel extends ViewModel<MainFragmentState, MainFragmentAction> {
    @Override
    public void performAction(MainFragmentAction mainFragmentAction) {
        super.performAction(mainFragmentAction);
        setState(new MainFragmentState(MainFragmentState.TAG_TEXT, mainFragmentAction.text));
    }
}
