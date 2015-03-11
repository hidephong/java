import java.lang.reflect.Method;
import static java.lang.System.out;

public class InheritedMethods {
    public static void main(String... args) {
	try {
	    Class<?> c = Class.forName(args[0]);
	    printMethods(c);

	    Class parent = c.getSuperclass();
	    while (parent != null) {
		printMethods(parent);
		parent = parent.getSuperclass();
	    }

        // production code should handle this exception more gracefully
	} catch (ClassNotFoundException x) {
	    x.printStackTrace();
	}
    }

    private static void printMethods(Class c) {
	out.format("Methods from %s%n", c);
	Method[] meths = c.getDeclaredMethods();
	if (meths.length != 0) {
	    for (Method m : meths)
		out.format("  Method:  %s%n", m.toGenericString());
	} else {
	    out.format("  -- no methods --%n");
	}
	out.format("%n");
    }
}
