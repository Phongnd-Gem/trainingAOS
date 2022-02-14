package com.example.mycore.modules.main;

import com.example.mycore.common.core.Action;

public class MainFragmentAction extends Action {
    public static final String ACTION_TEXT = "action_text";

    public String text;

    public MainFragmentAction(String name, String text) {
        super(name);
        this.text = text;
    }
}
