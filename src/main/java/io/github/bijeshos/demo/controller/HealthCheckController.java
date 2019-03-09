package io.github.bijeshos.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
public class HealthCheckController {

    @RequestMapping("/spring-boot-with-docker-demo/v0.1/health-check")
    @ResponseBody
    public String healthCheck() {

        System.out.println("Entering HealthCheckController:healthCheck");
        StringBuilder hostDetails = new StringBuilder();
        try {

            InetAddress inetAddress = InetAddress.getLocalHost();
            hostDetails.append(inetAddress);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return "Hello there! Greetings from: " + hostDetails.toString() + "\n";

    }


}
