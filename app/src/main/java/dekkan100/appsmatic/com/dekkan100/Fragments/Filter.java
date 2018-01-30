package dekkan100.appsmatic.com.dekkan100.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.R;

public class Filter extends Fragment {

    BetterSpinner citySp,categorySp,mostReqSp,priceSp,discountedSp;
    TextView filterBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filterBtn=(TextView)view.findViewById(R.id.filter_btn);
        filterBtn.setTypeface(Home.face);
        citySp=(BetterSpinner)view.findViewById(R.id.filter_city_sp);
        citySp.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1));
        citySp.setTypeface(Home.face);
        categorySp=(BetterSpinner)view.findViewById(R.id.filter_category_sp);
        categorySp.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1));
        categorySp.setTypeface(Home.face);
        mostReqSp=(BetterSpinner)view.findViewById(R.id.filter_mostrequsted_sp);
        mostReqSp.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1));
        mostReqSp.setTypeface(Home.face);
        priceSp=(BetterSpinner)view.findViewById(R.id.filter_price_sp);
        priceSp.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1));
        priceSp.setTypeface(Home.face);
        discountedSp=(BetterSpinner)view.findViewById(R.id.filter_discounted_sp);
        discountedSp.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1));
        discountedSp.setTypeface(Home.face);
    }
}
