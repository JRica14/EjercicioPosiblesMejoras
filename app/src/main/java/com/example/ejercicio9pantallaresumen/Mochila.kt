package com.example.ejercicio9pantallaresumen

class Mochila(private var pesoMochila: Int) : java.io.Serializable{
    private var contenido=ArrayList<Articulo>()

    fun getPesoMochila():Int{
        return pesoMochila
    }
    fun addArticulo(articulo:Articulo):String{
        if (articulo.getPeso()<=pesoMochila){
            contenido.add(articulo)
            this.pesoMochila-=articulo.getPeso()
            return "Objeto añadido"
        }else{
            return "Objeto no añadido, demasiado pesado"
        }


    }
    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }

}

class Articulo (private var vida:Int, private var peso:Int, private var valor:Int) : java.io.Serializable{

    fun getPeso():Int{
        return peso
    }
    fun getVida():Int{
        return vida
    }

    override fun toString(): String {
        return "[ID:$vida, Peso:$peso, Valor:$valor]"
    }
}