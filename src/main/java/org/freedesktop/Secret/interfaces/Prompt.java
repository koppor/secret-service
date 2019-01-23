package org.freedesktop.Secret.interfaces;

import org.freedesktop.Secret.Static;
import org.freedesktop.Secret.handlers.Messaging;
import org.freedesktop.dbus.ObjectPath;
import org.freedesktop.dbus.annotations.DBusInterfaceName;
import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.messages.DBusSignal;
import org.freedesktop.dbus.types.Variant;

import java.util.List;

@DBusInterfaceName(Static.Interfaces.PROMT)
public abstract class Prompt extends Messaging implements DBusInterface {
    public Prompt(DBusConnection connection, List<Class> signals,
                  String serviceName, String objectPath, String interfaceName) {
        super(connection, signals, serviceName, objectPath, interfaceName);
    }

    public static class Completed extends DBusSignal {
        public final boolean dismissed;
        public final Variant result;

        public Completed(String path, boolean dismissed, Variant result) throws DBusException {
            super(path, dismissed, result);
            this.dismissed = dismissed;
            this.result = result;
        }
    }

    abstract public void prompt(String window_id);

    abstract public void prompt(ObjectPath prompt);

    abstract public void await(ObjectPath prompt) throws InterruptedException;

    abstract public void dismiss();

}
