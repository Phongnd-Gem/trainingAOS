package com.example.mycore.common.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

public abstract class FragmentView<VM extends ViewModel<State, A>, State, A extends Action, Binding extends ViewBinding> extends Fragment implements ViewStateObserver<State> {

    private Class<VM> viewModelClass;

    protected VM getViewModel() {
        return new ViewModelProvider(this).get(viewModelClass);
    }

    private Binding binding;
    public Binding getBinding() {
        if (binding == null) {
            binding = CoreUtils.getViewBinding(getClass(), getLayoutInflater(), 3);
        }
        return binding;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Using reflection, so cache it
        viewModelClass = CoreUtils.getGenericSuperclass(getClass(), 0);

        setup();
        getViewModel().observeState(getViewLifecycleOwner(), this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getBinding().getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // For overridden by subclasses
    protected void setup() {}
}
