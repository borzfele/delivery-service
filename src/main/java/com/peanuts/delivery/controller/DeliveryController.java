package com.peanuts.delivery.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.peanuts.delivery.dao.PostapontDao;
import com.peanuts.delivery.model.Address;
import com.peanuts.delivery.model.DeliveryResponse;
import com.peanuts.delivery.model.Offer;
import com.peanuts.delivery.model.Postapont;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeliveryController {

    private PostapontDao postapontDao;

    public DeliveryController(PostapontDao postapontDao) {
        this.postapontDao = postapontDao;
    }

    @PostMapping("/query")
    @ResponseBody
    public String queryDeliveryOptions(@RequestBody String json) {
        // RECEIVE JSON AND CONVERT IT TO ADDRESS
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        Gson gson = new Gson();
        JsonElement originJson = jsonObject.get("origin");
        JsonElement destinationJson = jsonObject.get("destination");
        Address originAddress = gson.fromJson(originJson, Address.class);
        Address destinationAddress = gson.fromJson(destinationJson, Address.class);
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO:" + destinationAddress.getCity());
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");*/

        // JSON RESPONSE
        List<Postapont> postaponts = new ArrayList<>();
        List<Offer> deliveryServices = new ArrayList<>();
        DeliveryResponse responseObject = new DeliveryResponse(originAddress, destinationAddress, postaponts, deliveryServices);

        Gson gsonResponse = new Gson();
        String jsonResponse = gsonResponse.toJson(responseObject);

        return jsonResponse;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String saveOrder(Model model, HttpSession session) {
        String jsonResponse = null;
        return jsonResponse;
    }

}