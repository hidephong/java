import java.lang.reflect.*;
class MyClass {
public String name;
public int[] values;
public MyClass() {
name = "Noname";
values = new int[10];
}
public MyClass(String name, int[] values) {
this.name = name;
this.values = values;
}
public void display() {
System.out.print("[MyClass] " + name + ": ");
for (int i = 0; i < values.length; i++)
System.out.print(values[i] + " ");
System.out.println();
}
}
@SuppressWarnings("unchecked")
public class ObjectManipulation {
public static void main(String[] args) {
try {
Class myClass = Class.forName("MyClass");
Object myObject;
// Use the default constructor
myObject = myClass.newInstance();
// Use the other constructor
String name = "Test Reflection";
int[] values = { 1, 2, 3, 4, 5, 6 };
Constructor ctr2 = myClass.getConstructor(name.getClass(),
values.getClass());
myObject = ctr2.newInstance(name, values);
// Set values
myClass.getField("name").set(myObject, "Test setting values");
Field valuesField = myClass.getField("values");
Array.set(valuesField.get(myObject), 0, 1000);
// Invoke display() on myObject
Method displayMethod = myClass.getMethod("display");
displayMethod.invoke(myObject);
} catch (Exception ex) {
ex.printStackTrace();
}
}
}