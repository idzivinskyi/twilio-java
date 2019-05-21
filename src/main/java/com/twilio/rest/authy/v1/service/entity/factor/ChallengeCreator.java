/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.authy.v1.service.entity.factor;

import com.twilio.base.Creator;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class ChallengeCreator extends Creator<Challenge> {
    private final String pathServiceSid;
    private final String pathIdentity;
    private final String pathFactorSid;
    private DateTime expirationDate;
    private String details;
    private String hiddenDetails;

    /**
     * Construct a new ChallengeCreator.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique identity of the Entity
     * @param pathFactorSid Factor Sid.
     */
    public ChallengeCreator(final String pathServiceSid,
                            final String pathIdentity,
                            final String pathFactorSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.pathFactorSid = pathFactorSid;
    }

    /**
     * The future date in which this Challenge will expire, given in ISO 8601 format
     * (https://en.wikipedia.org/wiki/ISO_8601)..
     *
     * @param expirationDate The future date in which this Challenge will expire
     * @return this
     */
    public ChallengeCreator setExpirationDate(final DateTime expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    /**
     * Details provided to give context about the Challenge. Shown to the end user..
     *
     * @param details Public details provided to contextualize the Challenge
     * @return this
     */
    public ChallengeCreator setDetails(final String details) {
        this.details = details;
        return this;
    }

    /**
     * Details provided to give context about the Challenge. Not shown to the end
     * user..
     *
     * @param hiddenDetails Hidden details provided to contextualize the Challenge
     * @return this
     */
    public ChallengeCreator setHiddenDetails(final String hiddenDetails) {
        this.hiddenDetails = hiddenDetails;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Challenge
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Challenge create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.AUTHY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Entities/" + this.pathIdentity + "/Factors/" + this.pathFactorSid + "/Challenges",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Challenge creation failed: Unable to connect to server");
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

        return Challenge.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (expirationDate != null) {
            request.addPostParam("ExpirationDate", expirationDate.toString());
        }

        if (details != null) {
            request.addPostParam("Details", details);
        }

        if (hiddenDetails != null) {
            request.addPostParam("HiddenDetails", hiddenDetails);
        }
    }
}