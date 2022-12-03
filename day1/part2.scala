import scala.io.Source
import scala.collection.mutable.ListBuffer

object PartTwo {
  def main(args: Array[String]) = {
    val inputPath = args(0)
    var max = -99999
    var current = 0
    var allElves = new ListBuffer[Int]()
    for (line <- Source.fromFile(inputPath).getLines) {
      if (line.isEmpty) {
        allElves += current
        current = 0
      } else {
        current = current + line.toInt
      }
    }
    val one::two::three::tail = allElves.toList.sorted(Ordering.Int.reverse)
    print(one+two+three)
  }

}
