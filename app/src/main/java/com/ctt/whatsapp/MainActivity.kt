package com.ctt.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.ctt.whatsapp.model.Contato
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. VINCULAMOS AS FRAGMENTS A VIEWPAGER
        //2. VINCULAMOS A VIEWPAGER AO TABLAYOUT

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        //startActivity()
//    }
//
//    //MÉTODOS E ATRIBUTOS ESTÁTICOS - posso acessar os objetos de qqr lugar sem instanciá-los
//    companion object{
//        //Tudo o que estiver aqui, métodos e atributos, posso acessar sem precisar instanciar - são ESTÁTICOS
//        const val CHAVE_INTENT = "chaveIntent"
//        val listaConversaEstatica = mutableListOf<Contato>()
//    }       // é uma das possibilidades para add contato direto no app. Existe, mas pode ser melhor que isso.

}