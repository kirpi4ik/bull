/**
 * Copyright (C) 2019-2020 Expedia, Inc.
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

package com.hotels.beans.transformer;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hotels.beans.sample.immutable.ImmutableToFooWithBuilder;
import com.hotels.beans.sample.mixed.MixedToFooWithBuilder;
import com.hotels.beans.sample.mutable.MutableToFooWithBuilder;
import com.hotels.beans.sample.mutable.MutableToFooWithBuilderMultipleConstructor;

/**
 * Unit test for all {@link BeanTransformer} functions related to Object based on Builder Pattern.
 */
public class BuilderObjectTransformationTest extends AbstractBeanTransformerTest {
    /**
     * Test mutable,immutable,mixed beans are correctly copied through builder.
     * @param testDescription the test case description
     * @param sourceObject the object to transform
     * @param targetObjectClass the target object class
     */
    @Test(dataProvider = "transformationThroughBuilderTesting")
    public void testTransformationThroughBuilder(final String testDescription, final Object sourceObject, final Class<?> targetObjectClass) {
        //GIVEN
        underTest.setCustomBuilderTransformationEnabled(true);

        //WHEN
        Object actual = underTest.transform(sourceObject, targetObjectClass);

        //THEN
        assertThat(actual).usingRecursiveComparison().isEqualTo(sourceObject);
        underTest.setCustomBuilderTransformationEnabled(false);
    }

    /**
     * Creates the parameters to be used for testing the bean transformation through builder.
     * @return parameters to be used for testing the bean transformation through builder.
     */
    @DataProvider
    private Object[][] transformationThroughBuilderTesting() {
        return new Object[][] {
                {"Test that a Mutable bean, containing a custom Builder is correctly transformed", fromFoo, MutableToFooWithBuilder.class},
                {"Test that a Mutable bean, containing a custom Builder with multiple constructors, is correctly transformed",
                        fromFoo, MutableToFooWithBuilderMultipleConstructor.class},
                {"Test that a Mixed bean, containing a Builder generated by lombok, is correctly transformed", fromFoo, MixedToFooWithBuilder.class},
                {"Test that an Immutable bean, containing a Builder generated by lombok with all mandatory fields, is correctly transformed",
                        fromFoo, ImmutableToFooWithBuilder.class}
        };
    }
}
