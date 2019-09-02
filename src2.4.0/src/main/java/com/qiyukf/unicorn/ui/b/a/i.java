package com.qiyukf.unicorn.ui.b.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.f;
import com.qiyukf.unicorn.f.a.a.b.a;
import com.qiyukf.unicorn.ui.activity.UrlImagePreviewActivity;
import com.qiyukf.unicorn.widget.FileNameTextView;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class i extends e {
    private LinearLayout a;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        this.a.removeAllViews();
        List d = ((a) this.message.getAttachment()).d();
        if (d != null) {
            for (int i = 0; i < d.size(); i++) {
                View inflate;
                f.a aVar = (f.a) d.get(i);
                final String e;
                if (aVar.e()) {
                    inflate = LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_form_request_item_image, this.a, false);
                    TextView textView = (TextView) inflate.findViewById(R.id.ysf_message_form_item_label);
                    View findViewById = inflate.findViewById(R.id.ysf_message_form_item_image_layout);
                    FileNameTextView fileNameTextView = (FileNameTextView) inflate.findViewById(R.id.ysf_message_form_item_image_name);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.ysf_message_form_item_image_size);
                    textView.setText(aVar.c());
                    JSONObject h = aVar.h();
                    if (h == null) {
                        findViewById.setVisibility(8);
                    } else {
                        findViewById.setVisibility(0);
                        fileNameTextView.a(b.e(h, "name"));
                        textView2.setText(com.qiyukf.basesdk.c.a.b.a(b.c(h, "size")));
                        e = b.e(h, SocialConstants.PARAM_URL);
                        findViewById.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                ArrayList arrayList = new ArrayList(1);
                                arrayList.add(e);
                                UrlImagePreviewActivity.start(i.this.context, arrayList, 0);
                            }
                        });
                    }
                } else {
                    inflate = LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_form_request_item_text, this.a, false);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.ysf_message_form_item_text_value);
                    ((TextView) inflate.findViewById(R.id.ysf_message_form_item_label)).setText(aVar.c());
                    e = aVar.g();
                    if (TextUtils.isEmpty(e)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setVisibility(0);
                        textView3.setText(e);
                    }
                }
                this.a.addView(inflate);
                if (i < d.size() - 1) {
                    this.a.addView(LayoutInflater.from(this.context).inflate(R.layout.ysf_include_divider, this.a, false));
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_form_request;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (LinearLayout) findViewById(R.id.ysf_message_form_request_container);
    }
}
