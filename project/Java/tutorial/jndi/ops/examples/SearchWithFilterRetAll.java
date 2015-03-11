import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

/**
 * Demonstrates how to perform a search by specifying a search filter
 * and default search controls. Functionally identical to SearchRetAll.java.
 *
 * usage: java SearchWithFilterRetAll
 */
class SearchWithFilterRetAll {
    public static void main(String[] args) {

	// Set up the environment for creating the initial context
        Hashtable<String, Object> env = new Hashtable<String, Object>(11);
	env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    "com.sun.jndi.ldap.LdapCtxFactory");
	env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

	try {
	    // Create initial context
	    DirContext ctx = new InitialDirContext(env);

	    // Create default search controls
	    SearchControls ctls = new SearchControls();

	    // Specify the search filter to match
	    // Ask for objects with attribute sn == Geisel and which have
	    // the "mail" attribute.
	    String filter = "(&(sn=Geisel)(mail=*))";

	    // Search for objects using filter
	    NamingEnumeration answer = ctx.search("ou=People", filter, ctls);

	    // Print the answer
	    Search.printSearchEnumeration(answer);

	    // Close the context when we're done
	    ctx.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}