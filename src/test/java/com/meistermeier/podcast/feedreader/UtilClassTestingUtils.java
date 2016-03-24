package com.meistermeier.podcast.feedreader;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class UtilClassTestingUtils {

    public static void assertClassIsUtilClass(Class<?> classUnderTest) throws Exception {
        Assert.assertThat(Modifier.isFinal(classUnderTest.getModifiers()), CoreMatchers.is(true));

        Constructor<?> constructor = classUnderTest.getDeclaredConstructors()[0];
        Assert.assertThat(Modifier.isPrivate(constructor.getModifiers()), CoreMatchers.is(true));
        // not really needed, but since we are here we can now cover the invocation of the private constructor
        constructor.setAccessible(true);
        constructor.newInstance();
        constructor.setAccessible(false);

        for (Method method : classUnderTest.getMethods()) {
            if (method.getDeclaringClass().equals(classUnderTest)) {
                Assert.assertThat("method " + method.getName() + " must be static",
                        Modifier.isStatic(method.getModifiers()),
                        CoreMatchers.is(true));
            }
        }
    }
}
