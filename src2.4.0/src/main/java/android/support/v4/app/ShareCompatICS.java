package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

@TargetApi(14)
@RequiresApi(14)
class ShareCompatICS {
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    ShareCompatICS() {
    }

    public static void configureMenuItem(MenuItem menuItem, Activity activity, Intent intent) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider shareActionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(activity) : (ShareActionProvider) actionProvider;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HISTORY_FILENAME_PREFIX);
        stringBuilder.append(activity.getClass().getName());
        shareActionProvider.setShareHistoryFileName(stringBuilder.toString());
        shareActionProvider.setShareIntent(intent);
        menuItem.setActionProvider(shareActionProvider);
    }
}
