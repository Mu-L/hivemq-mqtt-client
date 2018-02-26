package org.mqttbee.api.mqtt.mqtt5.message.publish.pubrel;

import org.mqttbee.annotations.NotNull;
import org.mqttbee.api.mqtt.mqtt5.datatypes.Mqtt5UserProperties;

/**
 * @author Silvio Giebl
 */
public interface Mqtt5PubRelBuilder {

    Mqtt5PubRelBuilder withUserProperties(@NotNull Mqtt5UserProperties userProperties);

}