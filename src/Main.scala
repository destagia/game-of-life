object Main {

 // 購入する金額
 val kingaku = 34231

 def main(args:Array[String]) {

	 var wal = new Wallet()
	 //　自分のお金 1円から10000円まで
	 wal.init(List(1,1,2,0,4,0,4,0,5))
	 println(wal.m)
	 wal.getC(List[Int](),0)
	// wal.kumi.map(println(_))

	 println(getBest(wal))

   def getBest(m:Wallet):List[Int] = {
     var ans:List[Int] = List[Int]()
     var ans_s:Int = 1000

     for (i <- (0 to wal.kumi.size-1)) {
	   var now = new Wallet()

	   now.init(wal.kumi(i))

	   if(now.sum >= kingaku){
		   var newwal = new Wallet()
		   newwal.initWith(now.sum - kingaku)
		   if (ans_s > newwal.m.sum) {
			   ans_s = newwal.m.sum
			   ans = wal.kumi(i)
		   }
   		}
     }
     return ans
     }
 }

 class Wallet () {
   val money:List[Int] = List(1,5,10,50,100,500,1000,5000,10000)
   var m:List[Int] = List[Int]()
   var kumi:List[List[Int]] = List[List[Int]]()

   def init(m0:List[Int]) { m = m0 }

   def getC(l:List[Int], nest:Int) {
     var list:List[Int] = List[Int]()
	 for (i <- (0 to m(nest))) {
	   //println(m(nest))
	   list = l :+ i
	   if (nest == 8) {
		  kumi = list :: kumi
	   } else {
		   getC(list,nest+1)}
	}
   }


   def initWith(sum0:Int) {
     var sum:Int = sum0
     m = List(0,0,0,0,0,0,0,0,0)
     var i:Int = 0
     while( sum != 0) {
    	if (money(8-i) <= sum) {
    	 sum -= money(8-i)
    	 m = m.updated(8-i, m(8-i)+1)
    	}
    	else { i += 1 }
     }
   }

   def sum():Int = (for (i <- (0 to money.size-1)) yield money(i)*m(i)).sum
 }

}