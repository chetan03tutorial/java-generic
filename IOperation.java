import java.util.function.BiFunction;
import java.util.function.Function;

public interface IOperation {
    Class<?> getInvoker();
    Function<?,?> getNoArgOperation();
    BiFunction<?,?,?> getOperation();
    TriFunctional<?,?,?,?> getBiArgOperation();
    QuadFunctional<?,?,?,?,?> getTriArgumentOperation();
}
