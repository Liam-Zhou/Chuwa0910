import com.chuwa.shawnlearning.util.SCollector;
import com.chuwa.shawnlearning.util.SStream;
import com.chuwa.shawnlearning.util.impl.SIdentity;
import com.chuwa.shawnlearning.util.impl.SList;
import com.chuwa.shawnlearning.util.impl.SOptional;
import com.chuwa.shawnlearning.util.impl.SSome;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalTest {

    @Test
    public void identityTest() {
        SIdentity<Integer> SIdentity = new SIdentity<>(1);
        assertEquals(SIdentity, SIdentity.map(x -> x));
    }

    @Test
    public void optionalTest(){
        SOptional<Integer> sOptional = new SSome<>(1);
        sOptional.map(String::valueOf).map(Integer::parseInt).map((a) -> {
            System.out.println(a);
            return 1;
        });
    }

    @Test
    public void listTest(){
        SList<Integer> list = new SList<>(List.of(1,2,3,4,5));
        list.map(String::valueOf).map(Integer::parseInt).map((a) -> {
            System.out.println(a);
            return 1;
        });

        var l = list.flatMap((a) -> {
            return new SList<>(List.of(a, a + 1));
        }).map((a) -> {
            System.out.println(a);
            return a + 1;
        });

    }

    @Test
    public void streamTest(){
        SStream<Integer> stream = SStream.of(List.of(1,2,3,4,5));
        stream.map( (i) ->i +1).collect(new SCollector<Integer, List<Integer>>() {
            private final List<Integer> list = new ArrayList<>();

            @Override
            public void accumulate(Integer integer) {
                System.out.println("collect "+ integer);
                list.add(integer);
            }

            @Override
            public List<Integer> finish() {
                return list;
            }
        });
    }
}
