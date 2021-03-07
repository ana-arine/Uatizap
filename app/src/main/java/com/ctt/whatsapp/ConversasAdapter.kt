package com.ctt.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsapp.model.Contato

//SEGUNDO PASSO A SER LIDO
//Adapter = Responsável por vincular os dados vindos da listaContatos ao XML item_contato (célula/item da lista)
//Item final a ser visualizado e inserido na Recycler
class ConversasAdapter(private val listaContatos: MutableList<Contato>) : RecyclerView.Adapter<ConversasAdapter.ConversaHolder>() {

    //PRIMEIRO PASSO A SER LIDO
    //É equivalente a como se fosse a ACTIVITY do item da lista
    //View Holder = Item final a ser visualizado e inserido na Recycler - o onCreate dele.

    class ConversaHolder(view: View) : RecyclerView.ViewHolder(view){
        val nomeContato: TextView = view.findViewById(R.id.txtContato)
        val ultimaMensagem: TextView = view.findViewById(R.id.txtMensagem)
        val horaMensagem: TextView = view.findViewById(R.id.txtHorario)
        val fotoContato: ImageView = view.findViewById(R.id.imgContato)

        // boa prática: fazer uma função bind view
    }

    //Adiciono um novo contato
    fun adicionarContato(novoContato: Contato){
        listaContatos.add(novoContato)
       // MainActivity.listaConversaEstatica.add(novoContato)   //Se for usar o companion object.
        //NOTIFICO o Adapter que o dataset (fonte de dados) foi alterado e que ele precisa criar o "layout" dele
        notifyDataSetChanged()
    }

    //    fun fixarContato(contatinho: Contato){
//  listaContatos.addAll()
//        listaContatos.add(0, contatinho)
//    }


    //Equivalente ao onCreate da Activity, só que no caso, da nossa célula/item da RecyclerView.

    //ViewGroup = view especial que contém outras views. A mãe (uma das) dos componentes gráficos do Android.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversaHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_contato, parent, false)

        return ConversaHolder(view)
    }  //classe Layout Inflater = Infla, através do Inflate, o item contato, passando um contexto.


    //Responsável por VINCULAR os dados (nome do objeto contato) com os componentes do xml
    //Contato da lista = texto de contato do xml
    override fun onBindViewHolder(holder: ConversaHolder, position: Int) {
        listaContatos[position].imagem?.let{
            holder.fotoContato.setImageBitmap(it)
        }
        holder.nomeContato.text = listaContatos[position].nome  //a posiçao 0 vai trazer o 1o contato, etc.
        holder.ultimaMensagem.text = listaContatos[position].ultimaMensagem
        holder.horaMensagem.text = listaContatos[position].horarioMensagem
    }

    override fun getItemCount(): Int = listaContatos.size

}

