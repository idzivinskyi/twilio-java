/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ActivityCreator extends Creator<Activity> {
    private final String pathWorkspaceSid;
    private final String friendlyName;
    private Boolean available;

    /**
     * Construct a new ActivityCreator.
     *
     * @param pathWorkspaceSid The workspace_sid
     * @param friendlyName A human-readable name for the Activity, such as 'On
     *                     Call', 'Break', 'Email', etc.
     */
    public ActivityCreator(final String pathWorkspaceSid,
                           final String friendlyName) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.friendlyName = friendlyName;
    }

    /**
     * Boolean value indicating whether the worker should be eligible to receive a
     * Task when they occupy this Activity. For example, a call center might have an
     * activity named 'On Call' with an availability set to 'false'. Note: This can
     * be 'true', '1' or 'yes' to indicate a true value. All other values will
     * represent false. Defaults to false..
     *
     * @param available Boolean value indicating whether the worker should be
     *                  eligible to receive a Task when they occupy this Activity.
     * @return this
     */
    public ActivityCreator setAvailable(final Boolean available) {
        this.available = available;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Activity
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Activity create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Activities",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Activity creation failed: Unable to connect to server");
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

        return Activity.fromJson(response.getStream(), client.getObjectMapper());
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

        if (available != null) {
            request.addPostParam("Available", available.toString());
        }
    }
}