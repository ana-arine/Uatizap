package com.ctt.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsapp.model.Contato

//Fragment, vem de fragmento
//Equivalente ao PEDAÇO de uma Activity
//A Recycler view a gente tira totalmente da Activity e traz para a Fragment.
class ContatosFragment : Fragment() {
//Posso fazer class ContatosFragment (private val listaContatos: MutableList<Contato>) : Fragment() {

//    //No OnCreate da Activity
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        }

    //OnCreate da Fragment  (equivalente ao OnCreateViewHolder da Activity)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment (infla o xml)
        return inflater.inflate(R.layout.fragment_contatos, container, false)
    }

    //Após a fragment ser criada (a view)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Toda parte lógica dos meus componentes

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

        val rvConversas = view.findViewById<RecyclerView>(R.id.listaContatos)
        //val addContato = view.findViewById<Button>(R.id.btnAddContato)

        val adapterContato = ConversasAdapter(listaConversa)  //Se for usar o companion object, coloco aqui a listaConversaEstatica no lugar de listaConversa.
        rvConversas.adapter = adapterContato   // agora minha lista vai ter alguém pra vincular esses 2 caras
        //(lista de contato e item da lista)

//        addContato.setOnClickListener{
////            onBackPressed()   // Pra voltar tela
//            adapterContato.adicionarContato(
//                Contato(imagem = null, nome = "Ana", ultimaMensagem = "Vou desinstalar o IntelliJ! Misericórdia.", horarioMensagem = "7:00 PM")
//            )
//        }

        //1. LinearLayout = Dispor os elementos em coluna única na vertical (padrão) OU horizontal
        //2. GridLayout = Dispor os elementos em mais de uma coluna, como uma tabela
        //3. StaggeredGridLayout = Dispor os elementos em mais de uma coluna, sem tamanho fixo (ex: Pinterest)


        //Gerenciador de layout, pra dispor os contatos (por padrão, é na vertical)
        rvConversas.layoutManager = LinearLayoutManager(requireContext())   //Não sabemos em qual Activity estamos, uma fragment pode ser colocada em diversos lugares
    // Como não dá pra saber em qual activity será usada, usa-se a função requireContext() (genérico) em vez de "this".

        //val exemploAchandoUmaRecyclerviewComKotlim = listaContatos

    }

}