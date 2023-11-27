package com.project.myquotesapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context : Context) : ViewModel() {
    private var quoteList : Array<Quotes> = emptyArray()
    private var idx = 0

    init {
        quoteList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quotes> {
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<Quotes>::class.java)
    }
    fun getQuote() = quoteList[idx]
    fun nextQuote() = quoteList[++idx]
    fun prevQuote() = quoteList[--idx]

}