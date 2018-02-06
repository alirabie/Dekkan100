package dekkan100.appsmatic.com.dekkan100.Fragments.StoreFragments.StoreTwoTabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.R;


public class AboutStore extends Fragment {

    TextView address,phoneMail,description,rateThisStore,send,noreviewsFlag;
    EditText reviewInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_store, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //setup items
        address=(TextView)view.findViewById(R.id.store_address);
        address.setTypeface(Home.face);
        phoneMail=(TextView)view.findViewById(R.id.store_phone_mail);
        phoneMail.setTypeface(Home.face);
        description=(TextView)view.findViewById(R.id.store_description);
        description.setTypeface(Home.face);
        rateThisStore=(TextView)view.findViewById(R.id.rate_sore_tv);
        rateThisStore.setTypeface(Home.face);
        send=(TextView)view.findViewById(R.id.send_btn);
        send.setTypeface(Home.face);
        noreviewsFlag=(TextView)view.findViewById(R.id.no_reviews_flag);
        noreviewsFlag.setTypeface(Home.face);


        reviewInput=(EditText)view.findViewById(R.id.store_review_input);
        reviewInput.setTypeface(Home.face);












    }
}
