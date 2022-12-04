import scala.io.Source

object PartTwo {
	def main(args: Array[String]) = {
		val inputPath = args(0)
		val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		var sum = 0
		for (line <- Source.fromFile(inputPath).getLines.grouped(3)) {
			val bagOne = line(0)
			val bagTwo = line(1)
			val bagThree = line(2)
			val bagOneSet = bagOne.toSet
			val bagTwoSet = bagTwo.toSet
			val bagThreeSet = bagThree.toSet
			val overlap = bagOneSet & bagTwoSet & bagThreeSet
			val x: Char = overlap.head
			println(x)
			sum = sum + (alphabet.indexOf(x)+1)
		}
		println(sum)
	}
}