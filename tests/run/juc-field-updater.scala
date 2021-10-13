import java.util.concurrent.atomic.AtomicIntegerFieldUpdater


object Test {
  class InlineVar(initI:Int) {
    @volatile inline var i:Int = initI

    def apply():Int = i
  }
  val iUpdater = AtomicIntegerFieldUpdater.newUpdater(classOf[InlineVar], "i")
  def main(args:Array[String]):Unit = {
    val test = new InlineVar(0)
    Console.println(iUpdater.getAndIncrement(test))
    Console.println(iUpdater.getAndIncrement(test))
    Console.println(test())
  }
}
