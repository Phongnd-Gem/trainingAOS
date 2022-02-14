package com.example.mycore.common.core;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

public abstract class ActivityView<VM extends ViewModel<S, A>, S extends State, A extends Action, Binding extends ViewBinding> extends AppCompatActivity implements ViewStateObserver<S> {

    private Class<VM> viewModelClass;

    protected VM getViewModel() {
        return new ViewModelProvider(this).get(viewModelClass);
    }

    private Binding binding;
    protected Binding getBinding() {
        if (binding == null) {
            binding = CoreUtils.getViewBinding(getClass(), getLayoutInflater(), 3);
        }
        return binding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Using reflection, so cache it
        viewModelClass = CoreUtils.getGenericSuperclass(getClass(), 0);

        setContentView(getBinding().getRoot());
        setup();
        getViewModel().observeState(this, this);
    }

    // For overridden by subclasses
    protected void setup() {}
}
