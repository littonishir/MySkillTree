package com.litton.parkclient

import android.content.ContentValues
import android.database.ContentObserver
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val parkUri1 = "content://com.litton.ParkContentProvider/park1"
    private val parkUri2 = "content://com.litton.ParkContentProvider/park2"
    val uriParse1 = Uri.parse(parkUri1)
    val uriParse2 = Uri.parse(parkUri2)
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        text = findViewById(R.id.text)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        contentResolver.registerContentObserver(uriParse1,true,object :ContentObserver(Handler(mainLooper)){
            override fun onChange(selfChange: Boolean) {
                super.onChange(selfChange)
                Log.i("log_tag", "onChange selfChange:$selfChange")
            }

        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                val contentValues = ContentValues()


                contentValues.put("_id", 66+ Math.random())
                contentValues.put("name", "人民公园")
                contentResolver.insert(uriParse1, contentValues)
                queryPark(uriParse1)
            }

            R.id.button3 -> {
                val contentValues = ContentValues()
                contentValues.put("_id", 66)
                contentValues.put("name", "华夏公园")
                contentResolver.update(uriParse1, contentValues, "_id=?", arrayOf("66"))
                queryPark(uriParse1)
            }

            R.id.button5 -> {
                contentResolver.delete(uriParse1, "_id=?", arrayOf("66"))
                queryPark(uriParse1)
            }

            R.id.button2 -> {
                val contentValues = ContentValues()
                contentValues.put("_id", 88)
                contentValues.put("name", "万妖朝公园")
                contentResolver.insert(uriParse2, contentValues)
                queryPark(uriParse2)
            }

            R.id.button4 -> {
                val contentValues = ContentValues()
                contentValues.put("_id", 1)
                contentValues.put("name", "如是公园")
                contentResolver.update(uriParse2, contentValues, "_id=?", arrayOf("1"))
                queryPark(uriParse2)
            }

            R.id.button6 -> {
                contentResolver.delete(uriParse2, "_id=?", arrayOf("1"))
                queryPark(uriParse2)
            }
        }
    }

    private fun queryPark(uri: Uri) {
        var mData = ""
        val cursor = contentResolver.query(uri, arrayOf("_id", "name"), null, null, null)
        while (cursor?.moveToNext() == true) {
            mData += "query park:${cursor.getInt(0)} ${cursor.getString(1)}\n"
        }
        cursor?.close()
        text.text = mData
    }
}