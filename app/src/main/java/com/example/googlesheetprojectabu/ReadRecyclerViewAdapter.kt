package com.example.googlesheetprojectabu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReadRecyclerViewAdapter(val context: ActivityRead, val bookList: ArrayList<Book> )
    :RecyclerView.Adapter<ReadRecyclerViewAdapter.ReadViewHolder>(){

        class ReadViewHolder(view: View):RecyclerView.ViewHolder(view){
            val bookName:TextView=view.findViewById(R.id.txtBookName)
            val bookAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
            val bookPrice:TextView=view.findViewById(R.id.txtBookPrice)
            val bookRating:TextView=view.findViewById(R.id.txtBookRating)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return ReadViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ReadViewHolder, position: Int) {
        holder.bookName.text=bookList[position].bookName
        holder.bookAuthor.text=bookList[position].bookAuthor
        holder.bookPrice.text=bookList[position].bookPrice.toString()
        holder.bookRating.text=bookList[position].bookRating.toString()
    }
}