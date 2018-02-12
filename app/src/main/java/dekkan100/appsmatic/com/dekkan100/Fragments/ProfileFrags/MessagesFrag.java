package dekkan100.appsmatic.com.dekkan100.Fragments.ProfileFrags;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.R;


public class MessagesFrag extends Fragment {

    TextView emptyFrag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emptyFrag=(TextView)view.findViewById(R.id.empty_flag);
        emptyFrag.setTypeface(Home.face);
    }
}
