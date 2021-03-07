package com.ctt.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsapp.model.Contato
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    override fun onBackPressed() {
        super.onBackPressed()
        //startActivity()
    }

    //MÉTODOS E ATRIBUTOS ESTÁTICOS - posso acessar os objetos de qqr lugar sem instanciá-los
    companion object{
        //Tudo o que estiver aqui, métodos e atributos, posso acessar sem precisar instanciar - são ESTÁTICOS
        const val CHAVE_INTENT = "chaveIntent"
        val listaConversaEstatica = mutableListOf<Contato>()
    }       // é uma das possibilidades para add contato direto no app. Existe, mas pode ser melhor que isso.
}