package tagia

object Matrix {

  /* �t�B�[���h�����o�[ */
  var Matrix = Seq(Seq(0))

  /* ���\�b�h */

  def makeMatrix(x: Int, y: Int) = {
    
    def makeSeqSeq(): Seq[Seq[Int]] =
      for (i <- (0 to x))
        yield for (j <- (0 to y))
        yield 0

    Matrix = makeSeqSeq()

  }

  def show(matrix: List[List[Int]]): Unit = {
    for (row <- matrix) {
      println(row.mkString(" "))
    }
  }

  def getList(a: Int, b: Int, c: Int) = List(a, b, c)

  def getNeighborsState(row: Int, col: Int, matrix: Seq[Seq[Int]]): Seq[Int] = {
    for (x <- -1 to 1; y <- -1 to 1 if (x != 0 || y != 0)) yield {
      if ((x + row < 0) || (x + row > matrix.length - 1) || (y + col < 0) || (y + col >
        matrix.length - 1))
        0
      else
        matrix(row + x)(col + y)
    }
  }

  def getNextCellState(current: Int, neighbors: Seq[Int]): Int = {
    if (current == 1)
      if (neighbors.count(_ == 1) == 2 || neighbors.count(_ == 1) == 3) 1
      else 0
    else if (neighbors.count(_ == 1) == 3) 1 else 0
  }

  def retrans() = {
    def trans(matrix: Seq[Seq[Int]]): Seq[Seq[Int]] = {
      for (row <- 0 until matrix.size) 
        yield for (col <- 0 until matrix.size) 
          yield getNextCellState(matrix(row)(col), getNeighborsState(row, col, matrix))
    }
    Matrix = trans(Matrix)
  }

  def hello() = {
    println("huga")
  }

  def getSeq(m: Int, n: Int) = Matrix(m)(n)

  def getSize() = Matrix.size

  def getLineSize(x: Int) = Matrix(x).size
  
  def changeSeq(m: Int, n: Int, data: Int) = {
   var line = Matrix(m)
   line = line updated (n,data)
   Matrix = Matrix updated (m,line)
  }

}

