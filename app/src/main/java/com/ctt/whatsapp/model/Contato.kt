package com.ctt.whatsapp.model

import android.graphics.Bitmap

data class Contato(var imagem: Bitmap? = null,
                   val nome: String,
                   val ultimaMensagem: String,
                   val horarioMensagem: String)
