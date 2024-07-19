//class User {
//    var username = ""
//    var password = ""
//    var money: Double = 0.00
//}

import java.util.Scanner
import kotlin.concurrent.thread

class User(var username: String, var password: String, var money: Double = 0.0)

class Bank {
    private var users: MutableMap<String, User> = mutableMapOf()

    // 用户注册
    @Synchronized
    fun registerUser(username: String, password: String): Boolean {
        if (username in users) {
            println("User already exists")
            return false
        }
        users[username] = User(username, password)
        println("User registered successfully")
        return true
    }

    // 用户入金
    @Synchronized
    fun deposit(username: String, amount: Double): Boolean {
        val user = users[username]
        return if (user != null) {
            user.money += amount
            println("Deposited $amount to ${user.username}. New balance: ${user.money}")
            true
        } else {
            println("User not found")
            false
        }
    }

    // 用户出金
    @Synchronized
    fun withdraw(username: String, amount: Double): Boolean {
        val user = users[username]
        return if (user != null) {
            if (user.money >= amount) {
                user.money -= amount
                println("Withdrew $amount from ${user.username}. New balance: ${user.money}")
                true
            } else {
                println("Insufficient funds")
                false
            }
        } else {
            println("User not found")
            false
        }
    }

    // 用户转账
    @Synchronized
    fun transfer(fromUsername: String, toUsername: String, amount: Double): Boolean {
        val fromUser = users[fromUsername]
        val toUser = users[toUsername]
        return if (fromUser != null && toUser != null) {
            if (fromUser.money >= amount) {
                fromUser.money -= amount
                toUser.money += amount
                println("Transferred $amount from ${fromUser.username} to ${toUser.username}")
                true
            } else {
                println("Insufficient funds")
                false
            }
        } else {
            println("One or both users not found")
            false
        }
    }

    @Synchronized
    fun getBalance(username: String): Double {
        return users[username]?.money ?: 0.0
    }
}

fun main() {
    val bank = Bank()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Choose an operation: register, deposit, withdraw, transfer, exit")
        val operation = scanner.nextLine()

        when (operation) {
            "register" -> {
                println("Enter username:")
                val username = scanner.nextLine()
                println("Enter password:")
                val password = scanner.nextLine()
                thread {
                    bank.registerUser(username, password)
                }
            }
            "deposit" -> {
                println("Enter username:")
                val username = scanner.nextLine()
                println("Enter amount:")
                val amount = scanner.nextLine().toDouble()
                thread {
                    bank.deposit(username, amount)
                }
            }
            "withdraw" -> {
                println("Enter username:")
                val username = scanner.nextLine()
                println("Enter amount:")
                val amount = scanner.nextLine().toDouble()
                thread {
                    bank.withdraw(username, amount)
                }
            }
            "transfer" -> {
                println("Enter your username:")
                val fromUsername = scanner.nextLine()
                println("Enter recipient's username:")
                val toUsername = scanner.nextLine()
                println("Enter amount:")
                val amount = scanner.nextLine().toDouble()
                thread {
                    bank.transfer(fromUsername, toUsername, amount)
                }
            }
            "exit" -> {
                println("Exiting...")
                break
            }
            else -> {
                println("Invalid operation")
            }
        }
    }
}
