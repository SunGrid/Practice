/* Inheritance and Polymorphism

 */
open class Enemy(health: Int, var weapon: String) {

    var health: Int = 0
        set(value){
            field = value

            if (value < 0){
                field = 0
            }
        }
    var damage: Int = 0

    init {
        //without this.health = health, passed from mian method, the var health up above will be set to 0 and run at 0
        this.health = health

        println("Enemy inint called")
    }

    //polymorphic parameter
    open fun attack(enemy: Enemy) {
        println("attacking $enemy with $weapon")
        enemy.takeDamage(damage)
    }

    fun takeDamage(damageToTake: Int) {
        health -= damageToTake
    }

}

class Pikeman(health: Int, var armor: Int) : Enemy(health, "pike") {

    init {
        println("Pikeman init called")
    }
}

class Archer(health: Int, var arrowCount: Int) : Enemy(health, "bow") {

    init {
        println("Archer init called")
    }

    override fun attack(enemy: Enemy) {
        if (arrowCount <= 0) {
            println("no more arrows")
        } else {
            super.attack(enemy)
            arrowCount--
            println("arrows left = $arrowCount")
        }
    }
}

fun main(args: Array<String>) {

    //vals being declared as "Enemy"
    val pikeman: Enemy = Pikeman(100, 100)
    pikeman.damage = 40

    val archer: Enemy = Archer(health = 100, arrowCount = 5)
    archer.damage = 60

    pikeman.attack(archer)
    println("pikeman health = ${pikeman.health} archer health = ${archer.health}")

    archer.attack(pikeman)
    println("pikeman health = ${pikeman.health} archer health = ${archer.health}")

    pikeman.attack(archer)
    println("pikeman health = ${pikeman.health} archer health = ${archer.health}")

    archer.attack(pikeman)
    println("pikeman health = ${pikeman.health} archer health = ${archer.health}")

}