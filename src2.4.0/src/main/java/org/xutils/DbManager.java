package org.xutils;

import android.database.Cursor;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import org.xutils.common.util.KeyValue;
import org.xutils.db.Selector;
import org.xutils.db.sqlite.SqlInfo;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.db.table.DbModel;
import org.xutils.db.table.TableEntity;
import org.xutils.ex.DbException;

public interface DbManager extends Closeable {

    public interface DbOpenListener {
        void onDbOpened(DbManager dbManager);
    }

    public interface TableCreateListener {
        void onTableCreated(DbManager dbManager, TableEntity<?> tableEntity);
    }

    void addColumn(Class<?> cls, String str) throws DbException;

    void close() throws IOException;

    int delete(Class<?> cls, WhereBuilder whereBuilder) throws DbException;

    void delete(Class<?> cls) throws DbException;

    void delete(Object obj) throws DbException;

    void deleteById(Class<?> cls, Object obj) throws DbException;

    void dropDb() throws DbException;

    void dropTable(Class<?> cls) throws DbException;

    void execNonQuery(String str) throws DbException;

    void execNonQuery(SqlInfo sqlInfo) throws DbException;

    Cursor execQuery(String str) throws DbException;

    Cursor execQuery(SqlInfo sqlInfo) throws DbException;

    int executeUpdateDelete(String str) throws DbException;

    int executeUpdateDelete(SqlInfo sqlInfo) throws DbException;

    <T> List<T> findAll(Class<T> cls) throws DbException;

    <T> T findById(Class<T> cls, Object obj) throws DbException;

    List<DbModel> findDbModelAll(SqlInfo sqlInfo) throws DbException;

    DbModel findDbModelFirst(SqlInfo sqlInfo) throws DbException;

    <T> T findFirst(Class<T> cls) throws DbException;

    DaoConfig getDaoConfig();

    SQLiteDatabase getDatabase();

    <T> TableEntity<T> getTable(Class<T> cls) throws DbException;

    void replace(Object obj) throws DbException;

    void save(Object obj) throws DbException;

    boolean saveBindingId(Object obj) throws DbException;

    void saveOrUpdate(Object obj) throws DbException;

    <T> Selector<T> selector(Class<T> cls) throws DbException;

    int update(Class<?> cls, WhereBuilder whereBuilder, KeyValue... keyValueArr) throws DbException;

    void update(Object obj, String... strArr) throws DbException;
}
