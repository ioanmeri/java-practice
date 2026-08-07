## General Notes


The whole point of a `try-with-resource` statement is that whatever resource is specified in the try with resources block should be closed **as soon as the try block ends** 
- (i.e. before the control goes to the catch or the finally block) irrespective of what happens in the try block.


---

### Try with Resources Notes

You need to know the following points regarding try-with-resources statement for the exam:
1. The resource class must implement java.lang.AutoCloseable interface. Many standard JDK classes such as java.io.FileInputStream implement the older (introduced in Java 1.5), java.io.Closeable interface, which was made to extend java.lang.AutoCloseable in Java 1.7.
2. AutoCloseable has only one method - public void close() throws Exception.
3. Resources are closed at the end of the try block and before any catch or finally block.
4. Resources are not even accessible in the catch or finally block. For example:
try(Device d = new Device())
{
d.read();
}finally{
d.close(); //This will not compile because d is not accessible here.
}

Note that the try-with-resource was enhanced in Java 9 and it now allows you to use a variable declared before the try statement in the try-with-resource block. In this case, of course, the variable is accessible after the try block but the object referred to by it has been closed. For example, the following is valid since Java 9:
Device d = new Device();
try(d){ //valid since Java 9
...
}finally{
d.close(); //this will compile but may not work correctly because the object referred to by d has already been closed.
}
5. Resources are closed in the reverse order of their declaration (or creation) in the try clause.
6. Resources are closed even if the code in the try block throws an exception.
7. java.lang.AutoCloseable's close() throws Exception but java.io.Closeable's close() throws IOException.
8. If the code in the try block throws an exception and an exception is also thrown while closing a resource, the exception thrown while closing the resource is suppressed. The caller gets the exception thrown in the try block.
9. If no exception is thrown from the try block but multiple resources throw exceptions while being closed, the caller gets the exception thrown by the resource that was closed first (i.e. the last resource declared in the try-with-resources block). The rest of the exceptions are suppressed.
10. Suppressed exceptions can be retrieved from the main exception by calling the Throwable[] getSuppressed() instance method of Throwable.
11. Auto closeable resources that you want the try clause to manage must be final or effectively final.