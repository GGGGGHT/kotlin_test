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
  val foo1 = foo1(3)
  println(foo1(2))
  println(sum(1, 2, 3))
  println(sum1(1)(2)(3))

  // 可以省略()
  omitParentheses {
    println("hello")
  }

  curryingLike("looks like currying style") {
    println(it)
  }

  curryingLike("looks like currying style", {
    println(it)
  })

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
val sum = { x: Int, y: Int ->
  x + y
}

/**
 * 返回一个类型为(Int) -> Int 的函数
 * 柯里化指的是把接收多个参数的函数变换成一系列仅接收单一函数参数的过程
 */
fun foo1(x: Int) = { y: Int -> x + y }

fun sum(x: Int, y: Int, z: Int) = x + y + z
fun sum1(x: Int) = { y: Int -> { z: Int -> x + y + z } }
class Book(val name: String)

fun omitParentheses(block: () -> Unit) {
  block()
}

fun curryingLike(content: String, block: (String) -> Unit) {
  block(content)
}