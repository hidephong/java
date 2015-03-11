/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

/**
 *
 * @author Lovely
 */

   import java.util.ArrayList;
public class UsingAnnotations {
@SuppressWarnings({"unchecked", "deprecation"})
public void myMethod() {
ArrayList lst = new ArrayList();
lst.add(1);
lst.add(2);
lst.add(3);
myObsoleteMethod(lst);
}
@Override
public String toString() {
return "nothing";
}
@Deprecated
public void myObsoleteMethod(ArrayList lst) {
System.out.println(lst);
}
}


