import scala.io.Source
import scala.collection.mutable.ListBuffer

object PartOne {
	def main(args: Array[String]) = {
		val inputPath = args(0)
		var max = -99999
		var current = 0
		for (line <- Source.fromFile(inputPath).getLines) {
			if (line.isEmpty) {
				if (current > max) max = current
				current = 0
			} else {
				current = current + line.toInt
			}
		}
		println(max)
	}

}
