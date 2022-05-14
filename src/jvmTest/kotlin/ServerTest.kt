fun main(args: Array<String>) {
  // foo(3)
  // val getBook = ::Book
  // println(getBook("Dive into Kotlin").name)
  //
  // val bookNames = listOf(Book("Think in Java"), Book("Kotlin for Android")).map(Book::name)
  //
  // print("bookNames: $bookNames")
  // it 是单个参数的隐式名称
  listOf(1, 2, 3).forEach { echo(it)() }
}

fun echo(i: Int): () -> Unit = { println(i) }

fun foo(x: Int) {
  fun double(y: Int): Int {
    return y * 2
  }
  println(double(x))
}

// val sum: (Int, Int) -> Int = { x, y -> x + y }
// val sum = { x: Int, y: Int -> x + y }
// val sum: (Int,Int) -> Int = { x, y -> x + y }
val sum = { x: Int,
  y: Int ->
  x + y
}

class Book(val name: String)

