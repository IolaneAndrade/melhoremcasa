package mds.gpp.saudeemcasa.helper;

import android.app.Dialog;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

/**
 * Created by iolane on 15/11/15.
 */

//verificar se o google play services está disponivel p/ o usuario, caso contrario, mostrar erro
public class GoogleMapPlayServicesUtils {

    public final static int REQUEST_CODE_PLAY_SEVICES = 9000;

    public static boolean googlePlayServicesAvailable(FragmentActivity activity) {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);

        if (ConnectionResult.SUCCESS == resultCode) {
            return true;
        } else {
            showErroMessage(activity, resultCode);
            return false;
        }
    }

    public static void showErroMessage(FragmentActivity activity, int errorCode) {
        Dialog errorDialog = GoogleMapPlayServicesUtils.getErrorDialog(errorCode, activity, REQUEST_CODE_PLAY_SEVICES);

        if (errorDialog != null) {
            MessageDialogFragment errorFragment = new MessageDialogFragment();
            errorFragment.setDialog(errorDialog);
            errorFragment.show(activity.getSupportFragmentManager(), "DIALOG_ERRO_PLAY_SERVICES");
        }
    }
}
