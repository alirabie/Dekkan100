package dekkan100.appsmatic.com.dekkan100.Fragments.SignupFrags;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.Activities.Login;
import dekkan100.appsmatic.com.dekkan100.Activities.Signup;
import dekkan100.appsmatic.com.dekkan100.Activities.Splash;
import dekkan100.appsmatic.com.dekkan100.Fragments.Settings;
import dekkan100.appsmatic.com.dekkan100.R;

public class SignupFactor1 extends Fragment {
    private EditText username_input,email_input,phone_input,password,repassword;
    private TextView register_btn,haveaccount_tv,login_btn,skip_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_factor1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        username_input=(EditText)view.findViewById(R.id.reg_username_input);
        username_input.setTypeface(Signup.face);
        email_input=(EditText)view.findViewById(R.id.reg_email_input);
        email_input.setTypeface(Signup.face);
        phone_input=(EditText)view.findViewById(R.id.reg_phone_input);
        phone_input.setTypeface(Signup.face);
        password=(EditText)view.findViewById(R.id.reg_password_input);
        password.setTypeface(Signup.face);
        repassword=(EditText)view.findViewById(R.id.reg_repassword_input);
        repassword.setTypeface(Signup.face);
        register_btn=(TextView)view.findViewById(R.id.reg_btn);
        register_btn.setTypeface(Signup.face);
        haveaccount_tv=(TextView)view.findViewById(R.id.reg_haveaccount);
        haveaccount_tv.setTypeface(Signup.face);
        login_btn=(TextView)view.findViewById(R.id.reg_signin);
        login_btn.setTypeface(Signup.face);
        skip_btn=(TextView)view.findViewById(R.id.skipp_btn);
        skip_btn.setTypeface(Signup.face);




        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(register_btn,getContext());
                ActiveAccountFactor2 activeAccountFactor2=new ActiveAccountFactor2();
                //Send reg data to factor 2
                Bundle bundle=new Bundle();
                bundle.putString("username",username_input.getText().toString());
                bundle.putString("email",email_input.getText().toString());
                bundle.putString("phone",phone_input.getText().toString());
                bundle.putString("password",password.getText().toString());
                activeAccountFactor2.setArguments(bundle);
                android.support.v4.app.FragmentManager fragmentManager = ((FragmentActivity)getContext()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.signup_contaner, activeAccountFactor2);
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                Signup.tittle.setText(getResources().getString(R.string.activeaccount));
            }
        });



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(login_btn,getContext());
                startActivity(new Intent(getContext(), Login.class));
                getActivity().finish();
            }
        });





        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(skip_btn,getContext());
                startActivity(new Intent(getContext(), Splash.class));
                getActivity().finish();

            }
        });





    }
}
