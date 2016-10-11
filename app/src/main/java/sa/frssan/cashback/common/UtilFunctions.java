package sa.frssan.cashback.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Thahaseen on 10/11/2016.
 */
public class UtilFunctions {

    public static void signOutFromApp(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("signIn", 0);
        editor.apply();
    }

}
