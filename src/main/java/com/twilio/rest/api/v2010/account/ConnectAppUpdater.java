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
import java.util.List;

public class ConnectAppUpdater extends Updater<ConnectApp> {
    private String pathAccountSid;
    private final String pathSid;
    private URI authorizeRedirectUrl;
    private String companyName;
    private HttpMethod deauthorizeCallbackMethod;
    private URI deauthorizeCallbackUrl;
    private String description;
    private String friendlyName;
    private URI homepageUrl;
    private List<ConnectApp.Permission> permissions;

    /**
     * Construct a new ConnectAppUpdater.
     *
     * @param pathSid The unique string that identifies the resource
     */
    public ConnectAppUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Construct a new ConnectAppUpdater.
     *
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       update
     * @param pathSid The unique string that identifies the resource
     */
    public ConnectAppUpdater(final String pathAccountSid,
                             final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    /**
     * The URL to redirect the user to after we authenticate the user and obtain
     * authorization to access the Connect App..
     *
     * @param authorizeRedirectUrl The URL to redirect the user to after
     *                             authorization
     * @return this
     */
    public ConnectAppUpdater setAuthorizeRedirectUrl(final URI authorizeRedirectUrl) {
        this.authorizeRedirectUrl = authorizeRedirectUrl;
        return this;
    }

    /**
     * The URL to redirect the user to after we authenticate the user and obtain
     * authorization to access the Connect App..
     *
     * @param authorizeRedirectUrl The URL to redirect the user to after
     *                             authorization
     * @return this
     */
    public ConnectAppUpdater setAuthorizeRedirectUrl(final String authorizeRedirectUrl) {
        return setAuthorizeRedirectUrl(Promoter.uriFromString(authorizeRedirectUrl));
    }

    /**
     * The company name to set for the Connect App..
     *
     * @param companyName The company name to set for the Connect App
     * @return this
     */
    public ConnectAppUpdater setCompanyName(final String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * The HTTP method to use when calling `deauthorize_callback_url`..
     *
     * @param deauthorizeCallbackMethod The HTTP method to use when calling
     *                                  deauthorize_callback_url
     * @return this
     */
    public ConnectAppUpdater setDeauthorizeCallbackMethod(final HttpMethod deauthorizeCallbackMethod) {
        this.deauthorizeCallbackMethod = deauthorizeCallbackMethod;
        return this;
    }

    /**
     * The URL to call using the `deauthorize_callback_method` to de-authorize the
     * Connect App..
     *
     * @param deauthorizeCallbackUrl The URL to call to de-authorize the Connect App
     * @return this
     */
    public ConnectAppUpdater setDeauthorizeCallbackUrl(final URI deauthorizeCallbackUrl) {
        this.deauthorizeCallbackUrl = deauthorizeCallbackUrl;
        return this;
    }

    /**
     * The URL to call using the `deauthorize_callback_method` to de-authorize the
     * Connect App..
     *
     * @param deauthorizeCallbackUrl The URL to call to de-authorize the Connect App
     * @return this
     */
    public ConnectAppUpdater setDeauthorizeCallbackUrl(final String deauthorizeCallbackUrl) {
        return setDeauthorizeCallbackUrl(Promoter.uriFromString(deauthorizeCallbackUrl));
    }

    /**
     * A description of the Connect App..
     *
     * @param description A description of the Connect App
     * @return this
     */
    public ConnectAppUpdater setDescription(final String description) {
        this.description = description;
        return this;
    }

    /**
     * A descriptive string that you create to describe the resource. It can be up
     * to 64 characters long..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public ConnectAppUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * A public URL where users can obtain more information about this Connect App..
     *
     * @param homepageUrl A public URL where users can obtain more information
     * @return this
     */
    public ConnectAppUpdater setHomepageUrl(final URI homepageUrl) {
        this.homepageUrl = homepageUrl;
        return this;
    }

    /**
     * A public URL where users can obtain more information about this Connect App..
     *
     * @param homepageUrl A public URL where users can obtain more information
     * @return this
     */
    public ConnectAppUpdater setHomepageUrl(final String homepageUrl) {
        return setHomepageUrl(Promoter.uriFromString(homepageUrl));
    }

    /**
     * A comma-separated list of the permissions you will request from the users of
     * this ConnectApp.  Can include: `get-all` and `post-all`..
     *
     * @param permissions The set of permissions that your ConnectApp will request
     * @return this
     */
    public ConnectAppUpdater setPermissions(final List<ConnectApp.Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    /**
     * A comma-separated list of the permissions you will request from the users of
     * this ConnectApp.  Can include: `get-all` and `post-all`..
     *
     * @param permissions The set of permissions that your ConnectApp will request
     * @return this
     */
    public ConnectAppUpdater setPermissions(final ConnectApp.Permission permissions) {
        return setPermissions(Promoter.listOfOne(permissions));
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated ConnectApp
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ConnectApp update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/ConnectApps/" + this.pathSid + ".json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ConnectApp update failed: Unable to connect to server");
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

        return ConnectApp.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (authorizeRedirectUrl != null) {
            request.addPostParam("AuthorizeRedirectUrl", authorizeRedirectUrl.toString());
        }

        if (companyName != null) {
            request.addPostParam("CompanyName", companyName);
        }

        if (deauthorizeCallbackMethod != null) {
            request.addPostParam("DeauthorizeCallbackMethod", deauthorizeCallbackMethod.toString());
        }

        if (deauthorizeCallbackUrl != null) {
            request.addPostParam("DeauthorizeCallbackUrl", deauthorizeCallbackUrl.toString());
        }

        if (description != null) {
            request.addPostParam("Description", description);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (homepageUrl != null) {
            request.addPostParam("HomepageUrl", homepageUrl.toString());
        }

        if (permissions != null) {
            for (ConnectApp.Permission prop : permissions) {
                request.addPostParam("Permissions", prop.toString());
            }
        }
    }
}