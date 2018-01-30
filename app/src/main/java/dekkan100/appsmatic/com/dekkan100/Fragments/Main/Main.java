package dekkan100.appsmatic.com.dekkan100.Fragments.Main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.Adaptors.CustomFragmentPagerAdapter;
import dekkan100.appsmatic.com.dekkan100.Fragments.Main.MainTabs.CategoriesFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.Main.MainTabs.SaleFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.Main.MainTabs.VendorsFrag;
import dekkan100.appsmatic.com.dekkan100.R;


public class Main extends Fragment {

    ViewPager p;
    PagerSlidingTabStrip tabsStrip;
    CustomFragmentPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Tab Layout With 3 fragments
        p=(ViewPager)view.findViewById(R.id.viewpager_main);
        tabsStrip = (PagerSlidingTabStrip)view.findViewById(R.id.main_tabs);
        tabsStrip.setTypeface(Home.face,3);
        adapter = new CustomFragmentPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new CategoriesFrag(),getResources().getString(R.string.cate));
        adapter.addFragment(new VendorsFrag(), getResources().getString(R.string.vindors));
        adapter.addFragment(new SaleFrag(), getResources().getString(R.string.sale));
        p.setAdapter(adapter);
        tabsStrip.setViewPager(p);
        adapter.notifyDataSetChanged();
    }
}
