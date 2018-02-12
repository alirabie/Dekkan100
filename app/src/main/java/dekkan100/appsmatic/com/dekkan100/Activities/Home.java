package dekkan100.appsmatic.com.dekkan100.Activities;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import dekkan100.appsmatic.com.dekkan100.Fragments.AboutApp;
import dekkan100.appsmatic.com.dekkan100.Fragments.FavoriteFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.LatestoffersFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.Main.Main;
import dekkan100.appsmatic.com.dekkan100.Fragments.OrdersFrags.OrdersMasterFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.ProductInfoFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.ProfileFrags.MessagesFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.ProfileFrags.ProfileMasterFrag;
import dekkan100.appsmatic.com.dekkan100.Fragments.ShoppingCartFrag;
import dekkan100.appsmatic.com.dekkan100.R;
import dekkan100.appsmatic.com.dekkan100.Fragments.Settings;

public class Home extends AppCompatActivity{
    private LinearLayout settings,latestOffers,home,profile,myOrders,favorites,aboutApp,messages;
    private TextView tittle ;
    private boolean doubleBackToExitPressedOnce = false;
    public static Typeface face;
    DrawerLayout drawer;
    public static TextView textCartItemCount;
    public static int mCartItemCount =2;
    public static TextView textMessagesItemCount;
    public static int mMessageItemCount =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home);
        face= Typeface.createFromAsset(getAssets(), "fonts/arabic.ttf");
        tittle=(TextView)findViewById(R.id.title_text);
        tittle.setTypeface(face);
        tittle.setVisibility(View.INVISIBLE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //Check Os Ver For Set Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }

        //add main screen
        android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new Main());
        fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
        fragmentTransaction.commit();




        //Side menu

       //home
        home=(LinearLayout)findViewById(R.id.home_link);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(home, Home.this);
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new Main());
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.INVISIBLE);
                tittle.setText("");
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        //settings
        settings=(LinearLayout)findViewById(R.id.settings_link);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(Home.this, R.anim.alpha);
                settings.clearAnimation();
                settings.setAnimation(anim);
                Settings settingsFrag=new Settings();
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, settingsFrag);
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.VISIBLE);
                tittle.setText(getResources().getString(R.string.settings));
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                tittle.clearAnimation();
                tittle.setAnimation(anim2);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        //Profile
        profile=(LinearLayout)findViewById(R.id.profile_link);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(profile, Home.this);
                ProfileMasterFrag profileFrag=new ProfileMasterFrag();
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, profileFrag);
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.VISIBLE);
                tittle.setText(getResources().getString(R.string.profile));
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                tittle.clearAnimation();
                tittle.setAnimation(anim2);
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        //latest offers
        latestOffers=(LinearLayout)findViewById(R.id.offers_link);
        latestOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(latestOffers,Home.this);
                LatestoffersFrag latestoffersFrag =new LatestoffersFrag();
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, latestoffersFrag);
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.VISIBLE);
                tittle.setText(getResources().getString(R.string.offers));
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                tittle.clearAnimation();
                tittle.setAnimation(anim2);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        //My Orders
        myOrders=(LinearLayout)findViewById(R.id.myorders_link);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(myOrders,Home.this);
                OrdersMasterFrag ordersMasterFrag=new OrdersMasterFrag();
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, ordersMasterFrag);
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.VISIBLE);
                tittle.setText(getResources().getString(R.string.orders));
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                tittle.clearAnimation();
                tittle.setAnimation(anim2);
                drawer.closeDrawer(GravityCompat.START);
            }
        });



        //Favorites
        favorites=(LinearLayout)findViewById(R.id.myfavorites_link);
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(favorites,Home.this);
                FavoriteFrag favoriteFrag=new FavoriteFrag();
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, favoriteFrag);
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.VISIBLE);
                tittle.setText(getResources().getString(R.string.favorites));
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                tittle.clearAnimation();
                tittle.setAnimation(anim2);
                drawer.closeDrawer(GravityCompat.START);

            }
        });


        //about app
        aboutApp=(LinearLayout)findViewById(R.id.aboutus_link);
        aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(aboutApp,Home.this);
                AboutApp aboutApp=new AboutApp();
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, aboutApp);
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.VISIBLE);
                tittle.setText(getResources().getString(R.string.aboutus));
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                tittle.clearAnimation();
                tittle.setAnimation(anim2);
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        //Messages
        messages=(LinearLayout)findViewById(R.id.messages_link);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(messages,Home.this);
                android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new MessagesFrag());
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
                tittle.setVisibility(View.VISIBLE);
                tittle.setText(getResources().getString(R.string.mymesages));
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                tittle.clearAnimation();
                tittle.setAnimation(anim2);
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        drawer= (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.sidemenicon);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        drawer.setDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    protected void onResume() {
        super.onResume();
        this.doubleBackToExitPressedOnce = false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            //add main screen
            android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_container,new Main());
            fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            fragmentTransaction.commit();
            tittle.setVisibility(View.INVISIBLE);
            tittle.setText("");

            Toast.makeText(this,getResources().getString(R.string.pressagain), Toast.LENGTH_SHORT).show();
            if (doubleBackToExitPressedOnce) {
                final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(Home.this);
                dialogBuilder
                        .withTitle(getResources().getString(R.string.app_name))
                        .withIcon(getResources().getDrawable(R.drawable.lunchericon))
                        .withDialogColor(R.color.colorPrimary)
                        .withTitleColor("#FFFFFF")
                        .withDuration(700)                                          //def
                        .withEffect(Effectstype.RotateBottom)
                        .withMessage(getResources().getString(R.string.areyousure))
                        .withButton1Text(getResources().getString(R.string.yes))
                        .withButton2Text(getResources().getString(R.string.no))
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBuilder.dismiss();
                                Home.this.finish();
                            }
                        })
                        .setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBuilder.dismiss();
                            }
                        })
                        .show();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            // Toast.makeText(this, R.string.pressagain, Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_shopping_cart);
        final MenuItem menuitem2=menu.findItem(R.id.action_chat);
        View actionView = MenuItemCompat.getActionView(menuItem);
        View actionView2= MenuItemCompat.getActionView(menuitem2);
        textCartItemCount = (TextView) actionView.findViewById(R.id.cart_badge);
        textMessagesItemCount=(TextView)actionView2.findViewById(R.id.message_badge);
        actionView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuitem2);
            }
        });

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_shopping_cart) {
            animateClick(tittle,Home.this);
            tittle.setVisibility(View.VISIBLE);
            tittle.setText(getResources().getString(R.string.shoppingcart));
            android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new ShoppingCartFrag());
            fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            fragmentTransaction.commit();
            return true;
        }else if (id == R.id.action_chat){
            Home.animateClick(messages,Home.this);
            android.support.v4.app.FragmentManager fragmentManager = (Home.this).getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_container, new MessagesFrag());
            fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            fragmentTransaction.commit();
            Home.animateClick(tittle, Home.this);
            tittle.setVisibility(View.VISIBLE);
            tittle.setText(getResources().getString(R.string.mymesages));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Add Messages badge count
    public static void setupMessageBadge(int count) {
       mMessageItemCount=count;
        if (textMessagesItemCount != null) {

            if (mMessageItemCount == 0) {
                if (textMessagesItemCount.getVisibility() != View.GONE) {
                    textMessagesItemCount.setVisibility(View.GONE);
                }
            } else {
                textMessagesItemCount.setText(String.valueOf(Math.min(mMessageItemCount, 99)));
                if (textMessagesItemCount.getVisibility() != View.VISIBLE) {
                    textMessagesItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }


    //Add Cart Messages badge count
    public static void setupCartBadge(int count) {
        mCartItemCount=count;
        if (textCartItemCount != null) {

            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }



    //Animate button click
    public static void animateClick(View view,Context context){
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.alpha);
        view.clearAnimation();
        view.setAnimation(anim);
    }










}
