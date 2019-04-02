package com.lnsergioantonio.kinedutest.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lnsergioantonio.kinedutest.R;
import com.lnsergioantonio.kinedutest.ui.home.catalog.CatalogFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Spinner filterMonth;
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_catalog:
                    viewPager.setCurrentItem(0);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        navigation = findViewById(R.id.navigation);
        filterMonth = findViewById(R.id.activity_main_spinner);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount()-1);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_catalog);

        filterMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arrayMonths = getResources().getStringArray(R.array.monthValues);
                String value = arrayMonths[position];
                Log.d("selected",value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static class FragmentAdapter extends FragmentPagerAdapter{

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return CatalogFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
