package com.fleichtweis.receitasdavo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ReceitaAdapter(
    private val onClick: (Receita) -> Unit
): RecyclerView.Adapter<ReceitaAdapter.ReceitaViewHolder>() {

    private val receitas = DadosReceita.recuperarReceitas()

    inner class ReceitaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val imageReceita: ImageView
        private val textTitulo: TextView
        private val textTempoPreparo: TextView

        init {
            imageReceita = itemView.findViewById(R.id.imageReceita)
            textTitulo = itemView.findViewById(R.id.textTitulo)
            textTempoPreparo = itemView.findViewById(R.id.textTempoPreparo)
        }

        fun bind(receita: Receita, onClick: (Receita) -> Unit) {

            itemView.setOnClickListener {
                onClick(receita)
            }

            textTitulo.text = receita.titulo
            textTempoPreparo.text = receita.tempoPreparo
            imageReceita.setImageDrawable(ContextCompat.getDrawable(itemView.context, receita.resIdImagem))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_receita, parent, false)
        return ReceitaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReceitaViewHolder, position: Int) {

        val receita = receitas[position]
        holder.bind(receita, onClick)
    }

    override fun getItemCount(): Int {
        return receitas.size
    }

}