import scala.io.Source
import scala.collection.mutable.LinkedHashMap

object PartTwo {
	case class Instruction(origin: Int, target: Int, number: Int)

	def main(args: Array[String]) = {
		val inputPath = args(0)
		// hardcoded lol
		// 		           [V]     [C]     [M]
		// [V]     [J]     [N]     [H]     [V]
		// [R] [F] [N]     [W]     [Z]     [N]
		// [H] [R] [D]     [Q] [M] [L]     [B]
		// [B] [C] [H] [V] [R] [C] [G]     [R]
		// [G] [G] [F] [S] [D] [H] [B] [R] [S]
		// [D] [N] [S] [D] [H] [G] [J] [J] [G]
		// [W] [J] [L] [J] [S] [P] [F] [S] [L]
		//  1   2   3   4   5   6   7   8   9 

		var one = List[Char]('V', 'R', 'H', 'B', 'G', 'D', 'W')
		var two = List[Char]('F', 'R', 'C', 'G', 'N', 'J')
		var three = List[Char]('J', 'N', 'D', 'H', 'F', 'S', 'L')
		var four = List[Char]('V', 'S', 'D', 'J')
		var five = List[Char]('V', 'N', 'W', 'Q', 'R', 'D', 'H', 'S')
		var six = List[Char]('M', 'C', 'H', 'G', 'P')
		var seven = List[Char]('C', 'H', 'Z', 'L', 'G', 'B', 'J', 'F')
		var eight = List[Char]('R', 'J', 'S')
		var nine = List[Char]('M', 'V', 'N', 'B', 'R', 'S', 'G', 'L')

		// var one = List('N', 'Z')
		// var two = List('D', 'C', 'M')
		// var three = List('P')

		var registeredStacks = LinkedHashMap[Int, List[Char]](
			1 -> one,
			2 -> two,
			3 -> three,
			4 -> four,
			5 -> five,
			6 -> six,
			7 -> seven,
			8 -> eight,
			9 -> nine
		)

		for (line <- Source.fromFile(inputPath).getLines) {
			val split = line.split("from")
			val number = split(0).split(" ")(1).trim().toInt
			val origin = split(1).split("to")(0).trim().toInt
			val target = split(1).split("to")(1).trim().toInt

			println(s"move $number from $origin to $target")
			println(s"current origin: ${registeredStacks(origin)}")
			println(s"current target: ${registeredStacks(target)}")

			val x = registeredStacks(origin).take(number)
			registeredStacks(origin) = registeredStacks(origin).drop(number)
			registeredStacks(target) = registeredStacks(target).prependedAll(x)

			println(s"moving $x")
			
			println(s"post origin: ${registeredStacks(origin)}")
			println(s"post target: ${registeredStacks(target)}")
			
			//val instruction = Instruction(origin, target, number)
			// instruction match {
			// case Instruction(1, target, number) =>
			// 	val x = one.take(number)
			// 	registeredStacks(1)
			// case Instruction(2, target, number) => ???
			// case Instruction(3, target, number) => ???
			// case Instruction(4, target, number) => ???
			// case Instruction(5, target, number) => ???
			// case Instruction(6, target, number) => ???
			// case Instruction(7, target, number) => ???
			// case Instruction(8, target, number) => ???
			// case Instruction(9, target, number) => ???

			// }
		}

		registeredStacks.map((_, x) => print(x.head))
	}
}