package com.example.mycore.modules.main;

import com.example.mycore.common.core.State;

public class MainFragmentState extends State {
    public static final String TAG_TEXT = "tag_text";

    public String text;

    public MainFragmentState(String tag, String text) {
        super(tag);
        this.text = text;
    }
}
