package demo;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class TypeInferenceDemo {
    public static void main(String[] args) {
        // passed.
        Builder<Object> builder1 = builderOfStage(e -> CompletableFuture.completedFuture("test1"));

        // failed. Type mismatch: cannot convert from Builder<String> to Builder<Object>
        Builder<Object> builder2 = builderOfStage(e -> CompletableFuture.completedFuture("test2")).withAsync();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    static <R> Builder<R> builderOfStage(Function<? extends R, ? extends CompletionStage<R>> fallback) {
        return new Builder(fallback);
    }
}

class Builder<R> {
    boolean async;

    Builder(Function<R, CompletableFuture<R>> fallbackStage) {
    }

    public Builder<R> withAsync() {
        async = true;
        return this;
    }
}