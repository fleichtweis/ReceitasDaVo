package com.fleichtweis.receitasdavo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvReceitas: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvReceitas = findViewById(R.id.rvReceitas)
        rvReceitas.adapter = ReceitaAdapter {
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", it)
            startActivity(intent)
        }

        rvReceitas.layoutManager = LinearLayoutManager(this)

        rvReceitas.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

    }
}