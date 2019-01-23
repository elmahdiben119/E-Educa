package com.educa.ebenbrahimkbenazzou.educa;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyAccount extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        try {
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.pagerview);
            setupViewPager(viewPager);
            TabLayout tabs = view.findViewById(R.id.tablayout);
            tabs.setupWithViewPager(viewPager);
        } catch (Exception e) {
            Log.e("TAG", "OnCreateView : " + e.getMessage());
        }
        return view;
    }


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new TabFrag(), "الفلسفة");
        adapter.addFragment(new TabFrag(), "الإنجليزية");
        adapter.addFragment(new TabFrag(), "علوم الحياة و الأرض");
        adapter.addFragment(new TabFrag(), "الفيزياء و الكيمياء");
        adapter.addFragment(new TabFrag(), "الرياضيات");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}