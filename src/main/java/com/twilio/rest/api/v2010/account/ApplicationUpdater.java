/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class ApplicationUpdater extends Updater<Application> {
    private String pathAccountSid;
    private final String pathSid;
    private String friendlyName;
    private String apiVersion;
    private URI voiceUrl;
    private HttpMethod voiceMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private Boolean voiceCallerIdLookup;
    private URI smsUrl;
    private HttpMethod smsMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsFallbackMethod;
    private URI smsStatusCallback;
    private URI messageStatusCallback;

    /**
     * Construct a new ApplicationUpdater.
     *
     * @param pathSid The unique string that identifies the resource
     */
    public ApplicationUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Construct a new ApplicationUpdater.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param pathSid The unique string that identifies the resource
     */
    public ApplicationUpdater(final String pathAccountSid,
                              final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    /**
     * A descriptive string that you create to describe the resource. It can be up
     * to 64 characters long..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public ApplicationUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The API version to use to start a new TwiML session. Can be: `2010-04-01` or
     * `2008-08-01`. The default value is your account's default API version..
     *
     * @param apiVersion The API version to use to start a new TwiML session
     * @return this
     */
    public ApplicationUpdater setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * The URL we should call when the phone number assigned to this application
     * receives a call..
     *
     * @param voiceUrl The URL to call when the phone number receives a call
     * @return this
     */
    public ApplicationUpdater setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The URL we should call when the phone number assigned to this application
     * receives a call..
     *
     * @param voiceUrl The URL to call when the phone number receives a call
     * @return this
     */
    public ApplicationUpdater setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    /**
     * The HTTP method we should use to call `voice_url`. Can be: `GET` or `POST`..
     *
     * @param voiceMethod The HTTP method to use with the voice_url
     * @return this
     */
    public ApplicationUpdater setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * The URL that we should call when an error occurs retrieving or executing the
     * TwiML requested by `url`..
     *
     * @param voiceFallbackUrl The URL to call when a TwiML error occurs
     * @return this
     */
    public ApplicationUpdater setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call when an error occurs retrieving or executing the
     * TwiML requested by `url`..
     *
     * @param voiceFallbackUrl The URL to call when a TwiML error occurs
     * @return this
     */
    public ApplicationUpdater setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    /**
     * The HTTP method we should use to call `voice_fallback_url`. Can be: `GET` or
     * `POST`..
     *
     * @param voiceFallbackMethod The HTTP method to use with voice_fallback_url
     * @return this
     */
    public ApplicationUpdater setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application..
     *
     * @param statusCallback The URL to send status information to your application
     * @return this
     */
    public ApplicationUpdater setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application..
     *
     * @param statusCallback The URL to send status information to your application
     * @return this
     */
    public ApplicationUpdater setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method we should use to call `status_callback`. Can be: `GET` or
     * `POST`..
     *
     * @param statusCallbackMethod The HTTP method to use to call status_callback
     * @return this
     */
    public ApplicationUpdater setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * Whether we should look up the caller's caller-ID name from the CNAM database
     * (additional charges apply). Can be: `true` or `false`..
     *
     * @param voiceCallerIdLookup Whether to lookup the caller's name
     * @return this
     */
    public ApplicationUpdater setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    /**
     * The URL we should call when the phone number receives an incoming SMS
     * message..
     *
     * @param smsUrl The URL to call when the phone number receives an incoming SMS
     *               message
     * @return this
     */
    public ApplicationUpdater setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The URL we should call when the phone number receives an incoming SMS
     * message..
     *
     * @param smsUrl The URL to call when the phone number receives an incoming SMS
     *               message
     * @return this
     */
    public ApplicationUpdater setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    /**
     * The HTTP method we should use to call `sms_url`. Can be: `GET` or `POST`..
     *
     * @param smsMethod The HTTP method to use with sms_url
     * @return this
     */
    public ApplicationUpdater setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while retrieving or
     * executing the TwiML from `sms_url`..
     *
     * @param smsFallbackUrl The URL to call when an error occurs while retrieving
     *                       or executing the TwiML
     * @return this
     */
    public ApplicationUpdater setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while retrieving or
     * executing the TwiML from `sms_url`..
     *
     * @param smsFallbackUrl The URL to call when an error occurs while retrieving
     *                       or executing the TwiML
     * @return this
     */
    public ApplicationUpdater setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    /**
     * The HTTP method we should use to call `sms_fallback_url`. Can be: `GET` or
     * `POST`..
     *
     * @param smsFallbackMethod The HTTP method to use with sms_fallback_url
     * @return this
     */
    public ApplicationUpdater setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * The URL we should call using a POST method to send status information about
     * SMS messages sent by the application..
     *
     * @param smsStatusCallback The URL to send status information to your
     *                          application
     * @return this
     */
    public ApplicationUpdater setSmsStatusCallback(final URI smsStatusCallback) {
        this.smsStatusCallback = smsStatusCallback;
        return this;
    }

    /**
     * The URL we should call using a POST method to send status information about
     * SMS messages sent by the application..
     *
     * @param smsStatusCallback The URL to send status information to your
     *                          application
     * @return this
     */
    public ApplicationUpdater setSmsStatusCallback(final String smsStatusCallback) {
        return setSmsStatusCallback(Promoter.uriFromString(smsStatusCallback));
    }

    /**
     * The URL we should call using a POST method to send message status information
     * to your application..
     *
     * @param messageStatusCallback The URL to send message status information to
     *                              your application
     * @return this
     */
    public ApplicationUpdater setMessageStatusCallback(final URI messageStatusCallback) {
        this.messageStatusCallback = messageStatusCallback;
        return this;
    }

    /**
     * The URL we should call using a POST method to send message status information
     * to your application..
     *
     * @param messageStatusCallback The URL to send message status information to
     *                              your application
     * @return this
     */
    public ApplicationUpdater setMessageStatusCallback(final String messageStatusCallback) {
        return setMessageStatusCallback(Promoter.uriFromString(messageStatusCallback));
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Application
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Application update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Applications/" + this.pathSid + ".json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Application update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Application.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
        }

        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());
        }

        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());
        }

        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());
        }

        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }

        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());
        }

        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
        }

        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
        }

        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
        }

        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
        }

        if (smsStatusCallback != null) {
            request.addPostParam("SmsStatusCallback", smsStatusCallback.toString());
        }

        if (messageStatusCallback != null) {
            request.addPostParam("MessageStatusCallback", messageStatusCallback.toString());
        }
    }
}