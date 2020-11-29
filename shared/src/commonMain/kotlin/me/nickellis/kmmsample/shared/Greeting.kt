package me.nickellis.kmmsample.shared

object FOO {

}

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform} ${FOO.toString()}!"
    }
}
