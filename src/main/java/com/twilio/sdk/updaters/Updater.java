package com.twilio.sdk.updaters;

import com.google.common.util.concurrent.ListenableFuture;
import com.twilio.sdk.Twilio;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.resources.Resource;

import java.util.concurrent.Callable;

public abstract class Updater<T extends Resource> {
    public T build(final T target) {
        return build(target, Twilio.getRestClient());
    }

    public abstract T build(final T target, final TwilioRestClient client);

    public ListenableFuture<T> async(final T target) {
        return async(target, Twilio.getRestClient());
    }

    public ListenableFuture<T> async(final T target, final TwilioRestClient client) {
        return Twilio.getExecutorService().submit(new Callable<T>() {
            public T call() {
                return build(target, client);
            }
        });
    }
}
