/*
 * The MIT License
 *
 * Copyright 2017 zg2pro.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.zg2pro.spring.rest.basis.exceptions;

import java.util.ArrayList;

/**
 *
 * A stacktrace decomposed by fields in order to serialize deserialize it
 * between rest server and rest client
 *
 * @author zg2pro
 * @since 0.2
 */
public class Zg2proStackTrace extends ArrayList<Zg2proStackTraceElement> {

    private static final long serialVersionUID = 8633952454328952881L;

    /**
     * default constructor
     */
    public Zg2proStackTrace() {
        super();
    }

    public Zg2proStackTrace(StackTraceElement[] stackElements) {
        for (StackTraceElement ste : stackElements) {
            Zg2proStackTraceElement nste = new Zg2proStackTraceElement();
            nste.setDeclaringClass(ste.getClassName());
            nste.setFileName(ste.getFileName());
            nste.setLineNumber(ste.getLineNumber());
            nste.setMethodName(ste.getMethodName());
            add(nste);
        }
    }

}
