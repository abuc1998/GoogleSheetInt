package com.example.googlesheetprojectabu

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class WriteActivity : AppCompatActivity() {
    lateinit var writeProgressLayout: RelativeLayout
    lateinit var writeProgressBar: ProgressBar
    lateinit var editBookName: EditText
    lateinit var editBookAuthor: EditText
    lateinit var editBookPrice: EditText
    lateinit var ratingBar: RatingBar
    lateinit var btnSaveToDrive: Button // Changed type from EditText to Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)


        writeProgressLayout = findViewById(R.id.writeProgressLayout)
        writeProgressBar = findViewById(R.id.writeprogressBar)
        editBookName = findViewById(R.id.editBookName)
        editBookAuthor = findViewById(R.id.editBookAuthor)
        editBookPrice = findViewById(R.id.editBookPrice)
        ratingBar = findViewById(R.id.ratingBar)
        btnSaveToDrive = findViewById(R.id.buttonSaveToDrive) // Find by ID as Button

        writeProgressLayout.visibility = View.GONE
        writeProgressBar.visibility = View.GONE



        btnSaveToDrive.setOnClickListener {
            if (editBookName.text.toString().isEmpty() or editBookAuthor.text.toString()
                    .isEmpty() or
                editBookPrice.text.toString().isEmpty() or ratingBar.rating.toString().isEmpty()
            ) {

                Toast.makeText(this@WriteActivity, "Enter All Fields", Toast.LENGTH_SHORT).show()
            } else {

                val url =
                    ""
                val stringRequest = object : StringRequest(Method.POST, url,
                    Response.Listener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()
                    }) {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["bookName"] = editBookName.text.toString()
                        params["bookAuthor"] = editBookAuthor.text.toString()
                        params["bookPrice"] = editBookPrice.text.toString()
                        params["bookRating"] = ratingBar.rating.toString()

                        return params

                    }
                }
                val queue = Volley.newRequestQueue(this@WriteActivity)
                queue.add(stringRequest)
            }

        }
    }
}
