package org.mqttbee.mqtt.codec.decoder;

import org.mqttbee.annotations.NotNull;
import org.mqttbee.annotations.Nullable;
import org.mqttbee.api.mqtt.mqtt5.message.Mqtt5MessageType;
import org.mqttbee.api.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;

/**
 * Exception when decoding an invalid MQTT message.
 *
 * @author Silvio Giebl
 */
public class MqttDecoderException extends Exception {

    private final Mqtt5DisconnectReasonCode reasonCode;
    private Mqtt5MessageType messageType;

    /**
     * Creates a new Decoder exception with the given default reason code and message.
     *
     * @param reasonCode the reason code of the decoder exception.
     * @param message    the description of the decoder exception.
     */
    public MqttDecoderException(@NotNull final Mqtt5DisconnectReasonCode reasonCode, @NotNull final String message) {
        super(message);
        this.reasonCode = reasonCode;
    }

    /**
     * Creates a new Decoder exception with the default reason code {@link Mqtt5DisconnectReasonCode#MALFORMED_PACKET}.
     *
     * @param message the description of the decoder exception.
     */
    public MqttDecoderException(@NotNull final String message) {
        this(Mqtt5DisconnectReasonCode.MALFORMED_PACKET, message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    /**
     * Adds the MQTT message type which caused the decoder exception.
     *
     * @param messageType the MQTT message type which caused the decoder exception.
     */
    public void setMessageType(@Nullable final Mqtt5MessageType messageType) {
        this.messageType = messageType;
    }

    /**
     * @return the reason code of the decoder exception.
     */
    @NotNull
    public Mqtt5DisconnectReasonCode getReasonCode() {
        return reasonCode;
    }

    @Override
    public String getMessage() {
        return "Decoder exception for " + ((messageType == null) ? "UNKNOWN" : messageType) + ": " + super.getMessage();
    }

}
