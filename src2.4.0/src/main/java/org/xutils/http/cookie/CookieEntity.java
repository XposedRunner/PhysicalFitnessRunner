package org.xutils.http.cookie;

import android.text.TextUtils;
import java.net.HttpCookie;
import java.net.URI;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "cookie", onCreated = "CREATE UNIQUE INDEX index_cookie_unique ON cookie(\"name\",\"domain\",\"path\")")
final class CookieEntity {
    private static final long MAX_EXPIRY = (System.currentTimeMillis() + 3110400000000L);
    @Column(name = "comment")
    private String comment;
    @Column(name = "commentURL")
    private String commentURL;
    @Column(name = "discard")
    private boolean discard;
    @Column(name = "domain")
    private String domain;
    @Column(name = "expiry")
    private long expiry = MAX_EXPIRY;
    @Column(isId = true, name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "path")
    private String path;
    @Column(name = "portList")
    private String portList;
    @Column(name = "secure")
    private boolean secure;
    @Column(name = "uri")
    private String uri;
    @Column(name = "value")
    private String value;
    @Column(name = "version")
    private int version = 1;

    public CookieEntity(URI uri, HttpCookie httpCookie) {
        this.uri = uri == null ? null : uri.toString();
        this.name = httpCookie.getName();
        this.value = httpCookie.getValue();
        this.comment = httpCookie.getComment();
        this.commentURL = httpCookie.getCommentURL();
        this.discard = httpCookie.getDiscard();
        this.domain = httpCookie.getDomain();
        long maxAge = httpCookie.getMaxAge();
        if (maxAge == -1 || maxAge <= 0) {
            this.expiry = -1;
        } else {
            this.expiry = (maxAge * 1000) + System.currentTimeMillis();
            if (this.expiry < 0) {
                this.expiry = MAX_EXPIRY;
            }
        }
        this.path = httpCookie.getPath();
        if (!TextUtils.isEmpty(this.path) && this.path.length() > 1 && this.path.endsWith("/")) {
            this.path = this.path.substring(0, this.path.length() - 1);
        }
        this.portList = httpCookie.getPortlist();
        this.secure = httpCookie.getSecure();
        this.version = httpCookie.getVersion();
    }

    public long getId() {
        return this.id;
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isExpired() {
        return this.expiry != -1 && this.expiry < System.currentTimeMillis();
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public HttpCookie toHttpCookie() {
        HttpCookie httpCookie = new HttpCookie(this.name, this.value);
        httpCookie.setComment(this.comment);
        httpCookie.setCommentURL(this.commentURL);
        httpCookie.setDiscard(this.discard);
        httpCookie.setDomain(this.domain);
        if (this.expiry == -1) {
            httpCookie.setMaxAge(-1);
        } else {
            httpCookie.setMaxAge((this.expiry - System.currentTimeMillis()) / 1000);
        }
        httpCookie.setPath(this.path);
        httpCookie.setPortlist(this.portList);
        httpCookie.setSecure(this.secure);
        httpCookie.setVersion(this.version);
        return httpCookie;
    }
}
