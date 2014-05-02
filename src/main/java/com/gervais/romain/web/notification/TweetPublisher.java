package com.gervais.romain.web.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Romain on 02/05/14.
 */
public class TweetPublisher extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");

        // broadcast to all atmosphere connected client
        BroadcasterFactory broadcasterFactory = BroadcasterFactory.getDefault();
        Broadcaster broadcaster = broadcasterFactory.lookup("/notifications/tweets");
        broadcaster.broadcast("{\"message\":\"" + message + "\"}");
    }
}
