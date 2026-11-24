package com.example.componentesbasicosii

data class Persona(val nombre: String, val estado: String, val ciudad: String, val deporte: Boolean,val edad: Int) : SerVivo(),
    ISimpatico
{
 override fun morir() {
        if(edad>100) {
            vivo=false
        }
    }

    override fun saludar() ="Hola triplesapohijueputa lambebicho soy ${nombre}"
    override fun toString(): String = nombre
}
