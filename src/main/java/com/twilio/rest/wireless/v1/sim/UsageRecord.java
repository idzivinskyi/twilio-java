/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1.sim;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsageRecord extends Resource {
    private static final long serialVersionUID = 59802698873070L;

    public enum Granularity {
        HOURLY("hourly"),
        DAILY("daily"),
        ALL("all");

        private final String value;

        private Granularity(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Granularity from a string.
         * @param value string value
         * @return generated Granularity
         */
        @JsonCreator
        public static Granularity forValue(final String value) {
            return Promoter.enumFromString(value, Granularity.values());
        }
    }

    /**
     * Create a UsageRecordReader to execute read.
     *
     * @param pathSimSid The sim_sid
     * @return UsageRecordReader capable of executing the read
     */
    public static UsageRecordReader reader(final String pathSimSid) {
        return new UsageRecordReader(pathSimSid);
    }

    /**
     * Converts a JSON String into a UsageRecord object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return UsageRecord object represented by the provided JSON
     */
    public static UsageRecord fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UsageRecord.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a UsageRecord object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return UsageRecord object represented by the provided JSON
     */
    public static UsageRecord fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UsageRecord.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String simSid;
    private final String accountSid;
    private final Map<String, Object> period;
    private final Map<String, Object> commands;
    private final Map<String, Object> data;

    @JsonCreator
    private UsageRecord(@JsonProperty("sim_sid")
                        final String simSid,
                        @JsonProperty("account_sid")
                        final String accountSid,
                        @JsonProperty("period")
                        final Map<String, Object> period,
                        @JsonProperty("commands")
                        final Map<String, Object> commands,
                        @JsonProperty("data")
                        final Map<String, Object> data) {
        this.simSid = simSid;
        this.accountSid = accountSid;
        this.period = period;
        this.commands = commands;
        this.data = data;
    }

    /**
     * Returns The The unique id of the SIM resource that this Usage Record is for..
     *
     * @return The unique id of the SIM resource that this Usage Record is for.
     */
    public final String getSimSid() {
        return this.simSid;
    }

    /**
     * Returns The The unique id of the Account that the SIM belongs to..
     *
     * @return The unique id of the Account that the SIM belongs to.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The time period for which usage is reported..
     *
     * @return The time period for which usage is reported.
     */
    public final Map<String, Object> getPeriod() {
        return this.period;
    }

    /**
     * Returns The An object representing the Commands usage for the SIM over the
     * period..
     *
     * @return An object representing the Commands usage for the SIM over the
     *         period.
     */
    public final Map<String, Object> getCommands() {
        return this.commands;
    }

    /**
     * Returns The An object representing the Data usage for the SIM over the
     * period..
     *
     * @return An object representing the Data usage for the SIM over the period.
     */
    public final Map<String, Object> getData() {
        return this.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsageRecord other = (UsageRecord) o;

        return Objects.equals(simSid, other.simSid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(period, other.period) &&
               Objects.equals(commands, other.commands) &&
               Objects.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simSid,
                            accountSid,
                            period,
                            commands,
                            data);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("simSid", simSid)
                          .add("accountSid", accountSid)
                          .add("period", period)
                          .add("commands", commands)
                          .add("data", data)
                          .toString();
    }
}