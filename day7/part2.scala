import scala.io.Source
import scala.collection.immutable.ListMap

case class File(name: String, size: Int, isDirectory: Boolean) // maybe need location: String in the future?
object File {
	def unapply(s: String): Option[File] = {
		if(s.head != '$'){
			val d = s.split(" ")
			if d(0) == "dir" then Some(File(d(1), 0, true)) else Some(File(d(1), d(0).toInt, false))
		} else None
	}
}
case class Instruction(command: String, arg: String) // single args only 
object Instruction {
	def unapply(s: String): Option[Instruction] = {
		if(s.head == '$'){
			val d = s.split(" ")
			if(d(1) == "ls") then Some(Instruction(d(1), "")) else Some(Instruction(d(1), d(2)))
		} else None
	}
}


object PartTwo {	
	var pwd: List[String] = List() // stack to keep track of pwd

	def main(args: Array[String]) = {
		val inputPath = args(0)
		val directoryTable = scala.collection.mutable.Map[String, Int]("/" -> 0)

		for (line <- Source.fromFile(inputPath).getLines) {
			line match 
				case Instruction("cd", "..") => {
					pwd = pwd.tail
				}
				case Instruction("cd", arg) => {
					pwd = arg +: pwd
				}
				case Instruction("ls", _) => {}
				case Instruction(_, _) => println(s"unknown instruction: $line")
				case File(name, size, true) if !directoryTable.contains(name) => {
					// add this dir to map
					//println(s"regular directory: $line")
					directoryTable += (name -> 0)
				}
				case File(name, size, true) if directoryTable.contains(name) => {}
				case File(name, size, false) => {
					// update curr dir file in the map
					//println(s"regular file: $line")
					pwd.reverse.zipWithIndex.foreach({ 
						case (_, idx) => {
							val x = pwd.reverse.take(idx+1)
							directoryTable.updateWith(x.mkString(","))({
								case Some(x) => Some(x + size)
								case None => Some(size)
							})
						}
					})
				}
				case _ => println("unknown")
		}
		//println(directoryTable)
		//println(directoryTable.collect({case (k,v) if k != "/" => (k,v)}).values.sum)
		//println(directoryTable.collect({case (k,v) if v <= 100000 => (k,v)}).values.sum)

		// part 2
		val remainingSpace = 70000000 - directoryTable("/")
		val needToFree = 30000000-remainingSpace
		println(remainingSpace)
		val sortedMap = ListMap(directoryTable.toSeq.sortBy(_._2):_*)
		println(sortedMap)
		println(sortedMap.collectFirst({case (k, v) if v >= needToFree => v}))
	}
}

// too high 38555100