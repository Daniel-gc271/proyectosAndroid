package gregoriofer.local.ejer03_spinner_listview

data class Registro(var nombre: String, var edad: Int)
{
    override fun toString(): String {
        return nombre + " " + edad
    }
}
