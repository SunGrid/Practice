/*
Composition = "Has relationship" (eg. Car has wheels, engine, doors, seats, etc)
where inheritance was "is relationship" (eg. Car is vehicle, dog is animal)
More flexible. Combine simple types to make more complex types

 */
// **********Component Pattern**********
interface BasicComponent

class Health(var amount: Int) : BasicComponent
class Weapon(var name: String) : BasicComponent
class Armor(var amount: Int) : BasicComponent
class Speed(var amount: Int) : BasicComponent

class MilitaryUnit(var name: String) {

    private val componentsByName = hashMapOf<String, BasicComponent>()

    fun addComponent(name: String, component: BasicComponent) = componentsByName.put(name, component)

    fun removeComponent(name: String) = componentsByName.remove(name)

    fun getComponent(name: String) : BasicComponent? =  componentsByName[name]

    override fun toString(): String {
        val componentsString= componentsByName.keys.joinToString(", ")
        return "name = $name components = $componentsString"
    }

}


fun main(){

// pikeman
    val pikemanHealth = Health(100)
    val pike = Weapon("pike")
    val pikemanArmor = Armor(100)
    val pikemanSpeed = Speed(6)

    val pikeman = MilitaryUnit("pikeman")
    pikeman.addComponent("health", pikemanHealth)
    pikeman.addComponent("weapon", pike)
    pikeman.addComponent("armor", pikemanArmor)
    pikeman.addComponent("speed", pikemanSpeed)

    println("pikeman: $pikeman")

// archer
    val archerHealth = Health(80)
    val bow = Weapon("bow")
    val archerArmor = Armor(50)

    val archer = MilitaryUnit("archer")
    archer.addComponent("health", archerHealth)
    archer.addComponent("weapon", bow)
    archer.addComponent("armor", archerArmor)

    println("archer: $archer")

// swordsman
    val swordsmanHealth = Health(100)
    val sword = Weapon("sword")
    val swordsmanArmor = Armor(75)

    val swordsman = MilitaryUnit("swordsman")
    swordsman.addComponent("health", swordsmanHealth)
    swordsman.addComponent("weapon", sword)
    swordsman.addComponent("armor", swordsmanArmor)

    println("swordsman: $swordsman")

//medic
    val medicHealth = Health(50)
    val medicSpeed = Speed(10)

    val medic = MilitaryUnit("medic")
    medic.addComponent("health", medicHealth)
    medic.addComponent("speed", medicSpeed)

    println("medic: $medic")

    val medicWeapon = medic.getComponent("weapon")
    val medicGetSpeed = medic.getComponent("speed") as Speed // cast to Speed or a null value with incure
    println("medic hasWeapon ${medicWeapon != null}, speed = ${medicGetSpeed.amount}")

    val pikemanWeapon = pikeman.getComponent("weapon") as Weapon
    val pikemanGetSpeed = pikeman.getComponent("speed") as Speed
    println("pikeman weapon = ${pikemanWeapon.name}, speed = ${pikemanGetSpeed.amount}")
}