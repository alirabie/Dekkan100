package dekkan100.appsmatic.com.dekkan100.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;
import dekkan100.appsmatic.com.dekkan100.Dialogs;
import dekkan100.appsmatic.com.dekkan100.R;

public class ProductInfoFrag extends Fragment {

    LinearLayout expandPresentCard;
    ExpandableLinearLayout presentCard;
    ImageView arrw,presentCardlogo,gotoReviews;
    TextView addPresentCardTv,buyBtn,relatedProducts_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        expandPresentCard=(LinearLayout)view.findViewById(R.id.expandable_presentcard);
        gotoReviews=(ImageView)view.findViewById(R.id.product_details_goto_customercomments);
        presentCard=(ExpandableLinearLayout)view.findViewById(R.id.expandable);
        arrw=(ImageView)view.findViewById(R.id.arrwopen);
        presentCardlogo=(ImageView)view.findViewById(R.id.present_card_img);
        addPresentCardTv=(TextView)view.findViewById(R.id.add_presentcard_tv);
        addPresentCardTv.setTypeface(Home.face);
        buyBtn=(TextView)view.findViewById(R.id.buy_btn);
        buyBtn.setTypeface(Home.face);
        relatedProducts_tv=(TextView)view.findViewById(R.id.related_products_tv);
        relatedProducts_tv.setTypeface(Home.face);
        presentCardlogo.setVisibility(View.INVISIBLE);
        presentCard.initLayout();
        presentCard.collapse();
        expandPresentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presentCard.isExpanded()) {
                    presentCard.collapse();
                    presentCardlogo.setVisibility(View.INVISIBLE);
                    arrw.setImageResource(R.drawable.dropdownselect);
                } else {
                    presentCard.expand();
                    presentCardlogo.setVisibility(View.VISIBLE);
                    arrw.setImageResource(R.drawable.dropup);
                }
            }
        });

        gotoReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.animateClick(gotoReviews,getContext());
                Dialogs.productsReviews(getContext(),gotoReviews,"product");
            }
        });







    }
}
