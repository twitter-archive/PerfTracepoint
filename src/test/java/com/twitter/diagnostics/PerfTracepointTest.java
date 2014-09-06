package com.twitter.diagnostics;

import java.lang.reflect.Method;
import java.lang.NoSuchMethodException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

class Tracepoints {
    @PerfTracepoint static native void tracepoint0();
};

public class PerfTracepointTest extends TestCase {
    public PerfTracepointTest(String name)
    {
	super(name);
    }

    public static Test suite()
    {
	return new TestSuite(PerfTracepointTest.class);
    }

    public void testApp()
    {
	Method method = null;
	try {
	    method = Tracepoints.class.getDeclaredMethod("tracepoint0");
	    assertNotNull("Method Tracepoints.tracepoint0 is null.", method);
	} catch (NoSuchMethodException e) {
	    assertTrue("Method tracepoint0 not found in class Tracepoints.", false);
	}

	PerfTracepoint tracepoint = method.getAnnotation(PerfTracepoint.class);
	assertNotNull("PerfTracepoint instance is null.", tracepoint);
    }
};