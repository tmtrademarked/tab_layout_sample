package com.blueapron.tabsample;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        navView.findViewById(R.id.nav_frag_1).performClick();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int tabId = item.getItemId();
        switch (tabId) {
            case R.id.nav_frag_1:
                attachFragment(RedFragment.class.getName());
                break;
            case R.id.nav_frag_2:
                attachFragment(GreenFragment.class.getName());
                break;
            case R.id.nav_frag_3:
                attachFragment(BlueFragment.class.getName());
                break;
        }
        return true;
    }

    private void attachFragment(String fragmentName) {
        // Check to see if the fragment exists already. If not, create one as needed. If we
        // create a new fragment, add it to the fragment manager.
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentByTag(fragmentName);
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment == null) {
            fragment = Fragment.instantiate(this, fragmentName);
            transaction.add(R.id.content_main, fragment, fragmentName);
        }

        // Hide all existing fragments and show only the correct one.
        for (Fragment previous : getFragments(this)) {
            transaction.hide(previous);
        }
        transaction.show(fragment).commit();
    }

    private List<Fragment> getFragments(FragmentActivity activity) {
        FragmentManager manager = activity.getSupportFragmentManager();
        List<Fragment> fragments = manager.getFragments();
        return fragments != null ? fragments : Collections.EMPTY_LIST;
    }
}
