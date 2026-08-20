## Notes Valid Override

You should know the following concepts for answering this type of questions:
Steps to check for valid override

First, check the method signature (i.e. method name and the parameter list). If the signature of the method in the subclass matches the signature of the method in the super class, then it could be a valid override, otherwise it is just an overloaded method. Note that signature does not include parameter names and parameter's generic type specification.

Second, if it is a potential override, check the generic type specification of the parameters. If the overriding method does not use a generic type specification for the parameter type, then it is valid. The reverse is not valid i.e. the overriding method is allowed to erase the generic type specification but is not allowed to add a generic type specification if the overridden method does not have it. If both the methods have a generic type specification, then the specification must match exactly.
For example, if the overridden method has Set<Integer>, then the overriding method can use Set or Set<Integer>. But if overridden method has Set, then the overriding method must also have Set for a valid override.

Third, if it is a potential override, check the return type. Java allows "covariant" returns, which means, the return type of the overriding method must be the same or be a subtype of the return type mentioned in the overridden method. Check the two return types without the generic type specification. If return type of the overriding method is covariant with respect to the return type of the overriding method (for example, ArrayList is covariant with List), then perform the same check including the generic type specification (for example, ArrayList<CharSequence> is covariant with List<? extends CharSequence>).

Don't get confused by the presence of <T> in the code. The same rules of overriding still apply. The T in <T> is called as the "type" parameter. It is used as a place holder for whatever type is actually used while invoking the method. For example, if you call the method <T> List<T> transform(List<T> list) with List<String>, T will be typed to String. Thus, it will return List<String>. If, in another place, you call the same method with Integer, T will be typed to Integer and therefore, the return type of the method for that invocation will be List<Integer>
