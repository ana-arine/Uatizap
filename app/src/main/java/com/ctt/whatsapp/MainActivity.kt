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

//        PASSOS PARA SE CRIAR UMA RECYCLERVIEW
//                1. TENHA EM MÃOS OS SEUS DADOS (UMA MUTABLELISTOF POR EXEMPlO)
//                2. JÁ TENHA CRIADO A RECYCLERVIEW EM SEU XML
//                3. JÁ TENHA CRIADO O ITEM DA SUA LISTA EM XML
//                4. CRIE O SEU ADAPTER, INDIQUE QUE O ITEM DA SUA EM XML É O ITEM DA RECYCLERVIEW VIA ONCREATEVIEWHOLDER
//                5. CRIE SUA CLASSE VIEWHOLDER, ENCONTRE OS ITENS EM SEU XML COM FINDVIEWBYID
//                6. VINCULE OS DADOS PASSADOS VIA ADAPTER AOS COMPONENTES VIA ONBINDVIEWHOLDER
//                7. VINCULE O ADAPTER DA SUA RECYCLERVIEW A UMA INSTANCIA DA SUA CLASSE ADAPTER COM SEUS DADOS
//                8. VINCULE UM GERENCIADOR DE LAYOUT (LAYOUT MANAGER) A SUA RECYCLERVIEW

        //DADOS
        val listaConversa = mutableListOf<Contato>(
                Contato(imagem = null, nome = "Bruno", ultimaMensagem = "Amanhã é sábado!!", horarioMensagem = "8:01 PM"),
                Contato(imagem = null, nome = "Ruth", ultimaMensagem = "Vai descansar kkkkk", horarioMensagem = "8:05 PM"),
                Contato(imagem = null, nome = "Jose", ultimaMensagem = "Beatles forever", horarioMensagem = "8:06 PM"),
                Contato(imagem = null, nome = "Bruno", ultimaMensagem = "Amanhã é sábado!!", horarioMensagem = "8:01 PM"),
                Contato(imagem = null, nome = "Ruth", ultimaMensagem = "Vai descansar kkkkk", horarioMensagem = "8:05 PM"),
                Contato(imagem = null, nome = "Jose", ultimaMensagem = "Beatles forever", horarioMensagem = "8:06 PM")

        )

        val rvConversas = findViewById<RecyclerView>(R.id.listaContatos)
        val addContato = findViewById<Button>(R.id.btnAddContato)

        val adapterContato = ConversasAdapter(listaConversa)  //Se for usar o companion object, coloco aqui a listaConversaEstatica no lugar de listaConversa.
        rvConversas.adapter = adapterContato   // agora minha lista vai ter alguém pra vincular esses 2 caras
        //(lista de contato e item da lista)

        addContato.setOnClickListener{
//            onBackPressed()   // Pra voltar tela
            adapterContato.adicionarContato(
                    Contato(imagem = null, nome = "Ana", ultimaMensagem = "Vou desinstalar o IntelliJ! Misericórdia.", horarioMensagem = "7:00 PM")
            )
        }

        //1. LinearLayout = Dispor os elementos em coluna única na vertical (padrão) OU horizontal
        //2. GridLayout = Dispor os elementos em mais de uma coluna, como uma tabela
        //3. StaggeredGridLayout = Dispor os elementos em mais de uma coluna, sem tamanho fixo (ex: Pinterest)

        //val exemploAchandoUmaRecyclerviewComKotlim = listaContatos
        //Gerenciador de layout, pra dispor os contatos (por padrão, é na vertical)
        rvConversas.layoutManager = LinearLayoutManager(this)
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