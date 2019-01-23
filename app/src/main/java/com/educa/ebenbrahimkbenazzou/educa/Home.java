package com.educa.ebenbrahimkbenazzou.educa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class Home extends AppCompatActivity {
    ViewPager pager;
    MenuItem prevMenuItem;
    BottomNavigationView navigation;
    MyAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        try {
            pager = findViewById(R.id.pager);
            navigation = findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.user:
                            pager.setCurrentItem(0);
                            return true;
                        case R.id.questions:
                            pager.setCurrentItem(1);
                            return true;
                        case R.id.bell:
                            pager.setCurrentItem(2);
                            return true;
                        case R.id.cours:
                            pager.setCurrentItem(3);
                            return true;
                    }
                    return false;
                }
            });
            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    if (prevMenuItem != null) {
                        prevMenuItem.setChecked(false);
                    } else {
                        navigation.getMenu().getItem(0).setChecked(false);
                    }
                    // Log.d("page", "onPageSelected: " + position);
                    navigation.getMenu().getItem(position).setChecked(true);
                    prevMenuItem = navigation.getMenu().getItem(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
            setupViewPager(pager);
        } catch (Exception e) {
            Log.e("TAG", "Error : " + e.getMessage());
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        account = new MyAccount();
        adapter.addFragment(account);
        adapter.addFragment(new QandA());
        adapter.addFragment(new Fragment());
        adapter.addFragment(new Matieres());
        viewPager.setAdapter(adapter);
    }
}
