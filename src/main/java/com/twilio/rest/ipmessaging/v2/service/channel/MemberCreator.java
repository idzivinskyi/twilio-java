/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v2.service.channel;

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

public class MemberCreator extends Creator<Member> {
    private final String pathServiceSid;
    private final String pathChannelSid;
    private final String identity;
    private String roleSid;
    private Integer lastConsumedMessageIndex;
    private DateTime lastConsumptionTimestamp;
    private DateTime dateCreated;
    private DateTime dateUpdated;
    private String attributes;

    /**
     * Construct a new MemberCreator.
     *
     * @param pathServiceSid The SID of the Service to create the resource under
     * @param pathChannelSid The unique ID of the channel the new member belongs to
     * @param identity The `identity` value that identifies the new resource's User
     */
    public MemberCreator(final String pathServiceSid,
                         final String pathChannelSid,
                         final String identity) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
        this.identity = identity;
    }

    /**
     * The SID of the [Role](https://www.twilio.com/docs/chat/rest/roles) to assign
     * to the member. The default roles are those specified on the
     * [Service](https://www.twilio.com/docs/chat/api/services)..
     *
     * @param roleSid The SID of the Role to assign to the member
     * @return this
     */
    public MemberCreator setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    /**
     * The index of the last
     * [Message](https://www.twilio.com/docs/chat/rest/messages) in the
     * [Channel](https://www.twilio.com/docs/chat/channels) that the Member has
     * read. This parameter should only be used when recreating a Member from a
     * backup/separate source..
     *
     * @param lastConsumedMessageIndex The index of the last Message in the Channel
     *                                 the Member has read
     * @return this
     */
    public MemberCreator setLastConsumedMessageIndex(final Integer lastConsumedMessageIndex) {
        this.lastConsumedMessageIndex = lastConsumedMessageIndex;
        return this;
    }

    /**
     * The ISO 8601 timestamp string that represents the date-time of the last
     * [Message](https://www.twilio.com/docs/chat/rest/messages) read event for the
     * Member within the [Channel](https://www.twilio.com/docs/chat/channels)..
     *
     * @param lastConsumptionTimestamp The ISO 8601 based timestamp string
     *                                 representing the date-time of the last
     *                                 Message read event for the Member within the
     *                                 Channel
     * @return this
     */
    public MemberCreator setLastConsumptionTimestamp(final DateTime lastConsumptionTimestamp) {
        this.lastConsumptionTimestamp = lastConsumptionTimestamp;
        return this;
    }

    /**
     * The date, specified in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
     * format, to assign to the resource as the date it was created. The default
     * value is the current time set by the Chat service.  Note that this parameter
     * should only be used when a Member is being recreated from a backup/separate
     * source..
     *
     * @param dateCreated The ISO 8601 date and time in GMT when the resource was
     *                    created
     * @return this
     */
    public MemberCreator setDateCreated(final DateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * The date, specified in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
     * format, to assign to the resource as the date it was last updated. The
     * default value is `null`.  Note that this parameter should only be used when a
     * Member is being recreated from a backup/separate source and where a Member
     * was previously updated..
     *
     * @param dateUpdated The ISO 8601 date and time in GMT when the resource was
     *                    updated
     * @return this
     */
    public MemberCreator setDateUpdated(final DateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    /**
     * A valid JSON string that contains application-specific data..
     *
     * @param attributes A valid JSON string that contains application-specific data
     * @return this
     */
    public MemberCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Member
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Member create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Channels/" + this.pathChannelSid + "/Members",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Member creation failed: Unable to connect to server");
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

        return Member.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }

        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
        }

        if (lastConsumedMessageIndex != null) {
            request.addPostParam("LastConsumedMessageIndex", lastConsumedMessageIndex.toString());
        }

        if (lastConsumptionTimestamp != null) {
            request.addPostParam("LastConsumptionTimestamp", lastConsumptionTimestamp.toString());
        }

        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toString());
        }

        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toString());
        }

        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }
    }
}