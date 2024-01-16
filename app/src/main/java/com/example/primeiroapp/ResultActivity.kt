package com.example.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import android.widget.TextView

class ResultActivity() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)

        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if (result in 18.5f..24.9f) {
            "NORMAL"
        } else if (result in 25f..29.9f) {
            "SOBREPESO"
        } else if (result in 30f..39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultActivity> {
        override fun createFromParcel(parcel: Parcel): ResultActivity {
            return ResultActivity(parcel)
        }

        override fun newArray(size: Int): Array<ResultActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}

