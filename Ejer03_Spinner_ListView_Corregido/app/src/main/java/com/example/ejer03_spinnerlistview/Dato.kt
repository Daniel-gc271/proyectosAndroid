package com.example.ejer03_spinnerlistview

data class Dato(val dato:String,val numero:Int=0)
{
    override fun toString(): String {
        return dato + " - " + numero
    }
}
