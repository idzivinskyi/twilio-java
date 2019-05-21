/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

import com.twilio.base.Fetcher;
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

public class WorkersCumulativeStatisticsFetcher extends Fetcher<WorkersCumulativeStatistics> {
    private final String pathWorkspaceSid;
    private DateTime endDate;
    private Integer minutes;
    private DateTime startDate;
    private String taskChannel;

    /**
     * Construct a new WorkersCumulativeStatisticsFetcher.
     *
     * @param pathWorkspaceSid The workspace_sid
     */
    public WorkersCumulativeStatisticsFetcher(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    /**
     * Filter cumulative statistics by a end date. This is helpful for defining a
     * range of statistics to capture. Input is a string of the format:
     * yyyy-MM-dd'T'HH:mm:ss'Z'..
     *
     * @param endDate Filter cumulative statistics by a end date.
     * @return this
     */
    public WorkersCumulativeStatisticsFetcher setEndDate(final DateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Filter cumulative statistics by up to 'x' minutes in the past. This is
     * helpful for statistics for the last 15 minutes, 240 minutes (4 hours), and
     * 480 minutes (8 hours) to see trends. Defaults to 15 minutes..
     *
     * @param minutes Filter cumulative statistics by up to 'x' minutes in the past.
     * @return this
     */
    public WorkersCumulativeStatisticsFetcher setMinutes(final Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    /**
     * Filter cumulative statistics by a start date. This is helpful for defining a
     * range of statistics to capture. Input is a string of the format:
     * yyyy-MM-dd'T'HH:mm:ss'Z'..
     *
     * @param startDate Filter cumulative statistics by a start date.
     * @return this
     */
    public WorkersCumulativeStatisticsFetcher setStartDate(final DateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Filter cumulative statistics by TaskChannel. Takes in a Unique Name ("voice",
     * "sms", "default", etc.) or a TaskChannelSid..
     *
     * @param taskChannel Filter cumulative statistics by TaskChannel.
     * @return this
     */
    public WorkersCumulativeStatisticsFetcher setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched WorkersCumulativeStatistics
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public WorkersCumulativeStatistics fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Workers/CumulativeStatistics",
            client.getRegion()
        );

        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("WorkersCumulativeStatistics fetch failed: Unable to connect to server");
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

        return WorkersCumulativeStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toString());
        }

        if (minutes != null) {
            request.addQueryParam("Minutes", minutes.toString());
        }

        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toString());
        }

        if (taskChannel != null) {
            request.addQueryParam("TaskChannel", taskChannel);
        }
    }
}