package galassini.tecnology.modulo_5

import kotlin.random.Random

class Veiculo(public val model: String, private var initialVelocity: Long = 0, private var initialAcceleration: Long = 10) {
    private var velocity: Long = initialVelocity
    private var acceleration: Long = initialAcceleration

    init {
        if (initialVelocity < 0) {
            this.velocity = 0
        }
        if (initialAcceleration < 0) {
            this.acceleration = 0
        }
    }

    public fun increaseVelocity() {
        this.velocity += this.acceleration
    }

    public fun decreaseVelocity() {
        this.velocity -= this.acceleration
        if (this.velocity < 0) {
            this.velocity = 0
        }
    }

    public fun getCurrentVelocity(): Long {
        return this.velocity
    }
}

fun main() {
    val carro = Veiculo("Carro")

    println("Velocidade inicial: ${carro.getCurrentVelocity()}")

    val random = Random.Default
    val increment = random.nextLong(5, 15) // Aceleração aleatória entre 5 e 15

    println("Acelerando o carro em $increment")
    repeat(increment.toInt()) {
        carro.increaseVelocity()
    }
    println("Nova velocidade: ${carro.getCurrentVelocity()}")

    println("Diminuindo a velocidade do carro")
    val decrement = random.nextLong(5, 15) // Desaceleração aleatória entre 5 e 15
    repeat(decrement.toInt()) {
        carro.decreaseVelocity()
    }
    println("Nova velocidade: ${carro.getCurrentVelocity()}")
}
