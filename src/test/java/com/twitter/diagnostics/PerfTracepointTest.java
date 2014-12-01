/**
 * Copyright 2014 Twitter, Inc. and other contributors
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
 **/
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
