package com.qiyukf.nim.uikit.session.viewholder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.nim.uikit.common.a.f;
import com.qiyukf.nim.uikit.common.ui.imageview.HeadImageView;
import com.qiyukf.nim.uikit.session.module.a.c;
import com.qiyukf.nim.uikit.session.module.a.c.a;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.d;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class b extends f {
    protected View alertButton;
    private HeadImageView avatarLeft;
    private HeadImageView avatarRight;
    protected MsgContainerLayout contentContainer;
    private View ivTrashIcon;
    protected OnLongClickListener longClickListener;
    protected IMMessage message;
    protected TextView nameTextView;
    protected ProgressBar progressBar;
    protected TextView timeTextView;
    private TextView tvMessageItemReadStatus;
    private TextView tvTrashTips;

    private void setContent() {
        LinearLayout linearLayout = (LinearLayout) this.view.findViewById(R.id.ysf_message_item_body);
        int childCount = isReceivedMessage() ? 0 : linearLayout.getChildCount() - 1;
        if (linearLayout.getChildAt(childCount) != this.contentContainer) {
            linearLayout.removeView(this.contentContainer);
            linearLayout.addView(this.contentContainer, childCount);
        }
        if (isMiddleItem()) {
            setGravity(linearLayout, 17);
        } else if (isReceivedMessage()) {
            setGravity(linearLayout, 3);
            this.contentContainer.setBackgroundResource(leftBackground());
        } else {
            setGravity(linearLayout, 5);
            this.contentContainer.setBackgroundResource(rightBackground());
        }
    }

    private void setHeadImageView() {
        HeadImageView headImageView = isReceivedMessage() ? this.avatarLeft : this.avatarRight;
        HeadImageView headImageView2 = isReceivedMessage() ? this.avatarRight : this.avatarLeft;
        if (showAvatar()) {
            headImageView.setVisibility(0);
            String fromAccount = this.message.getFromAccount();
            this.message.getUuid();
            headImageView.a(fromAccount);
        } else {
            headImageView.setVisibility(8);
        }
        headImageView2.setVisibility(8);
    }

    private void setLongClickListener() {
        this.longClickListener = new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                if (b.this.onItemLongClick() || b.this.getAdapter().d() == null) {
                    return false;
                }
                a d = b.this.getAdapter().d();
                b.this.view;
                d.b(b.this.message);
                return true;
            }
        };
        this.contentContainer.setOnLongClickListener(this.longClickListener);
        if (com.qiyukf.nim.uikit.b.c() != null) {
            AnonymousClass5 anonymousClass5 = new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    b.this.context;
                    return true;
                }
            };
            this.avatarLeft.setOnLongClickListener(anonymousClass5);
            this.avatarRight.setOnLongClickListener(anonymousClass5);
        }
    }

    private void setNameTextView() {
        this.nameTextView.setVisibility(8);
    }

    private void setOnClickListener() {
        if (getAdapter().d() != null) {
            this.alertButton.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    b.this.getAdapter().d().a(b.this.message);
                }
            });
        }
        this.contentContainer.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.this.onItemClick();
            }
        });
        if (com.qiyukf.nim.uikit.b.c() != null) {
            AnonymousClass3 anonymousClass3 = new OnClickListener() {
                public final void onClick(View view) {
                    b.this.context;
                }
            };
            this.avatarLeft.setOnClickListener(anonymousClass3);
            this.avatarRight.setOnClickListener(anonymousClass3);
        }
    }

    private void setTimeTextView() {
        if (getAdapter().c(this.message)) {
            String str;
            this.timeTextView.setVisibility(0);
            Date date = new Date(this.message.getTime());
            Date date2 = new Date();
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Date time = instance.getTime();
            Date date3 = new Date(time.getTime() - LogBuilder.MAX_INTERVAL);
            Date date4 = new Date(date3.getTime() - LogBuilder.MAX_INTERVAL);
            if (!date.before(time)) {
                str = "今天";
            } else if (!date.before(date3)) {
                str = "昨天";
            } else if (date.before(date4)) {
                instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance.setTime(date);
                instance2.setTime(date2);
                int i = instance.get(1) - instance2.get(1);
                int i2 = (i != 0 ? 1 == i && 11 == instance2.get(2) ? instance.get(3) != instance2.get(3) : !(-1 == i && 11 == instance.get(2) && instance.get(3) == instance2.get(3)) : instance.get(3) != instance2.get(3)) ? 0 : 1;
                if (i2 != 0) {
                    String[] strArr = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
                    Calendar instance3 = Calendar.getInstance();
                    instance3.setTime(date);
                    str = strArr[instance3.get(7) - 1];
                } else {
                    str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
                }
            } else {
                str = "前天";
            }
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" ");
            stringBuilder.append(format);
            this.timeTextView.setText(stringBuilder.toString());
            return;
        }
        this.timeTextView.setVisibility(8);
    }

    private void setTrashTips() {
        String a = com.qiyukf.unicorn.j.f.a(this.message);
        int i = 0;
        this.ivTrashIcon.setVisibility(TextUtils.isEmpty(a) ? 8 : 0);
        TextView textView = this.tvTrashTips;
        if (TextUtils.isEmpty(a)) {
            i = 8;
        }
        textView.setVisibility(i);
        this.tvTrashTips.setText(a);
        if (!TextUtils.isEmpty(a)) {
            this.tvMessageItemReadStatus.setVisibility(8);
        }
    }

    private void uiCustomize() {
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization != null) {
            this.avatarLeft.a(uICustomization.avatarShape);
            this.avatarRight.a(uICustomization.avatarShape);
            if (uICustomization.hideLeftAvatar) {
                this.avatarLeft.setVisibility(8);
            }
            if (uICustomization.hideRightAvatar) {
                this.avatarRight.setVisibility(8);
            }
            if (uICustomization.tipsTextSize > 0.0f) {
                this.timeTextView.setTextSize(uICustomization.tipsTextSize);
            }
            if (uICustomization.tipsTextColor != 0) {
                this.timeTextView.setTextColor(uICustomization.tipsTextColor);
            }
        }
    }

    public abstract void bindContentView();

    /* Access modifiers changed, original: protected */
    public void downloadAttachment() {
        if (this.message.getAttachment() != null && (this.message.getAttachment() instanceof FileAttachment)) {
            ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(this.message, true);
        }
    }

    /* Access modifiers changed, original: protected */
    public <T extends View> T findViewById(int i) {
        return this.view.findViewById(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final c getAdapter() {
        return (c) this.adapter;
    }

    public abstract int getContentResId();

    /* Access modifiers changed, original: protected|final */
    public final int getResId() {
        return R.layout.ysf_message_item;
    }

    /* Access modifiers changed, original: protected|final */
    public final void inflate() {
        this.timeTextView = (TextView) findViewById(R.id.ysf_message_item_time);
        this.avatarLeft = (HeadImageView) findViewById(R.id.ysf_message_item_portrait_left);
        this.avatarRight = (HeadImageView) findViewById(R.id.ysf_message_item_portrait_right);
        this.alertButton = findViewById(R.id.ysf_message_item_alert);
        this.progressBar = (ProgressBar) findViewById(R.id.ysf_message_item_progress);
        this.nameTextView = (TextView) findViewById(R.id.ysf_message_item_nickname);
        this.contentContainer = (MsgContainerLayout) findViewById(R.id.ysf_message_item_content);
        this.contentContainer.a(this);
        this.ivTrashIcon = findViewById(R.id.ysf_message_item_trash_icon);
        this.tvTrashTips = (TextView) findViewById(R.id.ysf_message_item_trash_tips);
        this.tvMessageItemReadStatus = (TextView) findViewById(R.id.tv_message_item_read_status);
        View.inflate(this.view.getContext(), getContentResId(), this.contentContainer);
        inflateContentView();
    }

    public abstract void inflateContentView();

    /* Access modifiers changed, original: protected */
    public boolean isMiddleItem() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean isReceivedMessage() {
        return this.message.getDirect() == MsgDirectionEnum.In;
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return R.drawable.ysf_message_left_bg_selector;
    }

    public void onDetached() {
    }

    /* Access modifiers changed, original: protected */
    public void onItemClick() {
    }

    /* Access modifiers changed, original: protected */
    public boolean onItemLongClick() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void refresh(Object obj) {
        this.message = (IMMessage) obj;
        setHeadImageView();
        setNameTextView();
        setTimeTextView();
        setStatus();
        setOnClickListener();
        setLongClickListener();
        setContent();
        setOnClickListener();
        setTrashTips();
        uiCustomize();
        bindContentView();
    }

    public void refreshCurrentItem() {
        if (this.message != null) {
            refresh(this.message);
        }
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return R.drawable.ysf_message_right_bg_selector;
    }

    /* Access modifiers changed, original: protected|final */
    public final void setGravity(View view, int i) {
        ((LayoutParams) view.getLayoutParams()).gravity = i;
    }

    /* Access modifiers changed, original: protected|varargs */
    public void setLayoutParams(int i, int i2, View... viewArr) {
        for (View view : viewArr) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    /* Access modifiers changed, original: protected */
    public void setStatus() {
        switch (this.message.getStatus()) {
            case fail:
                this.progressBar.setVisibility(8);
                this.alertButton.setVisibility(0);
                this.tvMessageItemReadStatus.setVisibility(8);
                break;
            case sending:
                this.progressBar.setVisibility(0);
                this.alertButton.setVisibility(8);
                this.tvMessageItemReadStatus.setVisibility(8);
                return;
            case read:
                if (d.g().l(this.message.getSessionId()) != null && "1".equals(d.g().l(this.message.getSessionId()).a())) {
                    this.progressBar.setVisibility(8);
                    this.alertButton.setVisibility(8);
                    this.tvMessageItemReadStatus.setVisibility(0);
                    this.tvMessageItemReadStatus.setText("已读");
                    this.tvMessageItemReadStatus.setTextColor(Color.rgb(177, 177, 177));
                    return;
                }
            case unread:
                if (d.g().l(this.message.getSessionId()) == null || !"1".equals(d.g().l(this.message.getSessionId()).a())) {
                    this.progressBar.setVisibility(8);
                    this.alertButton.setVisibility(8);
                    this.tvMessageItemReadStatus.setVisibility(8);
                    return;
                }
                this.progressBar.setVisibility(8);
                this.alertButton.setVisibility(8);
                this.tvMessageItemReadStatus.setVisibility(0);
                this.tvMessageItemReadStatus.setText("未读");
                this.tvMessageItemReadStatus.setTextColor(Color.rgb(51, 136, 255));
                return;
            default:
                this.progressBar.setVisibility(8);
                this.alertButton.setVisibility(8);
                this.tvMessageItemReadStatus.setVisibility(8);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean showAvatar() {
        return true;
    }
}
