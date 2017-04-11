package com.example.xoapit.piratenews.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.xoapit.piratenews.R;

public class CategoryFragment extends Fragment {
    public String url = "";
    public String[] tabTitles = new String[]{"Tất cả", "Nổi bật"};

    public CategoryFragment(String category) {
        switch (category) {
            case "trangchu":
                url = "http://vnexpress.net/rss/tin-moi-nhat.rss";
                break;
            case "thoisu":
                url = "http://vnexpress.net/rss/thoi-su.rss";
                break;
            case "thegioi":
                url = "http://vnexpress.net/rss/the-gioi.rss";
                break;
            case "giaitri":
                url = "http://vnexpress.net/rss/giai-tri.rss";
                break;
            case "phapluat":
                url = "http://vnexpress.net/rss/phap-luat.rss";
                break;
            case "thethao":
                url = "http://vnexpress.net/rss/the-thao.rss";
                break;
            case "giaoduc":
                url = "http://vnexpress.net/rss/giao-duc.rss";
                break;
            case "suckhoe":
                url = "http://vnexpress.net/rss/suc-khoe.rss";
                break;
            case "tamsu":
                url = "http://vnexpress.net/rss/tam-su.rss";
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_category, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        // tabLayout.addTab(tabLayout.newTab().setText("Tất cả"));
        //tabLayout.addTab(tabLayout.newTab().setText("Nổi bật"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }


    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int mNumOfTabs) {
            super(fm);
            this.mNumOfTabs = mNumOfTabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ArticleFragment(url, 2);
                case 1:
                    return new ArticleFragment(url, 1);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }
}
