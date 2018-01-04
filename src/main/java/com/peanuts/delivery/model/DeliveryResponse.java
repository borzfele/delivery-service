package com.peanuts.delivery.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryResponse {

    private Address receivedOrigin;
    private Address receivedDestination;
    private Map shippingPossibilities;

    public DeliveryResponse() {
    }

    public DeliveryResponse(Address receivedOrigin, Address receivedDestination, List<Postapont> postapont, List<Offer> deliveryServices) {
        this.receivedOrigin = receivedOrigin;
        this.receivedDestination = receivedDestination;
        this.shippingPossibilities = new HashMap();
        this.shippingPossibilities.put("postapont", postapont);
        this.shippingPossibilities.put("deliveryServices", deliveryServices);
    }

    public Address getReceivedOrigin() {
        return receivedOrigin;
    }

    public void setReceivedOrigin(Address receivedOrigin) {
        this.receivedOrigin = receivedOrigin;
    }

    public Address getReceivedDestination() {
        return receivedDestination;
    }

    public void setReceivedDestination(Address receivedDestination) {
        this.receivedDestination = receivedDestination;
    }

    public Map getShippingPossibilities() {
        return shippingPossibilities;
    }

    public void setShippingPossibilities(List<Postapont> postapont, List<Offer> deliveryServices) {
        this.shippingPossibilities = new HashMap();
        this.shippingPossibilities.put("postapont", postapont);
        this.shippingPossibilities.put("deliveryServices", deliveryServices);
    }

}

