fun main(args: Array<String>) {
  foo(3)
}

fun foo(x: Int) {
  fun double(y: Int) :Int {
    return y * 2
  }
  println(double(x))
}