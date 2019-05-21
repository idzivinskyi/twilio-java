/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.flexapi.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
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
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlexFlow extends Resource {
    private static final long serialVersionUID = 227807363812436L;

    public enum ChannelType {
        WEB("web"),
        SMS("sms"),
        FACEBOOK("facebook"),
        WHATSAPP("whatsapp"),
        LINE("line");

        private final String value;

        private ChannelType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ChannelType from a string.
         * @param value string value
         * @return generated ChannelType
         */
        @JsonCreator
        public static ChannelType forValue(final String value) {
            return Promoter.enumFromString(value, ChannelType.values());
        }
    }

    public enum IntegrationType {
        STUDIO("studio"),
        EXTERNAL("external"),
        TASK("task");

        private final String value;

        private IntegrationType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a IntegrationType from a string.
         * @param value string value
         * @return generated IntegrationType
         */
        @JsonCreator
        public static IntegrationType forValue(final String value) {
            return Promoter.enumFromString(value, IntegrationType.values());
        }
    }

    /**
     * Create a FlexFlowReader to execute read.
     *
     * @return FlexFlowReader capable of executing the read
     */
    public static FlexFlowReader reader() {
        return new FlexFlowReader();
    }

    /**
     * Create a FlexFlowFetcher to execute fetch.
     *
     * @param pathSid The unique ID of the FlexFlow
     * @return FlexFlowFetcher capable of executing the fetch
     */
    public static FlexFlowFetcher fetcher(final String pathSid) {
        return new FlexFlowFetcher(pathSid);
    }

    /**
     * Create a FlexFlowCreator to execute create.
     *
     * @param friendlyName Human readable description of this FlexFlow
     * @param chatServiceSid Service Sid.
     * @param channelType Channel type
     * @return FlexFlowCreator capable of executing the create
     */
    public static FlexFlowCreator creator(final String friendlyName,
                                          final String chatServiceSid,
                                          final FlexFlow.ChannelType channelType) {
        return new FlexFlowCreator(friendlyName, chatServiceSid, channelType);
    }

    /**
     * Create a FlexFlowUpdater to execute update.
     *
     * @param pathSid The unique ID of the FlexFlow
     * @return FlexFlowUpdater capable of executing the update
     */
    public static FlexFlowUpdater updater(final String pathSid) {
        return new FlexFlowUpdater(pathSid);
    }

    /**
     * Create a FlexFlowDeleter to execute delete.
     *
     * @param pathSid The unique ID of the FlexFlow
     * @return FlexFlowDeleter capable of executing the delete
     */
    public static FlexFlowDeleter deleter(final String pathSid) {
        return new FlexFlowDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a FlexFlow object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return FlexFlow object represented by the provided JSON
     */
    public static FlexFlow fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FlexFlow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a FlexFlow object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return FlexFlow object represented by the provided JSON
     */
    public static FlexFlow fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, FlexFlow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String sid;
    private final String friendlyName;
    private final String chatServiceSid;
    private final FlexFlow.ChannelType channelType;
    private final String contactIdentity;
    private final Boolean enabled;
    private final FlexFlow.IntegrationType integrationType;
    private final Map<String, Object> integration;
    private final Boolean longLived;
    private final URI url;

    @JsonCreator
    private FlexFlow(@JsonProperty("account_sid")
                     final String accountSid,
                     @JsonProperty("date_created")
                     final String dateCreated,
                     @JsonProperty("date_updated")
                     final String dateUpdated,
                     @JsonProperty("sid")
                     final String sid,
                     @JsonProperty("friendly_name")
                     final String friendlyName,
                     @JsonProperty("chat_service_sid")
                     final String chatServiceSid,
                     @JsonProperty("channel_type")
                     final FlexFlow.ChannelType channelType,
                     @JsonProperty("contact_identity")
                     final String contactIdentity,
                     @JsonProperty("enabled")
                     final Boolean enabled,
                     @JsonProperty("integration_type")
                     final FlexFlow.IntegrationType integrationType,
                     @JsonProperty("integration")
                     final Map<String, Object> integration,
                     @JsonProperty("long_lived")
                     final Boolean longLived,
                     @JsonProperty("url")
                     final URI url) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.chatServiceSid = chatServiceSid;
        this.channelType = channelType;
        this.contactIdentity = contactIdentity;
        this.enabled = enabled;
        this.integrationType = integrationType;
        this.integration = integration;
        this.longLived = longLived;
        this.url = url;
    }

    /**
     * Returns The The ID of the account that owns this Workflow.
     *
     * @return The ID of the account that owns this Workflow
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The time the FlexFlow was created, given as GMT in ISO 8601
     * format..
     *
     * @return The time the FlexFlow was created, given as GMT in ISO 8601 format.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The time the FlexFlow was last updated, given as GMT in ISO 8601
     * format..
     *
     * @return The time the FlexFlow was last updated, given as GMT in ISO 8601
     *         format.
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The unique ID of the FlexFlow.
     *
     * @return The unique ID of the FlexFlow
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Human readable description of this FlexFlow.
     *
     * @return Human readable description of this FlexFlow
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The Service Sid..
     *
     * @return Service Sid.
     */
    public final String getChatServiceSid() {
        return this.chatServiceSid;
    }

    /**
     * Returns The Channel type.
     *
     * @return Channel type
     */
    public final FlexFlow.ChannelType getChannelType() {
        return this.channelType;
    }

    /**
     * Returns The Channel contact Identity.
     *
     * @return Channel contact Identity
     */
    public final String getContactIdentity() {
        return this.contactIdentity;
    }

    /**
     * Returns The Boolean flag for enabling or disabling the FlexFlow.
     *
     * @return Boolean flag for enabling or disabling the FlexFlow
     */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * Returns The Integration type.
     *
     * @return Integration type
     */
    public final FlexFlow.IntegrationType getIntegrationType() {
        return this.integrationType;
    }

    /**
     * Returns The Integration block.
     *
     * @return Integration block
     */
    public final Map<String, Object> getIntegration() {
        return this.integration;
    }

    /**
     * Returns The Long Lived flag for new Channel.
     *
     * @return Long Lived flag for new Channel
     */
    public final Boolean getLongLived() {
        return this.longLived;
    }

    /**
     * Returns The The url.
     *
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FlexFlow other = (FlexFlow) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(chatServiceSid, other.chatServiceSid) &&
               Objects.equals(channelType, other.channelType) &&
               Objects.equals(contactIdentity, other.contactIdentity) &&
               Objects.equals(enabled, other.enabled) &&
               Objects.equals(integrationType, other.integrationType) &&
               Objects.equals(integration, other.integration) &&
               Objects.equals(longLived, other.longLived) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            sid,
                            friendlyName,
                            chatServiceSid,
                            channelType,
                            contactIdentity,
                            enabled,
                            integrationType,
                            integration,
                            longLived,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("sid", sid)
                          .add("friendlyName", friendlyName)
                          .add("chatServiceSid", chatServiceSid)
                          .add("channelType", channelType)
                          .add("contactIdentity", contactIdentity)
                          .add("enabled", enabled)
                          .add("integrationType", integrationType)
                          .add("integration", integration)
                          .add("longLived", longLived)
                          .add("url", url)
                          .toString();
    }
}