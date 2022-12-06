import scala.io.Source

object PartOne {
	def main(args: Array[String]) = {
		val inputPath = args(0)
		var input: String = ""
		for (line <- Source.fromFile(inputPath).getLines) {
			input = line
		}
		var found = false
		var i = 0
		var stringToFind: String = ""
		while (!found) {
			val checkString = input.drop(i).take(4).distinct
			println(s"checking: $checkString")
			if(checkString.length == 4){
				println(checkString)
				stringToFind = checkString
				found = true
			} else {
				i = i + 1
			}
		}
		println(i+4)
	}
}

// 1643 too low