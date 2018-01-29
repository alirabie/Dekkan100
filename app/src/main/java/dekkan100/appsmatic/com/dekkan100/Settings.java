package dekkan100.appsmatic.com.dekkan100;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.weiwangcn.betterspinner.library.BetterSpinner;

import java.util.ArrayList;
import java.util.List;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.Activities.Splash;
import dekkan100.appsmatic.com.dekkan100.Prefs.SaveSharedPreference;

public class Settings extends Fragment {

    private BetterSpinner langSpinner;
    List<String> languas=new ArrayList<>();
    private int langFlag;
    private boolean loadImagesFlag=false;
    private TextView acceptBtn;
    private Switch loadImgs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        languas.add(0, "عربي");
        languas.add(1, "English");
        langSpinner=(BetterSpinner)view.findViewById(R.id.lang_spinner);
        langSpinner.setTypeface(Home.face);
        acceptBtn=(TextView)view.findViewById(R.id.accept_btn);
        acceptBtn.setTypeface(Home.face);
        loadImgs=(Switch)view.findViewById(R.id.switch1);
        loadImgs.setTypeface(Home.face);
        //Lang selection
        ArrayAdapter<String> langListdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, languas);
        langSpinner.setAdapter(langListdapter);
        langSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set Lang Flag
                switch (position) {
                    case 0:
                        langFlag = 1;
                        break;
                    case 1:
                        langFlag = 2;
                        break;

                }

            }
        });


        //set image check button status
        if(SaveSharedPreference.getImgLoadingSatatus(getContext())){
            loadImgs.setChecked(true);
        }else {
            loadImgs.setChecked(false);
        }



        //Accept button action
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
                acceptBtn.clearAnimation();
                acceptBtn.setAnimation(anim);
                final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(getContext());
                dialogBuilder
                        .withTitle(getResources().getString(R.string.app_name))
                        .withDialogColor(R.color.colorPrimary)
                        .withTitleColor(getResources().getColor(R.color.colorPrimary))
                                // .withIcon(getResources().getDrawable(R.drawable.icon))
                        .withDuration(700)                                          //def
                        .withEffect(Effectstype.RotateBottom)
                        .withMessage(getResources().getString(R.string.restart))
                        .withButton1Text(getResources().getString(R.string.yes))
                        .withButton2Text(getResources().getString(R.string.no))
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (loadImgs.isChecked()) {
                                    loadImagesFlag = true;
                                } else {
                                    loadImagesFlag = false;
                                }


                                //Save Lang Selection depended on lang flag
                                switch (langFlag) {
                                    case 0:

                                        break;
                                    case 1:
                                        SaveSharedPreference.setLangId(getActivity().getApplicationContext(), "ar");
                                       // Home.changeLanguage(getContext(),"3",SaveSharedPreference.getCustomerId(getContext()));
                                        break;
                                    case 2:
                                        SaveSharedPreference.setLangId(getActivity().getApplicationContext(), "en");
                                      //  Home.changeLanguage(getContext(), "1", SaveSharedPreference.getCustomerId(getContext()));
                                        break;
                                }


                                //Control Images Loading
                                SaveSharedPreference.setImgLoadStatus(getContext(), loadImagesFlag);
                                getActivity().finish();
                                getContext().startActivity(new Intent(getContext(), Splash.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                dialogBuilder.dismiss();

                            }
                        })
                        .setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                dialogBuilder.dismiss();
                            }
                        })
                        .show();


            }

        });














    }
}
