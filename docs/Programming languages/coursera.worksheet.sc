(1 < 2) && (2 < 3)

val a = 3

if a > 2 && a < 3 then
  10
else if a > 3 then
  2
else if a > 2 then
  4
else
  8


Map("a" -> 1, "b" -> 2)

val mapper = Map.empty[String, Int] + ("a" -> 1) + ("b" -> 2)

mapper("a")

val l1 = List.empty[Int]
val l2 = 1 +: 2 +: 3 +: l1
val l3 = l2 ++ List(4, 5, 6)
val l4 = l3.filter(x => x % 2 == 0)
val result = l4.exists(x => x == l4.size)


for 
  x <- 1 to 5
  y <- x + 5 to 10
  if y % 2 == 0
yield y


val lister = List(1,2,3) ++ List(4,5,6)

lister.size
lister(Math.round(lister.size.toFloat/2))