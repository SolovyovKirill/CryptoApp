package com.solovyov.cryptoapp


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.solovyov.cryptoapp.viewmodel.CoinViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
//        viewModel.priceList.observe(this, Observer {
//            Log.d("TEST_OF_LOADING_DATA", "Success in Activity: $it")
//        })
        viewModel.getDetailInfo("BTC").observe(this, Observer {
            Log.d("TEST_OF_LOADING_DATA", "Success in Activity: $it")
        })

    }

}