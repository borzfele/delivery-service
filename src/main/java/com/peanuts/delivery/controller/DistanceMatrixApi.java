package com.peanuts.delivery.controller;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class DistanceMatrixApi {
    static final ApiConfig API_CONFIG = new ApiConfig("/maps/api/distancematrix/json");

    static final String apiKey = "AIzaSyDNltTITtt0gqkzFUWpdVXDGuNHirsGSAU";

    private DistanceMatrixApi() throws InterruptedException, ApiException, IOException {}

    public  GeoApiContext getContext() {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDNltTITtt0gqkzFUWpdVXDGuNHirsGSAU")
                .build();
        return context;
    }

    public static DistanceMatrixApiRequest newRequest(GeoApiContext context) {
        return new DistanceMatrixApiRequest(context);
    }

    public static DistanceMatrixApiRequest getDistanceMatrix(
            GeoApiContext context, String[] origins, String[] destinations) {
        return newRequest(context).origins(origins).destinations(destinations);
    }


    static class Response implements ApiResponse<DistanceMatrix> {
        public String status;
        public String errorMessage;
        public String[] originAddresses;
        public String[] destinationAddresses;
        public DistanceMatrixRow[] rows;

        @Override
        public boolean successful() {
            return "OK".equals(status);
        }

        @Override
        public ApiException getError() {
            if (successful()) {
                return null;
            }
            return ApiException.from(status, errorMessage);
        }

        @Override
        public DistanceMatrix getResult() {
            return new DistanceMatrix(originAddresses, destinationAddresses, rows);
        }
    }
}
