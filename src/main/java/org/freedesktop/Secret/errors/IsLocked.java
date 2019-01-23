package org.freedesktop.Secret.errors;

/**
 * The object must be unlocked before this action can be carried out.
 * <p>
 * org.freedesktop.Secret.Error.IsLocked
 */
public class IsLocked extends Exception {
    public IsLocked() {
    }

    public IsLocked(String message) {
        super(message);
    }

    public IsLocked(String message, Throwable cause) {
        super(message, cause);
    }

    public IsLocked(Throwable cause) {
        super(cause);
    }

    public IsLocked(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
