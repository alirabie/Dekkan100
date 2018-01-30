package dekkan100.appsmatic.com.dekkan100.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import dekkan100.appsmatic.com.dekkan100.R;

public class Login extends AppCompatActivity {

    private TextView tittle_tv,forgetpass_btn,forgetuser_btn,donthaveaccount_tv,registernow_btn,skipthis_btn,codemessage_tv,login_btn;
    private EditText username_input,password_input;
    private Typeface face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //Check Os Ver For Set Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        //font style
        face= Typeface.createFromAsset(getAssets(), "arabic.ttf");
        //setup items
        tittle_tv=(TextView)findViewById(R.id.logintittle);
        forgetpass_btn=(TextView)findViewById(R.id.forgetpass);
        forgetuser_btn=(TextView)findViewById(R.id.forgetuser);
        donthaveaccount_tv=(TextView)findViewById(R.id.donthaveaccount_tv);
        registernow_btn=(TextView)findViewById(R.id.registerbtn);
        skipthis_btn=(TextView)findViewById(R.id.skipp_btn);
        codemessage_tv=(TextView)findViewById(R.id.message);
        codemessage_tv.setVisibility(View.INVISIBLE);
        login_btn=(TextView)findViewById(R.id.loginbtn);
        username_input=(EditText)findViewById(R.id.username_input);
        password_input=(EditText)findViewById(R.id.password_input);
        //setup typeface
        tittle_tv.setTypeface(face);
        forgetuser_btn.setTypeface(face);
        forgetpass_btn.setTypeface(face);
        donthaveaccount_tv.setTypeface(face);
        registernow_btn.setTypeface(face);
        skipthis_btn.setTypeface(face);
        codemessage_tv.setTypeface(face);
        login_btn.setTypeface(face);
        username_input.setTypeface(face);
        password_input.setTypeface(face);



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(login_btn, Login.this);
                startActivity(new Intent(Login.this, Home.class));
                Login.this.finish();
            }
        });


        registernow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(registernow_btn,Login.this);
                startActivity(new Intent(Login.this,Signup.class));
                Login.this.finish();
            }
        });









    }
}
