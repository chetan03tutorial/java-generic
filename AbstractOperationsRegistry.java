abstract public class AbstractOperationsRegistry implements OperationsRegistry {
    protected Map<String, IOperation> operations;

    public void registerOperation(String action, IOperation operation){
        operations = Optional.ofNullable(operations).orElseGet(HashMap::new);
        operations.putIfAbsent(action,operation);
    }
    public IOperation getOperation(String action){
        return Optional.ofNullable(operations.get(action)).orElseThrow(()-> new InvalidOperationException(action));
    }
}
