/**
 * Created by tuanna on 5/14/14.
 */
import scala.annotation.tailrec
@tailrec
def listLeng(list: List[_], len: Int = 0): Int = { if (list.isEmpty)
  len else
  listLeng(list.tail, len + 1)}
val x = List(1,3,4,6,8)
listLeng(x)
