fun main(args: Array<String>) {
  // foo(3)
  val getBook = ::Book
  println(getBook("Dive into Kotlin").name)
}

fun foo(x: Int) {
  fun double(y: Int) :Int {
    return y * 2
  }
  println(double(x))
}

class Book(val name: String)

