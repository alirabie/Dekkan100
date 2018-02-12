package dekkan100.appsmatic.com.dekkan100.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.R;

public class AboutApp extends Fragment {

    private String copyright ;
    private EditText usernameInput,emailInput,msgInput;
    private TextView knowus_tv , msgUs_tv , contactUs_tv , send_btn ,desc_tv;
    private ImageView fb,tw,g,insta;
    private TextView copyright_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_app, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        copyright=getResources().getString(R.string.copyright)+" \u00a9 2018 "+getResources().getString(R.string.app_name);
        copyright_tv=(TextView)view.findViewById(R.id.copyrigt_tv);
        copyright_tv.setText(copyright);

        //setup items
        usernameInput =(EditText)view.findViewById(R.id.input_username_about);
        usernameInput.setTypeface(Home.face);
        emailInput =(EditText)view.findViewById(R.id.input_email_anout);
        emailInput.setTypeface(Home.face);
        msgInput =(EditText)view.findViewById(R.id.input_message_about);
        msgInput.setTypeface(Home.face);
        knowus_tv=(TextView)view.findViewById(R.id.know_us_tv);
        knowus_tv.setTypeface(Home.face);
        msgUs_tv=(TextView)view.findViewById(R.id.mesg_us_tv);
        msgUs_tv.setTypeface(Home.face);
        contactUs_tv=(TextView)view.findViewById(R.id.contact_us_tv);
        contactUs_tv.setTypeface(Home.face);
        send_btn=(TextView)view.findViewById(R.id.send_btn_about);
        send_btn.setTypeface(Home.face);
        desc_tv=(TextView)view.findViewById(R.id.app_desc_tv);
        desc_tv.setTypeface(Home.face);
        fb=(ImageView)view.findViewById(R.id.fb_btn);
        tw=(ImageView)view.findViewById(R.id.tw_btn);
        g=(ImageView)view.findViewById(R.id.g_btn);
        insta=(ImageView)view.findViewById(R.id.insta_btn);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(fb, getContext());
            }
        });
        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(tw,getContext());
                Intent intent = null;
                try {
                    // get the Twitter app if possible
                    getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
                }

                startActivity(intent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(insta,getContext());
                Uri uri = Uri.parse("https://www.instagram.com/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/")));
                }

            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(g, getContext());
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setClassName("com.google.android.apps.plus",
                            "com.google.android.apps.plus.phone.UrlGatewayActivity");
                    intent.putExtra("customAppUri","test");
                    startActivity(intent);
                } catch(ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/test/posts")));
                }
            }
        });




    }
}
