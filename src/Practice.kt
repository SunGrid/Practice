class Ship {

    private val bullets = arrayOf("Laser", "RailGun")

    var hitpoints = 100
        private set

    fun fire() {
        var bullet = bullets[0]

        if (hitpoints > 50) {
            bullet = bullets[1]
        }

        println("Firing $bullet")
    }

    fun takeDamage(amount: Int) {
        if (amount > 0) {
            hitpoints -= amount

            if (hitpoints < 0) {
                hitpoints = 0
            }
        }
    }
}

fun main(args: Array<String>) {

    val ship = Ship()

    // ship.hitpoints = 100 // notice that this is not accessible from the outside

    ship.fire()

    ship.takeDamage(10)
    println("ship hp= ${ship.hitpoints}")

    ship.fire()
    ship.takeDamage(50)
    println("ship hp= ${ship.hitpoints}")

    ship.fire()
    ship.takeDamage(100)
    println("ship hp= ${ship.hitpoints}")

}
