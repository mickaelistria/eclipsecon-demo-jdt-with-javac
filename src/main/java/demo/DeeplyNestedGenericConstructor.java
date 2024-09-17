package demo;
import java.util.Map;
import java.util.function.Function;

/**
 * Demo ECJ issue https://github.com/eclipse-jdt/eclipse.jdt.core/issues/1501
 * <p>Consistent with JAVAC</p>
 */
public class DeeplyNestedGenericConstructor {
  public Outer<Data> errorInLambda() {
    Outer<Data> x = new Outer<>(new InnerImpl<>(Map.of()));
    // the above one works but on mouse over InnerImpl produces:
    // InnerImpl.InnerImpl<Object>(Map<String, Function<Object, Object>> map)
    // should be:
    // InnerImpl.InnerImpl<Data>(Map<String, Function<Data, Object>> map)

    Outer<Data> y = new Outer<>(new InnerImpl<Object>(Map.of()));
    // but this one correctly errors with:
    // Cannot infer type arguments for Outer<>

    return new Outer<>(new InnerImpl<>(Map.of("x",
        data -> data.getValue() // Eclipse error:
        // This lambda expression must return a result of type Object
        // javac correctly infers Data to both diamonds here and no errors produced
        )));
  }
}

class Outer<T> {
  final Inner<T> inner;

  Outer(Inner<T> inner) {
      this.inner = inner;
  }
}

interface Inner<T> {}

class InnerImpl<T> implements Inner<T> {
  InnerImpl(Map<String, Function<T, Object>> map) {}
}

class Data {
  String value;

  Data(String value) {
      this.value = value;
  }

  String getValue() {
      return value;
  }
}