package com.imastudio.portalberita

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.imastudio.portalberita.adapter.BeritaAdapter
import com.imastudio.portalberita.model.ResponseBerita
import com.imastudio.portalberita.network.InitRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get data dari server / API
        getBeritaFromNetwork()
    }

    private fun getBeritaFromNetwork() {
        var country = "id"
        var api = "735732b99dce43aa88beb0b4c356cadd"
        //menampilkan loading saat proses get Data ke Server
        var loading = ProgressDialog.show(this, "Process GET DATA", "Loading...")
        InitRetrofit.getInstance().getDataBerita(country, api).enqueue(
            object : Callback<ResponseBerita> {
                override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                    Log.d("ERROR", t.localizedMessage)
                    loading.dismiss()
                }

                override fun onResponse(call: Call<ResponseBerita>, response: Response<ResponseBerita>) {
                    if (response.isSuccessful) {
                        var status = response.body()?.status
                        if (status.equals("OK")) {
                            Toast.makeText(this@MainActivity, "ADA DATA", Toast.LENGTH_SHORT).show()
                            var dataBerita = response.body()?.articles
                            var adapter = BeritaAdapter(this@MainActivity, dataBerita)
                            recyclerView.adapter = adapter
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        }else {
                            Toast.makeText(this@MainActivity, "TIDAK ADA DATA", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        )
    }
}