package dekkan100.appsmatic.com.dekkan100.Fragments.OrdersFrags;

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
import dekkan100.appsmatic.com.dekkan100.Fragments.ProfileFrags.MessagesFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.ProfileFrags.ProfileFrag;
import dekkan100.appsmatic.com.dekkan100.R;

public class OrdersMasterFrag extends Fragment {

    ViewPager p;
    PagerSlidingTabStrip tabsStrip;
    CustomFragmentPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders_master, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Tab Layout With 2 fragments
        p=(ViewPager)view.findViewById(R.id.viewpager_orders);
        tabsStrip = (PagerSlidingTabStrip)view.findViewById(R.id.orders_master_tabs);
        tabsStrip.setTypeface(Home.face,3);
        adapter = new CustomFragmentPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new OrdersTab(), getResources().getString(R.string.orderstab));
        adapter.addFragment(new SubOrdersTab(),getResources().getString(R.string.suborderstab));
        p.setAdapter(adapter);
        tabsStrip.setViewPager(p);
        adapter.notifyDataSetChanged();
    }
}
