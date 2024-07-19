fun main() {
    helloworld()
    demo1()
    demo2()
    demo3()
    demo4()
    demo5()
    demo6Infix()
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

// for loop
fun demo3() {
    val items = listOf("app", "banana","kiw")
    for (item in items) {
        println(item)
    }
    println("--------------------------")

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }


}

// types
fun demo4() {
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }

        return null
    }

    fun getStringLength2(obj: Any): Int? {
        if (obj !is String) return null

        return obj.length
    }

    fun getStringLength3(obj: Any): Int? {
        if (obj is String && obj.length > 0) {
            return obj.length
        }

        return null
    }

    println("v1: ${getStringLength("this is ok")}")
    println("v2: ${getStringLength2("this is ok")}")
    println("v3: ${getStringLength3("this is ok")}")
}

fun demo5() {
    val a = listOf(1,2,3,4,5)
    println(a)
    println(a.filter { x -> x > 2 }) // 类似ts map

    val mp = mapOf("a" to "h", "c" to "b")
    println(mp)

    println(jc("aj"))
    println(jc("aj1"))
    println(jc("aj2"))


}

fun jc(r: String): String {
    val p: String by lazy {
        "js" + r
    }

    return p
}

fun demo6Infix() {
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")
}