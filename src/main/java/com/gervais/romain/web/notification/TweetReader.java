package com.gervais.romain.web.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.Get;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;

import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by Romain on 01/05/14.
 */
@ManagedService(path = "/notifications/tweets")
public final class TweetReader {

}
