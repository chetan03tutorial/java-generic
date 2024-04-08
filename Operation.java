public interface IOperation {
    Class<?> getInvoker();
    Function<?,?> getNoArgOperation();
    BiFunction<?,?,?> getOperation();
    TriFunctional<?,?,?,?> getBiArgOperation();
    QuadFunctional<?,?,?,?,?> getTriArgumentOperation();
}
