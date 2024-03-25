package com.example.googlesheetprojectabu

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class WriteActivity : AppCompatActivity() {
    private lateinit var writeProgressLayout: RelativeLayout
    private lateinit var writeProgressBar: ProgressBar
    private lateinit var editBookName: EditText
    private lateinit var editBookAuthor: EditText
    private lateinit var editBookPrice: EditText
    private lateinit var ratingBar: RatingBar
    private lateinit var btnSaveToDrive: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        writeProgressLayout = findViewById(R.id.writeProgressLayout)
        writeProgressBar = findViewById(R.id.writeprogressBar)
        editBookName = findViewById(R.id.editBookName)
        editBookAuthor = findViewById(R.id.editBookAuthor)
        editBookPrice = findViewById(R.id.editBookPrice)
        ratingBar = findViewById(R.id.ratingBar)
        btnSaveToDrive = findViewById(R.id.buttonSaveToDrive)

        writeProgressLayout.visibility = View.GONE
        writeProgressBar.visibility = View.GONE

        btnSaveToDrive.setOnClickListener {
            val bookName = editBookName.text.toString()
            val bookAuthor = editBookAuthor.text.toString()
            val bookPrice = editBookPrice.text.toString()
            val bookRating = ratingBar.rating.toString()

            if (bookName.isEmpty() || bookAuthor.isEmpty() || bookPrice.isEmpty() || bookRating.isEmpty()) {
                Toast.makeText(this@WriteActivity, "Enter All Fields", Toast.LENGTH_SHORT).show()
            } else {


                writeProgressLayout.visibility = View.VISIBLE
                writeProgressBar.visibility = View.VISIBLE
                val url = "https://script.google.com/macros/s/AKfycbzKVlfbaKMWmAsCdzqR4MzJ7i09ncnGo9PEQjg8Lj8pWO2PSFLOPSVA1U6vb6uhYTmXVg/exec"
                val stringRequest = object : StringRequest(Method.POST, url,
                    Response.Listener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()

                        writeProgressLayout.visibility = View.GONE
                        writeProgressBar.visibility = View.GONE
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()

                        writeProgressLayout.visibility = View.GONE
                        writeProgressBar.visibility = View.GONE
                    }) {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["bookName"] = bookName
                        params["bookAuthor"] = bookAuthor
                        params["bookPrice"] = bookPrice
                        params["bookRating"] = bookRating
                        return params
                    }
                }
                val queue = Volley.newRequestQueue(this@WriteActivity)
                queue.add(stringRequest)
            }
        }
    }
}
