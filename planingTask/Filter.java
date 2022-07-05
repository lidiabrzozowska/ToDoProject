package com.testarmy.planingTask;

@FunctionalInterface
public interface Filter<T> {
        boolean check(T value);
}