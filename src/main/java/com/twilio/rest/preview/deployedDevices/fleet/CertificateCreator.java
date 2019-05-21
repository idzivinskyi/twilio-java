/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.deployedDevices.fleet;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class CertificateCreator extends Creator<Certificate> {
    private final String pathFleetSid;
    private final String certificateData;
    private String friendlyName;
    private String deviceSid;

    /**
     * Construct a new CertificateCreator.
     *
     * @param pathFleetSid The fleet_sid
     * @param certificateData The public certificate data.
     */
    public CertificateCreator(final String pathFleetSid,
                              final String certificateData) {
        this.pathFleetSid = pathFleetSid;
        this.certificateData = certificateData;
    }

    /**
     * Provides a human readable descriptive text for this Certificate credential,
     * up to 256 characters long..
     *
     * @param friendlyName The human readable description for this Certificate.
     * @return this
     */
    public CertificateCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Provides the unique string identifier of an existing Device to become
     * authenticated with this Certificate credential..
     *
     * @param deviceSid The unique identifier of a Device to be authenticated.
     * @return this
     */
    public CertificateCreator setDeviceSid(final String deviceSid) {
        this.deviceSid = deviceSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Certificate
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Certificate create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/DeployedDevices/Fleets/" + this.pathFleetSid + "/Certificates",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Certificate creation failed: Unable to connect to server");
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

        return Certificate.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (certificateData != null) {
            request.addPostParam("CertificateData", certificateData);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (deviceSid != null) {
            request.addPostParam("DeviceSid", deviceSid);
        }
    }
}