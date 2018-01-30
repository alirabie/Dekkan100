package dekkan100.appsmatic.com.dekkan100.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dekkan100.appsmatic.com.dekkan100.API.Countries.ResCountry;
import dekkan100.appsmatic.com.dekkan100.API.WebService.DekkanApi;
import dekkan100.appsmatic.com.dekkan100.API.WebService.Generator;
import dekkan100.appsmatic.com.dekkan100.Prefs.SaveSharedPreference;
import dekkan100.appsmatic.com.dekkan100.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {

    private BetterSpinner countriesspinner;
    private FrameLayout bg;
    private static List<String> countriesNames;
    private static List<String> countriesIds;
    private static final String SAUDI_ID="69";
    private static LinearLayout contriesBox;
    private ImageView langBtn;
    private Typeface face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash);
        setLang(R.layout.activity_splash);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //Check Os Ver For Set Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }

        //font style
        face= Typeface.createFromAsset(getAssets(), "arabic.ttf");

        langBtn=(ImageView)findViewById(R.id.lang_btn);
        //Set images languages
        if(SaveSharedPreference.getLangId(this).equals("ar")){
            langBtn.setImageResource(R.drawable.englishbtn);
        }else{
            langBtn.setImageResource(R.drawable.arabicbtn);
        }

        //Lang switch button action
        langBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( SaveSharedPreference.getLangId(getApplicationContext()).equals("ar")) {
                    SaveSharedPreference.setLangId(getApplicationContext(), "en");
                    langBtn.setImageResource(R.drawable.arabicbtn);
                    startActivity(new Intent(getApplicationContext(), Splash.class));
                    Splash.this.finish();
                }else {
                    SaveSharedPreference.setLangId(getApplicationContext(), "ar");
                    langBtn.setImageResource(R.drawable.englishbtn);
                    startActivity(new Intent(getApplicationContext(),Splash.class));
                    Splash.this.finish();
                }
            }
        });





        countriesspinner = (BetterSpinner) findViewById(R.id.countryspinner);
        countriesspinner.setTypeface(face);
        contriesBox=(LinearLayout)findViewById(R.id.countries_contenr);
        bg=(FrameLayout)findViewById(R.id.bg);
        //Set images languages
        if(SaveSharedPreference.getLangId(this).equals("ar")){
            bg.setBackground(getResources().getDrawable(R.drawable.splach_ar));
        }else{
            bg.setBackground(getResources().getDrawable(R.drawable.splashscreen));
        }
        //spanners default adaptors
        countriesspinner.setAdapter(new ArrayAdapter<>(Splash.this, android.R.layout.simple_list_item_1));
        //items visibility
        contriesBox.setVisibility(View.INVISIBLE);


        //request countries by id from server
        Generator.createService(DekkanApi.class).getCountries(SAUDI_ID).enqueue(new Callback<ResCountry>() {
            @Override
            public void onResponse(Call<ResCountry> call, final Response<ResCountry> response) {
                if (response.isSuccessful()) {

                    contriesBox.setVisibility(View.VISIBLE);
                    countriesNames=new ArrayList<String>();
                    countriesIds=new ArrayList<String>();
                    //Animate Spinner box
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                    contriesBox.clearAnimation();
                    contriesBox.setAnimation(anim);

                    //fill names and ids to spinner list from response
                    for (int i = 0; i < response.body().getCountries().size(); i++) {
                        countriesNames.add(response.body().getCountries().get(i).getName());
                        countriesIds.add(response.body().getCountries().get(i).getId());
                    }
                    //add names to spinner list
                    ArrayAdapter<String> cuntryadapter = new ArrayAdapter<>(Splash.this, android.R.layout.simple_list_item_1, countriesNames);
                    cuntryadapter.notifyDataSetChanged();
                    countriesspinner.setTypeface(face);
                    countriesspinner.setAdapter(cuntryadapter);


                    //counters list selection action
                    countriesspinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                            Toast.makeText(getApplicationContext(),countriesNames.get(position),Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Splash.this, Login.class).putExtra("countrykey", countriesNames.get(position)));
                            Splash.this.finish();

                        }
                    });

                } else {
                    try {
                        Toast.makeText(getApplication(),response.errorBody().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResCountry> call, Throwable t) {
                Toast.makeText(getApplication(), "Connection error from countries "+t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });













    }

    // Change language method
    public  void setLang(int layout){
        String languageToLoad = SaveSharedPreference.getLangId(this);
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        this.setContentView(layout);
    }
}
