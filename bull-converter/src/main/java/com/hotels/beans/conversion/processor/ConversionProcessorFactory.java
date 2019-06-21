/**
 * Copyright (C) 2019 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hotels.beans.conversion.processor;

import static lombok.AccessLevel.PRIVATE;

import com.hotels.beans.conversion.processor.impl.ByteConversionProcessor;
import com.hotels.beans.conversion.processor.impl.IntegerConversionProcessor;
import com.hotels.beans.conversion.processor.impl.LongConversionProcessor;
import com.hotels.beans.conversion.processor.impl.PrimitiveConversionProcessor;
import com.hotels.beans.conversion.processor.impl.ShortConversionProcessor;
import com.hotels.beans.conversion.processor.impl.StringConversionProcessor;

import lombok.NoArgsConstructor;

/**
 * Creates a {@link ConversionProcessor} instance for the given class.
 */
@NoArgsConstructor(access = PRIVATE)
public final class ConversionProcessorFactory {
    /**
     * Returns a conversion processor for the given type.
     * @param clazz the class for which the conversion processor has to be retrieved.
     * @return a conversion processor for the given type
     */
    public static ConversionProcessor getConversionProcessor(final Class<?> clazz) {
        ConversionProcessor conversionProcessor = null;
        if (clazz == Byte.class) {
            conversionProcessor = new ByteConversionProcessor();
        } else if (clazz == byte.class) {
            conversionProcessor = new PrimitiveConversionProcessor<Byte>();
//        } else if (clazz == Short.class) {
//            conversionProcessor = new ShortConversionProcessor();
//        } else if (clazz == short.class) {
//            conversionProcessor = new PrimitiveShortConversionProcessor();
//        } else if (clazz == Integer.class) {
//            conversionProcessor = new IntegerConversionProcessor();
//        } else if (clazz == int.class) {
//            conversionProcessor = new PrimitiveConversionProcessor<Integer>();
//        } else if (clazz == Long.class) {
//            conversionProcessor = new LongConversionProcessor();
//        } else if (clazz == long.class) {
//            conversionProcessor = new PrimitiveConversionProcessor<Long>();
//        } else if (clazz == Float.class) {
//            conversionProcessor = new FloatConversionProcessor();
//        } else if (clazz == float.class) {
//            conversionProcessor = new PrimitiveConversionProcessor<Long>();
//        } else if (clazz == Double.class) {
//            conversionProcessor = new DoubleConversionProcessor();
//        } else if (clazz == double.class) {
//            conversionProcessor = new PrimitiveConversionProcessor<Double>();
//        } else if (clazz == Character.class) {
//            conversionProcessor = new CharacterConversionProcessor();
//        } else if (clazz == char.class) {
//            conversionProcessor = new PrimitiveConversionProcessor<Character>();
//        } else if (clazz == Boolean.class) {
//            conversionProcessor = new BooleanConversionProcessor();
//        } else if (clazz == boolean.class) {
//            conversionProcessor = new PrimitiveConversionProcessor<Boolean>();
//        } else if (clazz == String.class) {
//            conversionProcessor = new StringConversionProcessor();
        }
        return conversionProcessor;
    }
}