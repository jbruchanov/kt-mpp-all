expect class Platform() {
    fun name() : String
}

class Greetings {
    fun greet() = Platform().name()
}