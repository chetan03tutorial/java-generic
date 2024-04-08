package com.gapinc.selling.stores.orders.common.registry.operations;

import com.gapinc.selling.stores.orders.common.functions.QuadFunctional;
import com.gapinc.selling.stores.orders.common.functions.TriFunctional;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface IOperation {
    Class<?> getInvoker();
    Function<?,?> getNoArgOperation();
    BiFunction<?,?,?> getOperation();
    TriFunctional<?,?,?,?> getBiArgOperation();
    QuadFunctional<?,?,?,?,?> getTriArgumentOperation();
}
