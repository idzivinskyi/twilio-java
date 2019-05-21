/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.call;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.FeedbackIssue;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackSummary extends Resource {
    private static final long serialVersionUID = 164951485289659L;

    public enum Status {
        QUEUED("queued"),
        IN_PROGRESS("in-progress"),
        COMPLETED("completed"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a FeedbackSummaryCreator to execute create.
     *
     * @param pathAccountSid The unique sid that identifies this account
     * @param startDate Only include feedback given on or after this date
     * @param endDate Only include feedback given on or before this date
     * @return FeedbackSummaryCreator capable of executing the create
     */
    public static FeedbackSummaryCreator creator(final String pathAccountSid,
                                                 final LocalDate startDate,
                                                 final LocalDate endDate) {
        return new FeedbackSummaryCreator(pathAccountSid, startDate, endDate);
    }

    /**
     * Create a FeedbackSummaryCreator to execute create.
     *
     * @param startDate Only include feedback given on or after this date
     * @param endDate Only include feedback given on or before this date
     * @return FeedbackSummaryCreator capable of executing the create
     */
    public static FeedbackSummaryCreator creator(final LocalDate startDate,
                                                 final LocalDate endDate) {
        return new FeedbackSummaryCreator(startDate, endDate);
    }

    /**
     * Create a FeedbackSummaryFetcher to execute fetch.
     *
     * @param pathAccountSid The unique sid that identifies this account
     * @param pathSid A string that uniquely identifies this feedback summary
     *                resource
     * @return FeedbackSummaryFetcher capable of executing the fetch
     */
    public static FeedbackSummaryFetcher fetcher(final String pathAccountSid,
                                                 final String pathSid) {
        return new FeedbackSummaryFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a FeedbackSummaryFetcher to execute fetch.
     *
     * @param pathSid A string that uniquely identifies this feedback summary
     *                resource
     * @return FeedbackSummaryFetcher capable of executing the fetch
     */
    public static FeedbackSummaryFetcher fetcher(final String pathSid) {
        return new FeedbackSummaryFetcher(pathSid);
    }

    /**
     * Create a FeedbackSummaryDeleter to execute delete.
     *
     * @param pathAccountSid The unique sid that identifies this account
     * @param pathSid A string that uniquely identifies this feedback summary
     *                resource
     * @return FeedbackSummaryDeleter capable of executing the delete
     */
    public static FeedbackSummaryDeleter deleter(final String pathAccountSid,
                                                 final String pathSid) {
        return new FeedbackSummaryDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a FeedbackSummaryDeleter to execute delete.
     *
     * @param pathSid A string that uniquely identifies this feedback summary
     *                resource
     * @return FeedbackSummaryDeleter capable of executing the delete
     */
    public static FeedbackSummaryDeleter deleter(final String pathSid) {
        return new FeedbackSummaryDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a FeedbackSummary object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return FeedbackSummary object represented by the provided JSON
     */
    public static FeedbackSummary fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FeedbackSummary.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a FeedbackSummary object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return FeedbackSummary object represented by the provided JSON
     */
    public static FeedbackSummary fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FeedbackSummary.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Integer callCount;
    private final Integer callFeedbackCount;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final DateTime endDate;
    private final Boolean includeSubaccounts;
    private final List<FeedbackIssue> issues;
    private final BigDecimal qualityScoreAverage;
    private final BigDecimal qualityScoreMedian;
    private final BigDecimal qualityScoreStandardDeviation;
    private final String sid;
    private final DateTime startDate;
    private final FeedbackSummary.Status status;

    @JsonCreator
    private FeedbackSummary(@JsonProperty("account_sid")
                            final String accountSid,
                            @JsonProperty("call_count")
                            final Integer callCount,
                            @JsonProperty("call_feedback_count")
                            final Integer callFeedbackCount,
                            @JsonProperty("date_created")
                            final String dateCreated,
                            @JsonProperty("date_updated")
                            final String dateUpdated,
                            @JsonProperty("end_date")
                            final String endDate,
                            @JsonProperty("include_subaccounts")
                            final Boolean includeSubaccounts,
                            @JsonProperty("issues")
                            final List<FeedbackIssue> issues,
                            @JsonProperty("quality_score_average")
                            final BigDecimal qualityScoreAverage,
                            @JsonProperty("quality_score_median")
                            final BigDecimal qualityScoreMedian,
                            @JsonProperty("quality_score_standard_deviation")
                            final BigDecimal qualityScoreStandardDeviation,
                            @JsonProperty("sid")
                            final String sid,
                            @JsonProperty("start_date")
                            final String startDate,
                            @JsonProperty("status")
                            final FeedbackSummary.Status status) {
        this.accountSid = accountSid;
        this.callCount = callCount;
        this.callFeedbackCount = callFeedbackCount;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.endDate = DateConverter.iso8601DateTimeFromString(endDate);
        this.includeSubaccounts = includeSubaccounts;
        this.issues = issues;
        this.qualityScoreAverage = qualityScoreAverage;
        this.qualityScoreMedian = qualityScoreMedian;
        this.qualityScoreStandardDeviation = qualityScoreStandardDeviation;
        this.sid = sid;
        this.startDate = DateConverter.iso8601DateTimeFromString(startDate);
        this.status = status;
    }

    /**
     * Returns The The unique sid that identifies this account.
     *
     * @return The unique sid that identifies this account
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The total number of calls.
     *
     * @return The total number of calls
     */
    public final Integer getCallCount() {
        return this.callCount;
    }

    /**
     * Returns The The total number of calls with a feedback entry.
     *
     * @return The total number of calls with a feedback entry
     */
    public final Integer getCallFeedbackCount() {
        return this.callFeedbackCount;
    }

    /**
     * Returns The The date this resource was created.
     *
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this resource was last updated.
     *
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The latest feedback entry date in the summary.
     *
     * @return The latest feedback entry date in the summary
     */
    public final DateTime getEndDate() {
        return this.endDate;
    }

    /**
     * Returns The Whether the feedback summary includes subaccounts.
     *
     * @return Whether the feedback summary includes subaccounts
     */
    public final Boolean getIncludeSubaccounts() {
        return this.includeSubaccounts;
    }

    /**
     * Returns The Issues experienced during the call.
     *
     * @return Issues experienced during the call
     */
    public final List<FeedbackIssue> getIssues() {
        return this.issues;
    }

    /**
     * Returns The The average QualityScore of the feedback entries.
     *
     * @return The average QualityScore of the feedback entries
     */
    public final BigDecimal getQualityScoreAverage() {
        return this.qualityScoreAverage;
    }

    /**
     * Returns The The median QualityScore of the feedback entries.
     *
     * @return The median QualityScore of the feedback entries
     */
    public final BigDecimal getQualityScoreMedian() {
        return this.qualityScoreMedian;
    }

    /**
     * Returns The The standard deviation of the quality scores.
     *
     * @return The standard deviation of the quality scores
     */
    public final BigDecimal getQualityScoreStandardDeviation() {
        return this.qualityScoreStandardDeviation;
    }

    /**
     * Returns The A string that uniquely identifies this feedback entry.
     *
     * @return A string that uniquely identifies this feedback entry
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The earliest feedback entry date in the summary.
     *
     * @return The earliest feedback entry date in the summary
     */
    public final DateTime getStartDate() {
        return this.startDate;
    }

    /**
     * Returns The The status of the feedback summary.
     *
     * @return The status of the feedback summary
     */
    public final FeedbackSummary.Status getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeedbackSummary other = (FeedbackSummary) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(callCount, other.callCount) &&
               Objects.equals(callFeedbackCount, other.callFeedbackCount) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(endDate, other.endDate) &&
               Objects.equals(includeSubaccounts, other.includeSubaccounts) &&
               Objects.equals(issues, other.issues) &&
               Objects.equals(qualityScoreAverage, other.qualityScoreAverage) &&
               Objects.equals(qualityScoreMedian, other.qualityScoreMedian) &&
               Objects.equals(qualityScoreStandardDeviation, other.qualityScoreStandardDeviation) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(startDate, other.startDate) &&
               Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            callCount,
                            callFeedbackCount,
                            dateCreated,
                            dateUpdated,
                            endDate,
                            includeSubaccounts,
                            issues,
                            qualityScoreAverage,
                            qualityScoreMedian,
                            qualityScoreStandardDeviation,
                            sid,
                            startDate,
                            status);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("callCount", callCount)
                          .add("callFeedbackCount", callFeedbackCount)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("endDate", endDate)
                          .add("includeSubaccounts", includeSubaccounts)
                          .add("issues", issues)
                          .add("qualityScoreAverage", qualityScoreAverage)
                          .add("qualityScoreMedian", qualityScoreMedian)
                          .add("qualityScoreStandardDeviation", qualityScoreStandardDeviation)
                          .add("sid", sid)
                          .add("startDate", startDate)
                          .add("status", status)
                          .toString();
    }
}