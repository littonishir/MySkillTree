package com.litton.parkservice

import android.content.*
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.util.Log
import com.litton.parkservice.Constant.PARK1_TABLE_NAME
import com.litton.parkservice.Constant.PARK1_URI_CODE
import com.litton.parkservice.Constant.PARK2_TABLE_NAME
import com.litton.parkservice.Constant.PARK2_URI_CODE
import com.litton.parkservice.Constant.ParkAuthority
import com.litton.parkservice.Constant.Log_Tag

class ParkContentProvider : ContentProvider() {
    lateinit var mContext: Context
    lateinit var mDBHelper: ParkDBHelper
    lateinit var db: SQLiteDatabase
    var mUriMatcher: UriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    /**
     * 若URI资源路径 = content://com.litton.ParkContentProvider/park1 则返回注册码 PARK1_URI_CODE
     * 若URI资源路径 = content://com.litton.ParkContentProvider/park2 则返回注册码 PARK2_URI_CODE
     */
    init {
        mUriMatcher.addURI(ParkAuthority, PARK1_TABLE_NAME, PARK1_URI_CODE)
        mUriMatcher.addURI(ParkAuthority, PARK2_TABLE_NAME, PARK2_URI_CODE)
    }

    /**
     * 初始化两个表的数据(先清空两个表,再各加入两个记录)
     */
    override fun onCreate(): Boolean {
        mContext = context!!
        mDBHelper = ParkDBHelper(mContext)
        db = mDBHelper.writableDatabase
        db.execSQL("delete from $PARK1_TABLE_NAME")
        db.execSQL("insert into $PARK1_TABLE_NAME values(1,'里克公园');")
        db.execSQL("insert into $PARK1_TABLE_NAME values(2,'帕姆公园');")
        db.execSQL("delete from $PARK2_TABLE_NAME")
        db.execSQL("insert into $PARK2_TABLE_NAME values(1,'福地公园');")
        db.execSQL("insert into $PARK2_TABLE_NAME values(2,'索菲公园');")
        Log.i(Log_Tag, "ParkContentProvider onCreate")
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val tableName = getTableName(uri)
        return db.query(
            tableName,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder,
            null
        )
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri {
        val tableName = getTableName(uri)
        db.insert(tableName, null, values)
        mContext.contentResolver.notifyChange(uri, null)
        Log.i(Log_Tag, "insert uri:$uri ContentValues:$values")
        return uri
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val tableName = getTableName(uri)
        Log.i(Log_Tag, "delete uri:$uri selection:$selection Args：${selectionArgs.toString()}")
        return db.delete(tableName, selection, selectionArgs)
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        val tableName = getTableName(uri)
        Log.i(Log_Tag, "update uri:$uri values:$values selection:$selection Args：${selectionArgs.toString()}")
        return db.update(tableName, values,selection,selectionArgs)
    }

    /**
     * 根据URI匹配 URI_CODE
     * 从而匹配ContentProvider中相应的表名
     */
    private fun getTableName(uri: Uri): String {
        return when (mUriMatcher.match(uri)) {
            PARK1_URI_CODE -> PARK1_TABLE_NAME
            PARK2_URI_CODE -> PARK2_TABLE_NAME
            else -> ""
        }
    }
}