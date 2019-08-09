package com.hotels.beans.transformer;

import com.hotels.beans.BeanUtils;
import com.hotels.beans.model.FieldMapping;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.isNull;


public class HashMapTransformationTest extends AbstractTransformerTest {
    @Test
    public void testMapGenericFieldTypeWorksProperly() {
        Map<String, Object> mapSource =  new HashMap<String, Object>() {{
            put("key1", "string1");
            put("key2", 22);
            put("key3", Arrays.asList("Larry", "Moe", "Curly"));
        }};

        final MapWrapper mapWrapperTarget = new BeanUtils().getTransformer()
                                                           .withFieldMapping(new FieldMapping("map.key1", "map.newKey1"))
                                                           .withFieldMapping(new FieldMapping("map.key3", "map.newKey3"))
                                                           .transform(new MapWrapper().setMap(mapSource), MapWrapper.class);
        isNull(mapWrapperTarget.map.get("key1"));
        assertEquals(mapSource.get("key1") ,mapWrapperTarget.map.get("newKey1"));
        assertEquals(mapSource.get("key3") ,mapWrapperTarget.map.get("newKey3"));
    }
}
