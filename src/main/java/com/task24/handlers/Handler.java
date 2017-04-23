package com.task24.handlers;

import com.task24.Payment;

/**
 * Created by Vlad on 08.03.2017.
 */
public abstract class Handler {
    Handler handler=null;

    /**
     * Empty constructor
     */
    public Handler() { }

    /**
     * Default constructor
     * @param handler next handler
     */
    public Handler(Handler handler) {
        this.handler = handler;
    }

    /*getter*/
    public Handler getHandler() {
        return handler;
    }

    /*setter*/
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * Execute handler if possible
     */
    public abstract void execute(Payment payment);
}
