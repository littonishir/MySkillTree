package com.litton.parkservice

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.litton.parkservice.Constant.PARK1_TABLE_NAME
import com.litton.parkservice.Constant.PARK2_TABLE_NAME
import com.litton.parkservice.Constant.PARK_DATABASE_NAME
import com.litton.parkservice.Constant.PARK_DATABASE_VERSION

class ParkDBHelper(context: Context?) :
    SQLiteOpenHelper(context, PARK_DATABASE_NAME, null, PARK_DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        /**
         * 创建两个表格:公园表1 和 公园表2
         */
        db.execSQL("CREATE TABLE IF NOT EXISTS $PARK1_TABLE_NAME(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)")
        db.execSQL("CREATE TABLE IF NOT EXISTS $PARK2_TABLE_NAME(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

}