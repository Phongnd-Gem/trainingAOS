package com.example.mycore.common.core;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

public abstract class ViewModel<State, Action> extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<State> state = new MutableLiveData<>();

    public State getState() {
        return state.getValue();
    }

    protected void setState(State state) {
        this.state.setValue(state);
    }

    protected void observeState(LifecycleOwner owner, ViewStateObserver<State> observer) {
        state.observe(owner, observer::onViewStateChanged);
    }

    // For overridden by subclasses
    public void performAction(Action action) {}
}
