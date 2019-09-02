package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class ErrorDialogFragments {
    public static int O000000o;
    public static Class<?> O00000Oo;

    @TargetApi(11)
    public static class O000000o extends DialogFragment implements OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.O000000o(dialogInterface, i, getActivity(), getArguments());
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.O000000o(getActivity(), getArguments(), this);
        }
    }

    public static class Support extends android.support.v4.app.DialogFragment implements OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.O000000o(dialogInterface, i, getActivity(), getArguments());
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.O000000o(getActivity(), getArguments(), this);
        }
    }

    public static Dialog O000000o(Context context, Bundle bundle, OnClickListener onClickListener) {
        Builder builder = new Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.O00000o));
        builder.setMessage(bundle.getString(ErrorDialogManager.O00000oO));
        if (O000000o != 0) {
            builder.setIcon(O000000o);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void O000000o(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        if (O00000Oo != null) {
            try {
                ErrorDialogManager.O000000o.O000000o.O00000Oo().O00000o(O00000Oo.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (bundle.getBoolean(ErrorDialogManager.O00000oo, false) && activity != null) {
            activity.finish();
        }
    }
}
