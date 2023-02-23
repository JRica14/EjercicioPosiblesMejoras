package com.example.ejercicio9pantallaresumen

import android.widget.Toast
import kotlin.random.Random

class Personaje : java.io.Serializable{
    var nombre: String =""
    var fuerza: Int = Random.nextInt(10, 30)
    var defensa: Int = Random.nextInt(1, 6)
    var pesoMochila: Int = 200
    var mochilaP= Mochila(pesoMochila)
    var vida: Int = 200
    var monedero = HashMap<Int, Int>()
    init {
        monedero.put(1, 0)
        monedero.put(5, 0)
        monedero.put(10, 0)
        monedero.put(25, 0)
        monedero.put(100, 0)}

    fun cashConverter(articulo: Articulo){
        var total = 0
        var i = 0
        var coins = arrayListOf(1, 5, 10, 25, 100)
        coins.sortDescending()

        while(total < articulo.getValor() && i < coins.size) {
            if (total + coins[i] <= articulo.getValor()) {
                total += coins[i]
                monedero[coins[i]] = monedero[coins[i]]!! + 1
            } else
                i++
        }
        mochilaP.quitarArticulos(articulo)
    }

    fun venta(numero:Int, articulo: Articulo ):String{
        if (numero>mochilaP.getContenido().size)
            return "No dispones de tantos Articulos"

        repeat(numero){
            cashConverter(articulo)
        }
         return "Venta de articulos, Realizada"
    }

    fun compra(numero: Int, articulo: Articulo):String{
        repeat(numero){
            mochilaP.addArticulo(articulo)
        }
        return "Compra Realizada"
    }
}