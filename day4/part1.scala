import scala.io.Source

object PartOne {
	def main(args: Array[String]) = {
		val inputPath = args(0)
		var count = 0
		for (line <- Source.fromFile(inputPath).getLines) {
			val sections = line.split(",")
			val section1 = sections(0)
			val section2 = sections(1)

			// section 1 gen numbers
			val s1split = section1.split("-")
			val s1bottom: Int = s1split(0).toInt
			val s1top: Int = s1split(1).toInt

			// section 2 gen numbers
			val s2split = section2.split("-")
			val s2bottom: Int = s2split(0).toInt
			val s2top: Int = s2split(1).toInt

			// logic
			// does s2 fit in s1
			if (s2bottom >= s1bottom && s2top <= s1top) {
				count = count + 1
			} else if (s1bottom >= s2bottom && s1top <= s2top) {
				count = count + 1
			}
		}
		println(count)
	}
}

// 867 too high
// 437 too low
// 523 too high
// 505 incorrect
// 459 LMAO <- needed to convert to int