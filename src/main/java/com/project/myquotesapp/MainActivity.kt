package com.project.myquotesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.project.myquotesapp.ui.theme.QuotesAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this,ViewModelFactory(applicationContext))[MainViewModel :: class.java]
        setQuote(mainViewModel.getQuote())
    }

    private fun setQuote(quotes: Quotes){
        quoteText.text = quotes.text
        quoteAuthor.text = quotes.author
    }

    fun onPrevious(view: View) {
        setQuote(mainViewModel.prevQuote())
    }
    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())
    }

//    fun onShare(view: View) {
//        val intent = Intent(Intent.ACTION_SEND)
//        intent.type = "text/plain"
//        intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
//        startActivity(intent)
//    }

}
