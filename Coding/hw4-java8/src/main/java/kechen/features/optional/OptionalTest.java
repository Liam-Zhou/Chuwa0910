package kechen.features.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void testOf(){
        String value = "Hello, Optional";
        // `Optional.of(T value)`:根据一个非空值创建一个Optional对象。如果传入的值为null，这个方法会抛出NullPointerException
        Optional<String> optional = Optional.of(value);
        // `isPresent()`:该方法用于检查Optional对象是否包含值。如果包含值，返回true；
        // 如果Optional对象为空（不包含值），返回false
        assertTrue(optional.isPresent());
        // `get()`:如果Optional对象包含一个值，该方法会返回这个值；
        // 如果Optional对象是空的（不包含值），则抛出一个NoSuchElementException异常
        assertEquals(value, optional.get());
    }

    @Test
    public void testOfNullable(){
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }

    @Test
    public void testEmpty(){
        // `Optional.empty()`:创建一个空的Optional对象，表示没有值。这种方法用于需要表示缺少值的场景。
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }

    @Test
    public void testIfPresent(){
        Optional<String> optional = Optional.of("Hello, Optional!");
        // `ifPresent(Consumer<? super T> action):该方法用于在Optional对象包含值时执行指定的操作。
        // 如果Optional对象包含值，将该值传递给作为参数的Consumer函数；
        // 如果Optional对象为空（不包含值），不执行任何操作。
        optional.ifPresent(value -> assertEquals("Hello, Optional!", value));
    }

    @Test
    public void testOrElse(){
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default value");
        assertEquals("Default value", result);
    }

    @Test
    public void testOrElseGet(){
        Optional<String> optional = Optional.empty();
        //`orElseGet(Supplier<? extends T> other)`:如果Optional对象包含一个值，该方法返回这个值；
        // 如果Optional对象是空的，使用指定的Supplier函数生成并返回一个默认值.
        String result = optional.orElseGet(() ->"Default value");
        assertEquals("Default value", result);
    }

    @Test
    public void testOrElseThrow(){
        Optional<String> optional = Optional.empty();
        // `orElseThrow()`:如果Optional对象包含一个值，该方法返回这个值；
        // 如果Optional对象是空的，抛出一个NoSuchElementException异常。
        // 这个方法在Java 10中引入，与get()方法的功能相同，但命名更符合实际行为。
        assertThrows(NoSuchElementException.class, optional::orElseThrow);
    }

    @Test
    public void testFilter(){
        Optional<Integer> optional = Optional.of(42);
        // `optional.filter(Predicate<? super T> predicate)`:对包含在原始 Optional 中的值应用筛选条件，
        // 从而创建一个新的 Optional 对象。如果筛选条件不满足，将返回一个空的 Optional。
        Optional<Integer> filtered = optional.filter(value -> value % 2 == 0);
        assertTrue(filtered.isPresent());  //检查筛选后的optional不为空
        // assertEquals(42, Optional.of(filtered.get()));
        assertEquals(optional.get(), filtered.get());
    }


    @Test
    public void testMap(){
        Optional<String> optional = Optional.of("Hello, Optional!");
        // `map方法`:接受一个函数，该函数将被应用于 Optional 包装的值，然后返回一个新的 Optional 包装的结果（将原始 Optional 中的值映射为新的值）。
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        // assertEquals(16, mapped.get());
        // assertEquals(16L, mapped.get());
        assertEquals(Optional.of(16), Optional.of(mapped.get()));
    }

    @Test
    public void testFlatMap(){
        Optional<String> optional = Optional.of("Hello, Optional!");
        // `optional.flatMap()`:将原始的 Optional 中的值进行扁平映射，并返回一个新的 Optional 对象。
        // 通常情况下，optional.flatMap() 用于处理嵌套的 Optional，以便更容易地访问内部值。
        // 例如，如果你有一个 Optional，它可能包含某个对象，而该对象本身也是一个 Optional，
        // 你可以使用 flatMap 来获取内部 Optional 中的值，而不必处理嵌套的 Optional 结构。
        Optional<Integer> flatMapped = optional.flatMap(value -> Optional.of(value.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(Optional.of(16), Optional.of(flatMapped.get()));
    }

}
