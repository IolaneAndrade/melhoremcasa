package mds.gpp.saudeemcasa.helper;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by iolane on 18/11/15.
 */
public class MessageDialogFragment extends DialogFragment {

    private Dialog oneDialog;

    public MessageDialogFragment() {
        super();
        oneDialog = null;
        setRetainInstance(true);
    }

    public void setDialog(Dialog dialog) {
        oneDialog = dialog;
    }

    @Override
    public  Dialog onCreateDialog(Bundle savedInstanceState) {
        return oneDialog;
    }
}
