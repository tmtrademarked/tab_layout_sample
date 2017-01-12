package com.blueapron.tabsample;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Base fragment to demonstrate tab problems.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, container, false /* attachToRoot */);
        view.setBackgroundColor(getColor());
        return view;
    }

    protected abstract @ColorInt int getColor();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("BaseFragment",
                "Hidden changed to " + hidden + " for fragment " + getClass().getSimpleName());
    }
}
