package homework;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Владимир on 20.12.2016.
 */
public class Streams<T> {
    private Stream<T> data;

    private Streams(Stream<T> data) {
        this.data = data;
    }

    public static <T> Streams<T> of (Collection<T> list) {
        return new Streams<T>(list.stream());
    }

    public Streams<T> filter (Predicate<? super T> predicate) {
        data = data.filter(predicate);
        return this;
    }

    public Streams<T> transform (Function<? super T, ? extends T> function) {
        data = data.map(function);
        return this;
    }

    public <K, V> Map<K, V> toMap (Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        return data.collect(Collectors.toMap(keyMapper, valueMapper));
    }
}
