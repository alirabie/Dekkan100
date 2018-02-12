package dekkan100.appsmatic.com.dekkan100.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.Fragments.Main.Main;
import dekkan100.appsmatic.com.dekkan100.R;

public class ShoppingCartFrag extends Fragment {


    private TextView emptyFlag,contshoppingBtn,emptyCardBtn;
    int i=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emptyFlag=(TextView)view.findViewById(R.id.cart_empty_flag);
        emptyFlag.setTypeface(Home.face);
        contshoppingBtn=(TextView)view.findViewById(R.id.cart_contin_btn);
        contshoppingBtn.setTypeface(Home.face);
        emptyCardBtn=(TextView)view.findViewById(R.id.cart_empty_btn);
        emptyCardBtn.setTypeface(Home.face);


        contshoppingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(contshoppingBtn, getContext());
                android.support.v4.app.FragmentManager fragmentManager = ((FragmentActivity)getContext()).getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new Main());
                fragmentTransaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                fragmentTransaction.commit();
            }
        });


        emptyCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(emptyCardBtn,getContext());

                //test badges
                 i++;
                Home.setupMessageBadge(i);
                Home.setupCartBadge(i);

                Toast.makeText(getContext(),"Testing Top Icons Badges Count INC ",Toast.LENGTH_SHORT).show();


            }
        });

    }
}
