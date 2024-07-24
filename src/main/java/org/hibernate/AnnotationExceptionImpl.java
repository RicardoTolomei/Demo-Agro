package org.hibernate;

public class AnnotationExceptionImpl extends AnnotationException {
    public AnnotationExceptionImpl(String msg, Throwable cause) {
        super(msg, cause);
    }
}
