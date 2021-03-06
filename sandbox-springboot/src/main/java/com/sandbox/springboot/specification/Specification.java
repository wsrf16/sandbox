package com.sandbox.springboot.specification;

public interface Specification<T>
{
    Boolean IsSatisfiedBy(T candidate);
    Specification<T> And(Specification<T> specification);
    Specification<T> Or(Specification<T> specification);
    Specification<T> Not(Specification<T> specification);
}