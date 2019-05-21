/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.video.v1;

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
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room extends Resource {
    private static final long serialVersionUID = 123703237879933L;

    public enum RoomStatus {
        IN_PROGRESS("in-progress"),
        COMPLETED("completed"),
        FAILED("failed");

        private final String value;

        private RoomStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a RoomStatus from a string.
         * @param value string value
         * @return generated RoomStatus
         */
        @JsonCreator
        public static RoomStatus forValue(final String value) {
            return Promoter.enumFromString(value, RoomStatus.values());
        }
    }

    public enum RoomType {
        PEER_TO_PEER("peer-to-peer"),
        GROUP("group"),
        GROUP_SMALL("group-small");

        private final String value;

        private RoomType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a RoomType from a string.
         * @param value string value
         * @return generated RoomType
         */
        @JsonCreator
        public static RoomType forValue(final String value) {
            return Promoter.enumFromString(value, RoomType.values());
        }
    }

    public enum VideoCodec {
        VP8("VP8"),
        H264("H264");

        private final String value;

        private VideoCodec(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a VideoCodec from a string.
         * @param value string value
         * @return generated VideoCodec
         */
        @JsonCreator
        public static VideoCodec forValue(final String value) {
            return Promoter.enumFromString(value, VideoCodec.values());
        }
    }

    /**
     * Create a RoomFetcher to execute fetch.
     *
     * @param pathSid The Room Sid or name that uniquely identifies this resource.
     * @return RoomFetcher capable of executing the fetch
     */
    public static RoomFetcher fetcher(final String pathSid) {
        return new RoomFetcher(pathSid);
    }

    /**
     * Create a RoomCreator to execute create.
     *
     * @return RoomCreator capable of executing the create
     */
    public static RoomCreator creator() {
        return new RoomCreator();
    }

    /**
     * Create a RoomReader to execute read.
     *
     * @return RoomReader capable of executing the read
     */
    public static RoomReader reader() {
        return new RoomReader();
    }

    /**
     * Create a RoomUpdater to execute update.
     *
     * @param pathSid The Room Sid or name that uniquely identifies this resource.
     * @param status Set to completed to end the Room.
     * @return RoomUpdater capable of executing the update
     */
    public static RoomUpdater updater(final String pathSid,
                                      final Room.RoomStatus status) {
        return new RoomUpdater(pathSid, status);
    }

    /**
     * Converts a JSON String into a Room object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Room object represented by the provided JSON
     */
    public static Room fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Room.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Room object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Room object represented by the provided JSON
     */
    public static Room fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Room.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final Room.RoomStatus status;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String accountSid;
    private final Boolean enableTurn;
    private final String uniqueName;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final DateTime endTime;
    private final Integer duration;
    private final Room.RoomType type;
    private final Integer maxParticipants;
    private final Boolean recordParticipantsOnConnect;
    private final List<Room.VideoCodec> videoCodecs;
    private final String mediaRegion;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Room(@JsonProperty("sid")
                 final String sid,
                 @JsonProperty("status")
                 final Room.RoomStatus status,
                 @JsonProperty("date_created")
                 final String dateCreated,
                 @JsonProperty("date_updated")
                 final String dateUpdated,
                 @JsonProperty("account_sid")
                 final String accountSid,
                 @JsonProperty("enable_turn")
                 final Boolean enableTurn,
                 @JsonProperty("unique_name")
                 final String uniqueName,
                 @JsonProperty("status_callback")
                 final URI statusCallback,
                 @JsonProperty("status_callback_method")
                 final HttpMethod statusCallbackMethod,
                 @JsonProperty("end_time")
                 final String endTime,
                 @JsonProperty("duration")
                 final Integer duration,
                 @JsonProperty("type")
                 final Room.RoomType type,
                 @JsonProperty("max_participants")
                 final Integer maxParticipants,
                 @JsonProperty("record_participants_on_connect")
                 final Boolean recordParticipantsOnConnect,
                 @JsonProperty("video_codecs")
                 final List<Room.VideoCodec> videoCodecs,
                 @JsonProperty("media_region")
                 final String mediaRegion,
                 @JsonProperty("url")
                 final URI url,
                 @JsonProperty("links")
                 final Map<String, String> links) {
        this.sid = sid;
        this.status = status;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.accountSid = accountSid;
        this.enableTurn = enableTurn;
        this.uniqueName = uniqueName;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.endTime = DateConverter.iso8601DateTimeFromString(endTime);
        this.duration = duration;
        this.type = type;
        this.maxParticipants = maxParticipants;
        this.recordParticipantsOnConnect = recordParticipantsOnConnect;
        this.videoCodecs = videoCodecs;
        this.mediaRegion = mediaRegion;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The A system-generated 34-character string that uniquely identifies
     * this resource..
     *
     * @return A system-generated 34-character string that uniquely identifies this
     *         resource.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The A string representing the status of the Room..
     *
     * @return A string representing the status of the Room.
     */
    public final Room.RoomStatus getStatus() {
        return this.status;
    }

    /**
     * Returns The The date that this resource was created, given as a UTC ISO 8601
     * Timestamp..
     *
     * @return The date that this resource was created, given as a UTC ISO 8601
     *         Timestamp.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date that this resource was last updated, given as a UTC ISO
     * 8601 Timestamp..
     *
     * @return The date that this resource was last updated, given as a UTC ISO
     *         8601 Timestamp.
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The unique ID of the Account associated with this Room..
     *
     * @return The unique ID of the Account associated with this Room.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The Enable Twilio's Network Traversal TURN service..
     *
     * @return Enable Twilio's Network Traversal TURN service.
     */
    public final Boolean getEnableTurn() {
        return this.enableTurn;
    }

    /**
     * Returns The A developer-supplied Name of the Room..
     *
     * @return A developer-supplied Name of the Room.
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The A URL that Twilio sends asynchronous webhook requests to on every
     * Room event..
     *
     * @return A URL that Twilio sends asynchronous webhook requests to on every
     *         Room event.
     */
    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    /**
     * Returns The HTTP method Twilio should use when requesting the above URL..
     *
     * @return HTTP method Twilio should use when requesting the above URL.
     */
    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    /**
     * Returns The The end time of the Room, given as a UTC ISO 8601 Timestamp..
     *
     * @return The end time of the Room, given as a UTC ISO 8601 Timestamp.
     */
    public final DateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Returns The The duration of the Room in seconds..
     *
     * @return The duration of the Room in seconds.
     */
    public final Integer getDuration() {
        return this.duration;
    }

    /**
     * Returns The Type of Room, either peer-to-peer, group-small or group..
     *
     * @return Type of Room, either peer-to-peer, group-small or group.
     */
    public final Room.RoomType getType() {
        return this.type;
    }

    /**
     * Returns The Maximum number of concurrent Participants allowed in the Room..
     *
     * @return Maximum number of concurrent Participants allowed in the Room.
     */
    public final Integer getMaxParticipants() {
        return this.maxParticipants;
    }

    /**
     * Returns The Start recording when Participants connect..
     *
     * @return Start recording when Participants connect.
     */
    public final Boolean getRecordParticipantsOnConnect() {
        return this.recordParticipantsOnConnect;
    }

    /**
     * Returns The The video_codecs.
     *
     * @return The video_codecs
     */
    public final List<Room.VideoCodec> getVideoCodecs() {
        return this.videoCodecs;
    }

    /**
     * Returns The Region for the media server in Group Rooms..
     *
     * @return Region for the media server in Group Rooms.
     */
    public final String getMediaRegion() {
        return this.mediaRegion;
    }

    /**
     * Returns The The absolute URL for this resource..
     *
     * @return The absolute URL for this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The links.
     *
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Room other = (Room) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(status, other.status) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(enableTurn, other.enableTurn) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(statusCallback, other.statusCallback) &&
               Objects.equals(statusCallbackMethod, other.statusCallbackMethod) &&
               Objects.equals(endTime, other.endTime) &&
               Objects.equals(duration, other.duration) &&
               Objects.equals(type, other.type) &&
               Objects.equals(maxParticipants, other.maxParticipants) &&
               Objects.equals(recordParticipantsOnConnect, other.recordParticipantsOnConnect) &&
               Objects.equals(videoCodecs, other.videoCodecs) &&
               Objects.equals(mediaRegion, other.mediaRegion) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            status,
                            dateCreated,
                            dateUpdated,
                            accountSid,
                            enableTurn,
                            uniqueName,
                            statusCallback,
                            statusCallbackMethod,
                            endTime,
                            duration,
                            type,
                            maxParticipants,
                            recordParticipantsOnConnect,
                            videoCodecs,
                            mediaRegion,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("status", status)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("accountSid", accountSid)
                          .add("enableTurn", enableTurn)
                          .add("uniqueName", uniqueName)
                          .add("statusCallback", statusCallback)
                          .add("statusCallbackMethod", statusCallbackMethod)
                          .add("endTime", endTime)
                          .add("duration", duration)
                          .add("type", type)
                          .add("maxParticipants", maxParticipants)
                          .add("recordParticipantsOnConnect", recordParticipantsOnConnect)
                          .add("videoCodecs", videoCodecs)
                          .add("mediaRegion", mediaRegion)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}