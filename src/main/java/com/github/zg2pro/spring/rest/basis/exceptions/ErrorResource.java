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

import java.io.Serializable;

/**
 * serialized representation of a java exception
 *
 * @author zg2pro
 * @since 0.2
 */
public class ErrorResource implements Serializable {

    private static final long serialVersionUID = -6948542874457786251L;

    private String code;
    private String errorClassName;
    private String errorMessage;
    private Zg2proStackTrace stackTrace = new Zg2proStackTrace();

    /**
     * default constructor
     */
    public ErrorResource() {
        super();
    }

    /**
     * constructor by excpetion content
     *
     * @param code
     * @param errorMessage
     * @param errorClassName
     * @param stackTrace
     */
    public ErrorResource(String code, String errorMessage, String errorClassName, StackTraceElement[] stackTrace) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.errorClassName = errorClassName;
        for (StackTraceElement ste : stackTrace) {
            Zg2proStackTraceElement nste = new Zg2proStackTraceElement();
            nste.setDeclaringClass(ste.getClassName());
            nste.setFileName(ste.getFileName());
            nste.setLineNumber(ste.getLineNumber());
            nste.setMethodName(ste.getMethodName());
            this.stackTrace.add(nste);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorClassName() {
        return errorClassName;
    }

    public void setErrorClassName(String errorClassName) {
        this.errorClassName = errorClassName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    

    public Zg2proStackTrace getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(Zg2proStackTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

}
