package com.politecnico.servicemovies.client;

import com.politecnico.servicemovies.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-bookings")
public interface BookingClient {
    @GetMapping("/booking/{id}")
    Response findAllByIdMovie(@PathVariable("id") Long id);
}
