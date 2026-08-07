package com.practice.basics;

sealed interface Cacheable permits Value, Result, Value1, Result1{
    default void clear(){ System.out.println("clearing cache..."); }
}

// Allowed
non-sealed interface Value extends Cacheable{ } // interface extends
non-sealed abstract class Result implements Cacheable{ } // class implements



abstract non-sealed interface Value1 extends Cacheable{ }
sealed abstract class Result1 implements Cacheable permits IntResult{ }
final class IntResult extends Result1{ }

public class SealedInterface {
}
