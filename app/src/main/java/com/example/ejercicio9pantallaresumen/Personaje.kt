package com.example.ejercicio9pantallaresumen

import kotlin.random.Random

class Personaje {
    var nombre: String =""
    var fuerza: Int = Random.nextInt(10, 15)
    var defensa: Int = Random.nextInt(1, 5)
    var pesoMochila: Int = 100
    var vida: Int = 200
    var monedero = HashMap<Int, Int>()
    init {
        monedero.put(1, 0)
        monedero.put(5, 0)
        monedero.put(10, 0)
        monedero.put(25, 0)
        monedero.put(100, 0)}
}