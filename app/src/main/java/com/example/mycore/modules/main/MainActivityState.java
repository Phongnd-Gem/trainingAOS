package com.example.mycore.modules.main;

import com.example.mycore.common.core.State;

public class MainActivityState extends State {
    public static final String TAG_TEXT = "name_text";

    public String text;

    public MainActivityState(String tag, String text) {
        super(tag);
        this.text = text;
    }
}
