## PerfTracepoint [![Build Status](https://secure.travis-ci.org/twitter/PerfTracepoint.png?branch=master)](http://travis-ci.org/twitter/PerfTracepoint)

com.twitter.diagnostics.PerfTracepoint is an annotation, which, when applied to a native
method informs the (Twitter) JVM that it needs to treat it like a
Linux user mode probe point that is observable by diagnostic tools
such as the Perf profiler.

    class FinagleProvider {
        @PerfTracepoint
        public static native void onThreadCreate(long threadId);
    };

## License

Copyright 2014 Twitter, Inc and other contributors

Licensed under the Apache Public License 2.0:
http://www.apache.org/licenses/LICENSE-2.0.html
