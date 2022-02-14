package com.example.mycore.modules.main;

import com.example.mycore.common.core.Action;

public class MainActivityAction extends Action {
    public static final String ACTION_TEXT = "action_text";

    public String text;

    public MainActivityAction(String name) {
        super(name);
    }

    public static MainActivityAction createSetTextAction(String text) {
        MainActivityAction action = new MainActivityAction(ACTION_TEXT);
        action.text = text;
        return action;
    }
}
