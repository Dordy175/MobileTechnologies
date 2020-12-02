package com.example.intent_demo

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnMap = findViewById<Button>(R.id.btnMap)
        val btnWeb = findViewById<Button>(R.id.btnWeb)
        val btnEvent = findViewById<Button>(R.id.btnEvent)
        val ptNumber = findViewById<EditText>(R.id.ptNumber)
        val ptAddress = findViewById<EditText>(R.id.ptAdress)
        val ptWeb = findViewById<EditText>(R.id.ptWeb)
        val ptDay = findViewById<EditText>(R.id.ptDay)
        val ptMonth = findViewById<EditText>(R.id.ptMonth)
        val ptYear = findViewById<EditText>(R.id.ptYear)


        btnEvent.setOnClickListener {
            var month = 1
            var year = 2020
            var day = 5


            if (ptMonth.text.toString().isNullOrEmpty() || ptYear.text.toString().isNullOrEmpty() || ptDay.text.toString().isNullOrEmpty()){
                day = 23
                month = 10
                year = 2020
            } else{
                day = ptMonth.text.toString().toInt()
                month = ptYear.text.toString().toInt()
                year = ptDay.text.toString().toInt()
            }




//      Tenhle kod mi moc nefungoval



            /* val now = Calendar.getInstance()
             var eYear = now.get(Calendar.YEAR)
             var eMonth = now.get(Calendar.MONTH)
             var eDay = now.get(Calendar.DAY_OF_MONTH)
             val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {view, year, month, dayOfMonth ->
                 eYear = year; eMonth = month ; eDay = dayOfMonth
             },
                 now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)

             )
             datePicker.show()


             Toast.makeText(this, eDay + eMonth + eYear,Toast.LENGTH_LONG)*/



            startActivity(Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI).apply {
                val beginTime: Calendar = Calendar.getInstance().apply {
                    set(year, month, day, 7, 30)
                }
                val endTime = Calendar.getInstance().apply {
                    set(year, month, day, 20, 30)
                }
                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.timeInMillis)
                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.timeInMillis)
                putExtra(CalendarContract.Events.TITLE, "Ninja class")
                putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo")

            })
        }



        btnWeb.setOnClickListener {
            var webUrl = ptWeb.text.toString()
            if (webUrl.isNullOrEmpty()) {
                webUrl = "utb.cz"
            }

            val webIntent: Intent = Uri.parse("https://www." + webUrl).let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            startActivity(webIntent)
        }

        btnMap.setOnClickListener {

            var address = ptAddress.text.toString()
            if (address.isNullOrEmpty()) {
                address = "Zlin"
            }

            // Map point based on address
            val mapIntent: Intent = Uri.parse(
                "geo:0,0?q=" + address
            ).let { location ->
                // Or map point based on latitude/longitude
                // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
                Intent(Intent.ACTION_VIEW, location)
            }
            startActivity(mapIntent)

        }
// set on-click listener
        btnCall.setOnClickListener {

            var numToCall = ptNumber.text.toString()

            if (numToCall.isNullOrEmpty()) {
                numToCall = "666666666"
            }
            val callIntent: Intent = Uri.parse("tel:$numToCall").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent)
        }


    }
}