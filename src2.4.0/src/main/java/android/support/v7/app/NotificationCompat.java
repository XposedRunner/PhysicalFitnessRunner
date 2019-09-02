package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat.MessagingStyle;
import android.support.v4.app.NotificationCompat.MessagingStyle.Message;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.text.BidiFormatter;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.util.List;

public class NotificationCompat extends android.support.v4.app.NotificationCompat {

    private static class Api24Extender extends BuilderExtender {
        private Api24Extender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.addStyleToBuilderApi24(notificationBuilderWithBuilderAccessor, builder);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    public static class Builder extends android.support.v4.app.NotificationCompat.Builder {
        public Builder(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected */
        @RestrictTo({Scope.LIBRARY_GROUP})
        public BuilderExtender getExtender() {
            return VERSION.SDK_INT >= 24 ? new Api24Extender() : VERSION.SDK_INT >= 21 ? new LollipopExtender() : VERSION.SDK_INT >= 16 ? new JellybeanExtender() : VERSION.SDK_INT >= 14 ? new IceCreamSandwichExtender() : super.getExtender();
        }

        /* Access modifiers changed, original: protected */
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence resolveText() {
            if (this.mStyle instanceof MessagingStyle) {
                MessagingStyle messagingStyle = (MessagingStyle) this.mStyle;
                Message access$000 = NotificationCompat.findLatestIncomingMessage(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (access$000 != null) {
                    return conversationTitle != null ? NotificationCompat.makeMessageLine(this, messagingStyle, access$000) : access$000.getText();
                }
            }
            return super.resolveText();
        }

        /* Access modifiers changed, original: protected */
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence resolveTitle() {
            if (this.mStyle instanceof MessagingStyle) {
                MessagingStyle messagingStyle = (MessagingStyle) this.mStyle;
                Message access$000 = NotificationCompat.findLatestIncomingMessage(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (!(conversationTitle == null && access$000 == null)) {
                    if (conversationTitle == null) {
                        conversationTitle = access$000.getSender();
                    }
                    return conversationTitle;
                }
            }
            return super.resolveTitle();
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
    }

    public static class MediaStyle extends Style {
        int[] mActionsToShowInCompact = null;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        Token mToken;

        public MediaStyle(android.support.v4.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
    }

    private static class IceCreamSandwichExtender extends BuilderExtender {
        IceCreamSandwichExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews access$300 = NotificationCompat.addStyleGetContentViewIcs(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (access$300 != null) {
                build.contentView = access$300;
            } else if (builder.getContentView() != null) {
                build.contentView = builder.getContentView();
            }
            return build;
        }
    }

    private static class JellybeanExtender extends BuilderExtender {
        JellybeanExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews access$400 = NotificationCompat.addStyleGetContentViewJellybean(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (access$400 != null) {
                build.contentView = access$400;
            }
            NotificationCompat.addBigStyleToBuilderJellybean(build, builder);
            return build;
        }
    }

    private static class LollipopExtender extends BuilderExtender {
        LollipopExtender() {
        }

        public Notification build(android.support.v4.app.NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews access$600 = NotificationCompat.addStyleGetContentViewLollipop(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (access$600 != null) {
                build.contentView = access$600;
            }
            NotificationCompat.addBigStyleToBuilderLollipop(build, builder);
            NotificationCompat.addHeadsUpToBuilderLollipop(build, builder);
            return build;
        }
    }

    @TargetApi(16)
    @RequiresApi(16)
    private static void addBigStyleToBuilderJellybean(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        if (builder2.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder2.mStyle;
            RemoteViews bigContentView = builder.getBigContentView() != null ? builder.getBigContentView() : builder.getContentView();
            boolean z = (builder2.mStyle instanceof DecoratedMediaCustomViewStyle) && bigContentView != null;
            RemoteViews remoteViews = bigContentView;
            NotificationCompatImplBase.overrideMediaBigContentView(notification, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder2.mActions, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, z);
            if (z) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, notification.bigContentView, remoteViews);
                return;
            }
            return;
        }
        Notification notification2 = notification;
        if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedBigStyleToBuilderJellybean(notification, builder);
        }
    }

    @TargetApi(21)
    @RequiresApi(21)
    private static void addBigStyleToBuilderLollipop(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        Notification notification2 = notification;
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        RemoteViews bigContentView = builder.getBigContentView() != null ? builder.getBigContentView() : builder.getContentView();
        Notification notification3;
        if (!(builder2.mStyle instanceof DecoratedMediaCustomViewStyle) || bigContentView == null) {
            notification3 = notification2;
            if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
                addDecoratedBigStyleToBuilderJellybean(notification, builder);
                return;
            }
            return;
        }
        RemoteViews remoteViews = bigContentView;
        NotificationCompatImplBase.overrideMediaBigContentView(notification2, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder2.mActions, false, null, true);
        android.support.v4.app.NotificationCompat.Builder builder3 = builder;
        notification3 = notification;
        NotificationCompatImplBase.buildIntoRemoteViews(builder3.mContext, notification3.bigContentView, remoteViews);
        setBackgroundColor(builder3.mContext, notification3.bigContentView, builder.getColor());
    }

    @TargetApi(16)
    @RequiresApi(16)
    private static void addDecoratedBigStyleToBuilderJellybean(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        Notification notification2 = notification;
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        RemoteViews bigContentView = builder.getBigContentView();
        if (bigContentView == null) {
            bigContentView = builder.getContentView();
        }
        if (bigContentView != null) {
            RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, notification2.icon, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, builder2.mActions);
            NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, applyStandardTemplateWithActions, bigContentView);
            notification.bigContentView = applyStandardTemplateWithActions;
        }
    }

    @TargetApi(21)
    @RequiresApi(21)
    private static void addDecoratedHeadsUpToBuilderLollipop(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        Notification notification2 = notification;
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        RemoteViews headsUpContentView = builder.getHeadsUpContentView();
        RemoteViews contentView = headsUpContentView != null ? headsUpContentView : builder.getContentView();
        if (headsUpContentView != null) {
            headsUpContentView = NotificationCompatImplBase.applyStandardTemplateWithActions(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, notification2.icon, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, builder2.mActions);
            NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, headsUpContentView, contentView);
            notification2.headsUpContentView = headsUpContentView;
        }
    }

    @TargetApi(21)
    @RequiresApi(21)
    private static void addHeadsUpToBuilderLollipop(Notification notification, android.support.v4.app.NotificationCompat.Builder builder) {
        Notification notification2 = notification;
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        RemoteViews headsUpContentView = builder.getHeadsUpContentView() != null ? builder.getHeadsUpContentView() : builder.getContentView();
        if ((builder2.mStyle instanceof DecoratedMediaCustomViewStyle) && headsUpContentView != null) {
            notification2.headsUpContentView = NotificationCompatImplBase.generateMediaBigView(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder2.mActions, false, null, true);
            NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, notification2.headsUpContentView, headsUpContentView);
            setBackgroundColor(builder2.mContext, notification2.headsUpContentView, builder.getColor());
        } else if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            addDecoratedHeadsUpToBuilderLollipop(notification, builder);
        }
    }

    private static void addMessagingFallBackStyle(MessagingStyle messagingStyle, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List messages = messagingStyle.getMessages();
        int i = (messagingStyle.getConversationTitle() != null || hasMessagesWithoutSender(messagingStyle.getMessages())) ? 1 : 0;
        for (int size = messages.size() - 1; size >= 0; size--) {
            Message message = (Message) messages.get(size);
            CharSequence makeMessageLine = i != 0 ? makeMessageLine(builder, messagingStyle, message) : message.getText();
            if (size != messages.size() - 1) {
                spannableStringBuilder.insert(0, "\n");
            }
            spannableStringBuilder.insert(0, makeMessageLine);
        }
        NotificationCompatImplJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, spannableStringBuilder);
    }

    @TargetApi(14)
    @RequiresApi(14)
    private static RemoteViews addStyleGetContentViewIcs(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        if (builder2.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder2.mStyle;
            boolean z = (builder2.mStyle instanceof DecoratedMediaCustomViewStyle) && builder.getContentView() != null;
            RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder2.mActions, mediaStyle.mActionsToShowInCompact, mediaStyle.mShowCancelButton, mediaStyle.mCancelButtonIntent, z);
            if (z) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder.mContext, overrideContentViewMedia, builder.getContentView());
                return overrideContentViewMedia;
            }
        } else if (builder2.mStyle instanceof DecoratedCustomViewStyle) {
            return getDecoratedContentView(builder);
        }
        return null;
    }

    @TargetApi(16)
    @RequiresApi(16)
    private static RemoteViews addStyleGetContentViewJellybean(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MessagingStyle) {
            addMessagingFallBackStyle((MessagingStyle) builder.mStyle, notificationBuilderWithBuilderAccessor, builder);
        }
        return addStyleGetContentViewIcs(notificationBuilderWithBuilderAccessor, builder);
    }

    @TargetApi(21)
    @RequiresApi(21)
    private static RemoteViews addStyleGetContentViewLollipop(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor2;
        if (builder2.mStyle instanceof MediaStyle) {
            Object token;
            MediaStyle mediaStyle = (MediaStyle) builder2.mStyle;
            int[] iArr = mediaStyle.mActionsToShowInCompact;
            if (mediaStyle.mToken != null) {
                token = mediaStyle.mToken.getToken();
                notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor;
            } else {
                notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor;
                token = null;
            }
            NotificationCompatImpl21.addMediaStyle(notificationBuilderWithBuilderAccessor2, iArr, token);
            token = null;
            boolean z = builder.getContentView() != null;
            Object obj = (VERSION.SDK_INT < 21 || VERSION.SDK_INT > 23) ? null : 1;
            if (z || !(obj == null || builder.getBigContentView() == null)) {
                token = 1;
            }
            if (!(builder2.mStyle instanceof DecoratedMediaCustomViewStyle) || r5 == null) {
                return null;
            }
            RemoteViews overrideContentViewMedia = NotificationCompatImplBase.overrideContentViewMedia(notificationBuilderWithBuilderAccessor2, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder2.mActions, mediaStyle.mActionsToShowInCompact, false, null, z);
            if (z) {
                NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, overrideContentViewMedia, builder.getContentView());
            }
            setBackgroundColor(builder2.mContext, overrideContentViewMedia, builder.getColor());
            return overrideContentViewMedia;
        }
        notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor;
        return builder2.mStyle instanceof DecoratedCustomViewStyle ? getDecoratedContentView(builder) : addStyleGetContentViewJellybean(notificationBuilderWithBuilderAccessor, builder);
    }

    @TargetApi(24)
    @RequiresApi(24)
    private static void addStyleToBuilderApi24(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedCustomViewStyle(notificationBuilderWithBuilderAccessor);
        } else if (builder.mStyle instanceof DecoratedMediaCustomViewStyle) {
            NotificationCompatImpl24.addDecoratedMediaCustomViewStyle(notificationBuilderWithBuilderAccessor);
        } else if (!(builder.mStyle instanceof MessagingStyle)) {
            addStyleGetContentViewLollipop(notificationBuilderWithBuilderAccessor, builder);
        }
    }

    private static Message findLatestIncomingMessage(MessagingStyle messagingStyle) {
        List messages = messagingStyle.getMessages();
        for (int size = messages.size() - 1; size >= 0; size--) {
            Message message = (Message) messages.get(size);
            if (!TextUtils.isEmpty(message.getSender())) {
                return message;
            }
        }
        return !messages.isEmpty() ? (Message) messages.get(messages.size() - 1) : null;
    }

    private static RemoteViews getDecoratedContentView(android.support.v4.app.NotificationCompat.Builder builder) {
        android.support.v4.app.NotificationCompat.Builder builder2 = builder;
        if (builder.getContentView() == null) {
            return null;
        }
        RemoteViews applyStandardTemplateWithActions = NotificationCompatImplBase.applyStandardTemplateWithActions(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mNumber, builder2.mNotification.icon, builder2.mLargeIcon, builder2.mSubText, builder2.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, null);
        NotificationCompatImplBase.buildIntoRemoteViews(builder2.mContext, applyStandardTemplateWithActions, builder.getContentView());
        return applyStandardTemplateWithActions;
    }

    public static Token getMediaSession(Notification notification) {
        Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
        if (extras != null) {
            if (VERSION.SDK_INT >= 21) {
                Parcelable parcelable = extras.getParcelable(android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (parcelable != null) {
                    return Token.fromToken(parcelable);
                }
            }
            IBinder binder = BundleCompat.getBinder(extras, android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (binder != null) {
                Parcel obtain = Parcel.obtain();
                obtain.writeStrongBinder(binder);
                obtain.setDataPosition(0);
                Token token = (Token) Token.CREATOR.createFromParcel(obtain);
                obtain.recycle();
                return token;
            }
        }
        return null;
    }

    private static boolean hasMessagesWithoutSender(List<Message> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((Message) list.get(size)).getSender() == null) {
                return true;
            }
        }
        return false;
    }

    private static TextAppearanceSpan makeFontColorSpan(int i) {
        return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
    }

    private static CharSequence makeMessageLine(android.support.v4.app.NotificationCompat.Builder builder, MessagingStyle messagingStyle, Message message) {
        BidiFormatter instance = BidiFormatter.getInstance();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Object obj = VERSION.SDK_INT >= 21 ? 1 : null;
        int i = (obj != null || VERSION.SDK_INT <= 10) ? ViewCompat.MEASURED_STATE_MASK : -1;
        CharSequence sender = message.getSender();
        if (TextUtils.isEmpty(message.getSender())) {
            sender = messagingStyle.getUserDisplayName() == null ? "" : messagingStyle.getUserDisplayName();
            if (!(obj == null || builder.getColor() == 0)) {
                i = builder.getColor();
            }
        }
        CharSequence unicodeWrap = instance.unicodeWrap(sender);
        spannableStringBuilder.append(unicodeWrap);
        spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.append("  ").append(instance.unicodeWrap(message.getText() == null ? "" : message.getText()));
        return spannableStringBuilder;
    }

    private static void setBackgroundColor(Context context, RemoteViews remoteViews, int i) {
        if (i == 0) {
            i = context.getResources().getColor(R.color.notification_material_background_media_default_color);
        }
        remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i);
    }
}
