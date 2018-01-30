package dekkan100.appsmatic.com.dekkan100.Activities;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import dekkan100.appsmatic.com.dekkan100.Fragments.SignupFrags.SignupFactor1;
import dekkan100.appsmatic.com.dekkan100.R;

public class Signup extends AppCompatActivity {

    public static TextView tittle;
    public static Typeface face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_signup);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //Check Os Ver For Set Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
         //font style
        face= Typeface.createFromAsset(getAssets(), "arabic.ttf");
        tittle=(TextView)findViewById(R.id.signup_tittle);
        tittle.setTypeface(face);
        SignupFactor1 signupFactor1=new SignupFactor1();
        android.support.v4.app.FragmentManager fragmentManager = (Signup.this).getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.signup_contaner, signupFactor1);
        fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
        fragmentTransaction.commit();





    }
}
