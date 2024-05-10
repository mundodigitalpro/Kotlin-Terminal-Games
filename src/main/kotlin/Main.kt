package dev.josejordan
import java.util.Scanner
import kotlin.random.Random

fun main() {

//piedraPapelTijera()

    numeroSecreto()

}

private fun numeroSecreto() {
    val numeroSecreto = Random.nextInt(1, 101) // Genera un número aleatorio entre 1 y 100
    var intentos = 0

    println("¡Bienvenido al juego de adivinanza de números!")
    println("Intenta adivinar un número entre 1 y 100.")

    while (true) {
        print("Introduce tu intento: ")
        val intento = readLine()?.toIntOrNull()

        if (intento == null) {
            println("Por favor, introduce un número válido.")
            continue
        }

        intentos++

        if (intento < numeroSecreto) {
            println("El número que buscas es mayor que $intento. Intenta de nuevo!")
        } else if (intento > numeroSecreto) {
            println("El número que buscas es menor que $intento. Intenta de nuevo!")
        } else {
            println("¡Enhorabuena! Has adivinado el número secreto en $intentos intentos.")
            break
        }
    }
}

private fun piedraPapelTijera() {
    val scanner = Scanner(System.`in`)
    val opciones = arrayOf("Piedra", "Papel", "Tijera")

    while (true) {
        println("Elige una opción: (1) Piedra, (2) Papel, (3) Tijera, (0) Salir")
        print("Tu elección: ")
        val eleccionUsuario = scanner.nextInt()

        if (eleccionUsuario == 0) {
            println("Gracias por jugar. ¡Hasta la próxima!")
            break
        }

        if (eleccionUsuario < 1 || eleccionUsuario > 3) {
            println("Opción inválida, por favor elige 1, 2, 3 o 0 para salir.")
            continue
        }

        val eleccionComputadora = (1..3).random()
        println("Tu elegiste: ${opciones[eleccionUsuario - 1]}")
        println("La computadora eligió: ${opciones[eleccionComputadora - 1]}")

        when {
            eleccionUsuario == eleccionComputadora -> println("Empate!")
            (eleccionUsuario % 3) + 1 == eleccionComputadora -> println("¡Ganaste!")
            else -> println("Perdiste. ¡Inténtalo de nuevo!")
        }

        println()
    }
}