package com.inventics.dailymoments.util;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class IntentUtils {
    public static void startIntentToAnotherActivity(Context from, Class<?> to) {
        Intent intent = new Intent(from, to);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        from.startActivity(intent);
    }
}
