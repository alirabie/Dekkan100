package dekkan100.appsmatic.com.dekkan100.Fragments.SignupFrags;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.Activities.Login;
import dekkan100.appsmatic.com.dekkan100.Activities.Signup;
import dekkan100.appsmatic.com.dekkan100.R;

public class ActiveAccountFactor2 extends Fragment {


    private TextView pleaseinsertcode_tv,verify_btn;
    private EditText codeInput;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active_account_factor2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pleaseinsertcode_tv=(TextView)view.findViewById(R.id.pleaseinsertcode_tv);
        pleaseinsertcode_tv.setTypeface(Signup.face);
        verify_btn=(TextView)view.findViewById(R.id.ver_btn);
        verify_btn.setTypeface(Signup.face);
        codeInput=(EditText)view.findViewById(R.id.ver_code_input);
        codeInput.setTypeface(Signup.face);


        verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(verify_btn,getContext());
                startActivity(new Intent(getContext(), Login.class));
                getActivity().finish();
            }
        });



    }
}
