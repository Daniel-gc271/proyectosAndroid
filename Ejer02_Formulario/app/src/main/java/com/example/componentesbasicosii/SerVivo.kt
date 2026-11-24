package com.example.componentesbasicosii

open class SerVivo(var vivo: Boolean=true)
{
   open fun morir() {
        vivo =false
    }

    fun nacer() {
        vivo=true


    }


}
