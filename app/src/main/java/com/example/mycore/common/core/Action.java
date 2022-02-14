package com.example.mycore.common.core;

public abstract class Action extends android.content.Intent {
    public Action(String name) {
        super(name);
    }
}
