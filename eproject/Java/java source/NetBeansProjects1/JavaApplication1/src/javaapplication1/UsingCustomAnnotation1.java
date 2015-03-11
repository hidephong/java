/* example from Java Tutorials */
import java.lang.annotation.*;
@ClassPreamble (
author = "John Doe",
date = "3/17/2002",
currentRevision = 6,
lastModified = "4/12/2004",
lastModifiedBy = "Jane Doe",
reviewers = {"Alice", "Bob", "Cindy"} // Note array notation
)
public class UsingCustomAnnotation1 {}
@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface ClassPreamble {
String author();
String date();
int currentRevision() default 1;
String lastModified() default "N/A";
String lastModifiedBy() default "N/A";
String[] reviewers(); // Note use of array
}