package android.support.v4.app;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.SemesterTipBean;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.List;

public class SemesterTipDialog extends DialogFragment {
    public static final String DIALOG_BEAN = "dialog_bean";
    public static final int REQUEST_CODE_SEMESTER_DIALOG = 60000;
    public static final String TAG = "SemesterTipDialog";
    private SemesterTipBean mBean;
    private boolean mNeedCallBack;
    private WebView moreLimitLayout;

    private void initExtra(Bundle bundle) {
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.mBean = (SemesterTipBean) bundle.getParcelable(DIALOG_BEAN);
        }
    }

    public static SemesterTipDialog newInstance(SemesterTipBean semesterTipBean) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(DIALOG_BEAN, semesterTipBean);
        SemesterTipDialog semesterTipDialog = new SemesterTipDialog();
        semesterTipDialog.setArguments(bundle);
        return semesterTipDialog;
    }

    private void removeAllCookie() {
        CookieSyncManager createInstance = CookieSyncManager.createInstance(this.moreLimitLayout.getContext());
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.removeSessionCookie();
        instance.removeAllCookie();
        createInstance.sync();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initExtra(bundle);
        setStyle(2, 2131755439);
        setCancelable(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        getDialog().setCanceledOnTouchOutside(false);
        return layoutInflater.inflate(2131427487, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.moreLimitLayout != null) {
            this.moreLimitLayout.clearCache(true);
            this.moreLimitLayout.clearFormData();
            this.moreLimitLayout.clearHistory();
            this.moreLimitLayout.clearView();
            removeAllCookie();
            this.moreLimitLayout.stopLoading();
            this.moreLimitLayout.removeAllViews();
            this.moreLimitLayout.destroy();
            this.moreLimitLayout = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putParcelable(DIALOG_BEAN, this.mBean);
        }
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Window window = getDialog().getWindow();
            if (window != null) {
                LayoutParams attributes = window.getAttributes();
                attributes.gravity = 48;
                attributes.width = -1;
                attributes.height = -1;
                window.setAttributes(attributes);
            }
        }
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(2131297266);
        TextView textView2 = (TextView) view.findViewById(2131297265);
        TextView textView3 = (TextView) view.findViewById(2131297224);
        TextView textView4 = (TextView) view.findViewById(2131297215);
        TextView textView5 = (TextView) view.findViewById(2131297273);
        TextView textView6 = (TextView) view.findViewById(2131297301);
        TextView textView7 = (TextView) view.findViewById(2131297202);
        TextView textView8 = (TextView) view.findViewById(2131297444);
        this.moreLimitLayout = (WebView) view.findViewById(2131296844);
        if (this.mBean != null) {
            textView.setText(this.mBean.getSemesterGoal());
            textView2.setText(this.mBean.getTime());
            textView3.setText(this.mBean.getGradeLimit());
            textView4.setText(this.mBean.getDistanceLimit());
            textView5.setText(this.mBean.getSpeedLimit());
            List runValidTime = this.mBean.getRunValidTime();
            int i = (runValidTime == null || runValidTime.size() <= 0) ? 8 : 0;
            textView8.setVisibility(i);
            if (runValidTime != null && runValidTime.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < this.mBean.getRunValidTime().size(); i2++) {
                    if (i2 < runValidTime.size() - 1) {
                        stringBuilder.append((String) runValidTime.get(i2));
                        stringBuilder.append("\n");
                    } else {
                        stringBuilder.append((String) runValidTime.get(i2));
                    }
                }
                textView6.setText(stringBuilder.toString());
            }
            if (this.mBean.isShowMoreLimit()) {
                O00Oo0.O000000o(this.moreLimitLayout);
                this.moreLimitLayout.setWebViewClient(new WebViewClient() {
                    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        sslErrorHandler.proceed();
                    }
                });
                this.moreLimitLayout.setEnabled(false);
                this.moreLimitLayout.setFocusable(false);
                this.moreLimitLayout.setVisibility(0);
                this.moreLimitLayout.loadUrl(getString(2131689536));
            }
        }
        textView7.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SemesterTipDialog.this.isAdded() && !SemesterTipDialog.this.isDetached()) {
                    if (SemesterTipDialog.this.mNeedCallBack) {
                        SemesterTipDialog.this.getTargetFragment().onActivityResult(SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG, -1, null);
                    }
                    SemesterTipDialog.this.dismiss();
                }
            }
        });
    }

    public void setNeedCallBack(boolean z) {
        this.mNeedCallBack = z;
    }

    public void show(FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
