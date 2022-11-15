package com.binance.client;

import com.binance.client.exception.BinanceApiException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * The configuration for the subscription APIs
 */
public class SubscriptionOptions {

    private String uri = "wss://api.binance.pro/";
    private boolean isAutoReconnect = true;
    private long receiveLimitMs = TimeUnit.DAYS.toMillis(1);
    private int connectionDelayOnFailure = 1;

    public SubscriptionOptions(SubscriptionOptions options) {
        this.uri = options.uri;
        this.isAutoReconnect = options.isAutoReconnect;
        this.receiveLimitMs = options.receiveLimitMs;
        this.connectionDelayOnFailure = options.connectionDelayOnFailure;
    }

    public SubscriptionOptions() {
    }

    /**
     * Set the URI for subscription.
     *
     * @param uri The URI name like "wss://api.binance.pro".
     */
    public void setUri(String uri) {
        try {
            URI u = new URI(uri);
            this.uri = u.toString();
        } catch (Exception e) {
            throw new BinanceApiException(BinanceApiException.INPUT_ERROR, "The URI is incorrect: " + e.getMessage());
        }
        this.uri = uri;
    }

    /**
     * Set the receive limit in millisecond. If no message is received within this
     * limit time, the connection will be disconnected.
     *
     * @param receiveLimitMs The receive limit in millisecond.
     */
    public void setReceiveLimitMs(long receiveLimitMs) {
        this.receiveLimitMs = receiveLimitMs;
    }

    /**
     * If auto reconnect is enabled, specify the delay time before reconnect.
     *
     * @param connectionDelayOnFailure The delay time in second.
     */
    public void setConnectionDelayOnFailure(int connectionDelayOnFailure) {
        this.connectionDelayOnFailure = connectionDelayOnFailure;
    }

    /**
     * When the connection lost is happening on the subscription line, specify
     * whether the client reconnect to server automatically.
     * <p>
     * The connection lost means:
     * <ul>
     * <li>Caused by network problem</li>
     * <li>The connection close triggered by server (happened every 24 hours)</li>
     * <li>No any message can be received from server within a specified time, see
     * {@link #setReceiveLimitMs(long)} (int)}</li>
     * </ul>
     *
     * @param isAutoReconnect The boolean flag, true for enable, false for disable
     * @return Return self for chaining
     */
    public SubscriptionOptions setAutoReconnect(boolean isAutoReconnect) {
        this.isAutoReconnect = isAutoReconnect;
        return this;
    }

    public boolean isAutoReconnect() {
        return isAutoReconnect;
    }

    public long getReceiveLimitMs() {
        return receiveLimitMs;
    }

    public int getConnectionDelayOnFailure() {
        return connectionDelayOnFailure;
    }

    public String getUri() {
        return uri;
    }
}
