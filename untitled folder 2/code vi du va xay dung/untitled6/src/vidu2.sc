/**
 * Created by tuanna on 5/14/14.
 */
def p(implicit i:Int)= print(i)
p

implicit val v=2



def pp(b:Int)(implicit i:Int,a:Int)=println(a,i)