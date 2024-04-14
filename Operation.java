package com.gapinc.selling.stores.orders.common.registry.operations;

import com.gapinc.selling.stores.orders.common.functions.QuadFunctional;
import com.gapinc.selling.stores.orders.common.functions.TriFunctional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Operation implements IOperation{

    private Class<?> invoker;

    private Function<?,?> noargoperation;
    private BiFunction<?,?,?> singleargoperation;
    private TriFunctional<?,?,?,?> biargoperation;
    private QuadFunctional<?,?,?,?,?> triargoperation;


    public <T,U> Operation(Class<T> invoker, Function<T, U> operation) {
        this.invoker = invoker;
        this.noargoperation = operation;
    }

    public <T,U,V> Operation(Class<T> invoker, BiFunction<T, U, V> operation) {
        this.invoker = invoker;
        this.singleargoperation = operation;
    }

    public <T,U,V,R> Operation(Class<T> invoker, TriFunctional<T, U, V,R> operation) {
        this.invoker = invoker;
        this.biargoperation = operation;
    }

    public <T,U,V,Q,R> Operation(Class<T> invoker, QuadFunctional<T,U,V,Q,R> operation) {
        this.invoker = invoker;
        this.triargoperation = operation;
    }

    @Override
    public Class<?> getInvoker() {
        return invoker;
    }

    @Override
    public Function getNoArgOperation(){
        return noargoperation;
    }
    @Override
    public BiFunction getOperation() {
        return singleargoperation;
    }

    @Override
    public TriFunctional<?, ?, ?, ?> getBiArgOperation() {
        return biargoperation;
    }

    @Override
    public QuadFunctional<?, ?, ?, ?, ?> getTriArgumentOperation() {
        return triargoperation;
    }

}
