package com.gapinc.selling.stores.orders.common.managers;

import com.gapinc.selling.stores.orders.common.functions.QuadFunctional;
import com.gapinc.selling.stores.orders.common.functions.TriFunctional;
import com.gapinc.selling.stores.orders.common.registry.operations.IOperation;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class OperationManager {

    private ListableBeanFactory factory;

    public OperationManager(ListableBeanFactory beanFactory){
        this.factory = beanFactory;
    }

    public <T,U,R> R execute(IOperation op, U arg1){
        T invoker = (T) factory.getBean(op.getInvoker());
        BiFunction<T,U,R> ops = (BiFunction<T,U,R>)op.getOperation();
        return (R) ops.apply(invoker,arg1);
    }

    /*private static Map<String, IOperation> operations = new HashMap<>();
    private ListableBeanFactory factory;

    public OperationManager(ListableBeanFactory factory){
        this.factory = factory;
        buildOperationsRegistry();
    }

    private void buildOperationsRegistry(){
        Collection<OperationsRegistry> operations = factory.getBeansOfType(OperationsRegistry.class).values();
        operations.forEach(this::addOperation);
    }
    private void addOperation(OperationsRegistry ops){
        ops.getOperations().forEach((k,v) -> operations.putIfAbsent(k,v));
    }

    private IOperation getOperation(String action){
        IOperation operation = operations.get(action);
        return Optional.ofNullable(operation).orElseThrow(()-> new InvalidOperationException(String.format("Invalid OperationException(%s)",action)));
    }*/

    /*public <T,U,V> V execute(String action, U request,Class<V> responseType){
        IOperation op = this.getOperation(action);
        T invoker = (T) factory.getBean(op.getInvoker());
        BiFunction<T,U,V> ops = (BiFunction<T,U,V>)op.getOperation();
        return (V) ops.apply(invoker,request);
    }

    public <T,V> V execute(String action, Class<V> responseType){
        IOperation op = this.getOperation(action);
        T invoker = (T) factory.getBean(op.getInvoker());
        Function<T,V> ops = (Function<T,V>)op.getNoArgOperation();
        return (V) ops.apply(invoker);
    }*/


    /*public <T,R> R execute(IOperation op){
        T invoker = (T) factory.getBean(op.getInvoker());
        Function<T,R> ops = (Function<T,R>)op.getNoArgOperation();
        return (R) ops.apply(invoker);
    }*/
    

    /*public <T,U,V,R> R execute(IOperation op, U arg1, V arg2){
        T invoker = (T) factory.getBean(op.getInvoker());
        TriFunctional<T,U,V,R> ops = (TriFunctional<T,U,V,R>)op.getBiArgOperation();
        return (R) ops.apply(invoker,arg1, arg2);
    }
    public <T,U,V, Q, R> R execute(IOperation op, U arg1, V arg2, Q arg3){
        T invoker = (T) factory.getBean(op.getInvoker());
        QuadFunctional<T,U,V,Q,R> ops = (QuadFunctional<T,U,V,Q,R>)op.getTriArgumentOperation();
        return (R) ops.apply(invoker,arg1, arg2, arg3);
    }*/


}
