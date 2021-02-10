package com.dexterapps.easymarket.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Paint;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.dexterapps.easymarket.R;

public class Functions {
    public static ProgressDialog dialog;

    public static void Show_Dialog(Context context) {
        dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setMessage("Please Wait");
        dialog.create();
        dialog.show();
    }

    public static void Cancel_Dialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static Animation BlinkAnimation() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(700);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        return anim;
    }

    public static void AddStrike(TextView textView) {
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public static void FadeAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    public static Animation FadeAnimationButton() {
        Animation anim = new AlphaAnimation(1.0f, 0.0f);
        anim.setDuration(200);
        anim.setStartOffset(20);
        return anim;
    }
}
