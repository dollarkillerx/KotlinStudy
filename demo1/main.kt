fun main() {
    helloworld()
    demo1()
    demo2()
}

fun helloworld() {
    println("hello world")

    val name = "Kotlin"
    val age = 3
    println("$name is ${age + 1} years old")
}

// 数据类型
fun demo1() {
    val d: Int
    d = 3
    val e: String = "hello"

    println(d)
    println(e)
}

// class
// 默认不可继承
fun demo2() {
    val dog = Dog("Buddy")
    dog.sound()

    val dog2 = Dog2("Buddy")
    dog2.sound()
}
open class Animal(val name: String) {
    open fun sound() {
        println("$name makes a sound")
    }
}

class Dog(name: String): Animal(name) {
    override fun sound() {
        super.sound()
        println("$name barks")
    }
}

// abstract 抽象类
abstract class Animal2(val name: String) {
    abstract fun sound()
}

class Dog2(name: String) : Animal2(name) {
    override fun sound() {
        println("$name barks")
    }
}

