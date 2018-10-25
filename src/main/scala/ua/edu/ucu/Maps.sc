val m = Map('C' -> "Carbon",'H' -> "Hydrogen")
// Finding the element associated to a key in a map, with default value
m.getOrElse('K',"Unknown")
// Adding an association in a map
val m1= m + ('O' -> "Oxygen")

for((k,v) <- m1) {
  print(k)
  print(" -> ")
  print(v)
  println
}