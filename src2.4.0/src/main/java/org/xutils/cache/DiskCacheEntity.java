package org.xutils.cache;

import java.util.Date;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "disk_cache")
public final class DiskCacheEntity {
    @Column(name = "etag")
    private String etag;
    @Column(name = "expires")
    private long expires = Long.MAX_VALUE;
    @Column(name = "hits")
    private long hits;
    @Column(isId = true, name = "id")
    private long id;
    @Column(name = "key", property = "UNIQUE")
    private String key;
    @Column(name = "lastAccess")
    private long lastAccess;
    @Column(name = "lastModify")
    private Date lastModify;
    @Column(name = "path")
    private String path;
    @Column(name = "textContent")
    private String textContent;

    public String getEtag() {
        return this.etag;
    }

    public long getExpires() {
        return this.expires;
    }

    public long getHits() {
        return this.hits;
    }

    public long getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public long getLastAccess() {
        return this.lastAccess == 0 ? System.currentTimeMillis() : this.lastAccess;
    }

    public Date getLastModify() {
        return this.lastModify;
    }

    /* Access modifiers changed, original: 0000 */
    public String getPath() {
        return this.path;
    }

    public String getTextContent() {
        return this.textContent;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setExpires(long j) {
        this.expires = j;
    }

    public void setHits(long j) {
        this.hits = j;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastAccess(long j) {
        this.lastAccess = j;
    }

    public void setLastModify(Date date) {
        this.lastModify = date;
    }

    /* Access modifiers changed, original: 0000 */
    public void setPath(String str) {
        this.path = str;
    }

    public void setTextContent(String str) {
        this.textContent = str;
    }
}
