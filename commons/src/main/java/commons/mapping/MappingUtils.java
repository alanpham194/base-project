package commons.mapping;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MappingUtils {
    public static <T> T map(Object source, Class<T> clazz) {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        T destObject = mapper.map(source, clazz);
        return destObject;
    }

    public static <T> List<T> mapList(List<Object> sources, Class<T> clazz) {
        List<T> res = new ArrayList<T>();
        for (Object s : sources) {
            res.add(MappingUtils.map(s, clazz));
        }

        return res;
    }

    public static <T> List<T> mapList(Iterable<? extends Object> sources, Class<T> clazz) {
        List<T> res = new ArrayList<T>();
        for (Iterator it = sources.iterator(); it.hasNext(); ) {
            Object s = it.next();
            res.add(MappingUtils.map(s, clazz));
        }

        return res;
    }
}
