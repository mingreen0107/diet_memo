package com.example.diet_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import java.util.Calendar
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val writeButton = findViewById<ImageView>(R.id.writeBtn).setOnClickListener {

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlerDialog = mBuilder.show()

            val DateSelectBtn = mAlerDialog.findViewById<Button>(R.id.dateSelectBtn)

            DateSelectBtn?.setOnClickListener {

                val today = GregorianCalendar()
                val year : Int = today.get(Calendar.YEAR)
                val month : Int = today.get(Calendar.MONTH)
                val date : Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(view : DatePicker?, year: Int, month: Int, dayOfMonth: Int
                    ) {
                        //year.toString() + month.toString() + date.toString()
                        Log.d("MAIN", "${year}, ${month + 1}, ${dayOfMonth}")
                        DateSelectBtn.setText("${year}, ${month + 1}, ${dayOfMonth}")

                    }
                }, year, month, date)
                dlg.show()
            }
        }

    }

}