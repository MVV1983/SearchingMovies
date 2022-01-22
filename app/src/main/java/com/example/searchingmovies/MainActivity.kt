package com.example.searchingmovies

import Film
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.searchingmovies.interfaces.FilmInterface
import com.example.searchingmovies.presenter.FilmPresenter

class MainActivity : AppCompatActivity(), FilmInterface.FilmView {
    private var film: String? = null
    private var presenter: FilmInterface.FilmPresenter? = null
    var inputText: EditText = findViewById(R.id.edit_text)
    var button: Button = findViewById(R.id.button)
    var outputText: TextView = findViewById(R.id.text_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = FilmPresenter(this)

        button.setOnClickListener {
            film = inputText.text.toString()
            presenter?.networkcall(film!!)
        }

    }

    override fun updateViewData() {
        outputText.text = presenter?.showFilm()
    }

}