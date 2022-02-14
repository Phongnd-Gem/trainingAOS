package com.example.mycore.common.core;

public interface ViewStateObserver<State> {
    default void onViewStateChanged(State state) {}
}
