import scala.io.Source

object PartOne {
	def main(args: Array[String]) = {
		val inputPath = args(0)
		var sum = 0
		for (line <- Source.fromFile(inputPath).getLines) {
			sum = sum + score(line)
		}
		println(sum)
	}

	def score(input: String): Int = {
		// todo: trait this so that we have exhaustive pattern matching?
		input match {
			case "A X" => 3 + 1
			case "A Y" => 6 + 2
			case "A Z" => 0 + 3
			case "B X" => 0 + 1
			case "B Y" => 3 + 2
			case "B Z" => 6 + 3
			case "C X" => 6 + 1
			case "C Y" => 0 + 2
			case "C Z" => 3 + 3
			case _ => -99999999
		}
	}
}
