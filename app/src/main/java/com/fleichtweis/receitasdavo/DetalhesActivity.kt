package com.fleichtweis.receitasdavo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class DetalhesActivity : AppCompatActivity() {

    private lateinit var imageReceitaDetalhes: ImageView
    private lateinit var textTituloDetalhes: TextView
    private lateinit var textTempoPreparoDetalhes: TextView
    private lateinit var textIngredientes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        imageReceitaDetalhes = findViewById(R.id.imageReceitaDetalhes)
        textTituloDetalhes = findViewById(R.id.textTituloDetalhes)
        textTempoPreparoDetalhes = findViewById(R.id.textTempoPreparoDetalhes)
        textIngredientes = findViewById(R.id.textIngredientes)

        val bundle = intent.extras
        val receita = bundle?.getParcelable<Receita>("receita")

        if (receita != null){
            imageReceitaDetalhes.setImageResource(receita.resIdImagem)
            textTituloDetalhes.text = receita.titulo
            textTempoPreparoDetalhes.text = receita.tempoPreparo

            var ingredientes = ""
            receita.ingredientes.forEach{
                ingredientes += "- $it\n"
            }
            textIngredientes.text = ingredientes
        }

    }

    fun voltar(view: View){
        finish()
    }
}