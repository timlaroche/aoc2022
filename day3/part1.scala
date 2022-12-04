import scala.io.Source

object PartOne {
	def main(args: Array[String]) = {
		val inputPath = args(0)
		val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		var sum = 0
		for (line <- Source.fromFile(inputPath).getLines) {
			val chars = line.toCharArray()
			val length = chars.length
			//val compartmentOne = chars.slice(0,(length/2))
			//val compartmentTwo = chars.slice((length/2), length)
			val compartmentOneSet = chars.slice(0,length/2).toSet
			val compartmentTwoSet = chars.slice((length/2), length).toSet
			val overlap = compartmentOneSet & compartmentTwoSet
			val x: Char = overlap.head
			sum = sum + (alphabet.indexOf(x)+1)
			//println(s"sack: ${line} ;; length: ${length} ;; ompartmentOne: ${compartmentOne.length} ;; compartmentTwo: ${compartmentTwo.length} ;; overlap: ${overlap}")
		}
		println(sum)
	}
}
// todo learnings: how are sets represented in comp sci?

