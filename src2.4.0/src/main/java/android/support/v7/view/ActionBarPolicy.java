package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.R;
import android.view.ViewConfiguration;
import com.alibaba.wireless.security.SecExceptionCode;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Resources resources = this.mContext.getResources();
        int screenWidthDp = ConfigurationHelper.getScreenWidthDp(resources);
        int screenHeightDp = ConfigurationHelper.getScreenHeightDp(resources);
        return (ConfigurationHelper.getSmallestScreenWidthDp(resources) > SecExceptionCode.SEC_ERROR_SIGNATRUE || screenWidthDp > SecExceptionCode.SEC_ERROR_SIGNATRUE || ((screenWidthDp > 960 && screenHeightDp > 720) || (screenWidthDp > 720 && screenHeightDp > 960))) ? 5 : (screenWidthDp >= 500 || ((screenWidthDp > GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH && screenHeightDp > GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH) || (screenWidthDp > GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH && screenHeightDp > GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH))) ? 4 : screenWidthDp >= SpatialRelationUtil.A_CIRCLE_DEGREE ? 3 : 2;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.mContext.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean showsOverflowMenuButton() {
        return VERSION.SDK_INT >= 19 ? true : ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) ^ 1;
    }
}
