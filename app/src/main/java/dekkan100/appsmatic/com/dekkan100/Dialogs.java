package dekkan100.appsmatic.com.dekkan100;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import dekkan100.appsmatic.com.dekkan100.Activities.Home;

/**
 * Created by Eng Ali on 2/6/2018.
 */
public class Dialogs {




    //Comments Dialog
    public static void productsReviews(final Context context,View view,String title) {
        TextView rateThisProduct,send,noreviewsFlag;
        EditText reviewInput;
        //Initialize Done Dialog
        final NiftyDialogBuilder dialogBuildercard = NiftyDialogBuilder.getInstance(context);

        dialogBuildercard
                .withDuration(700)//def
                .withEffect(Effectstype.Fall)
                .withDialogColor(context.getResources().getColor(R.color.colorPrimary))
                .withTitleColor(Color.WHITE)
                .withTitle(title)
                .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                .setCustomView(R.layout.product_reviews_dialog, view.getContext())
                .show();
        //Setup Items
        rateThisProduct=(TextView)dialogBuildercard.findViewById(R.id.rate_product_tv);
        rateThisProduct.setTypeface(Home.face);
        send=(TextView)dialogBuildercard.findViewById(R.id.product_send_btn);
        send.setTypeface(Home.face);
        noreviewsFlag=(TextView)dialogBuildercard.findViewById(R.id.no_reviews_flag);
        noreviewsFlag.setTypeface(Home.face);
        reviewInput=(EditText)dialogBuildercard.findViewById(R.id.product_review_input);
        reviewInput.setTypeface(Home.face);
    }

    }
