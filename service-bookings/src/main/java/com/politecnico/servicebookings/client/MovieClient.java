package com.politecnico.servicebookings.client;

import com.politecnico.servicebookings.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-movies")
public interface MovieClient {
    @GetMapping("/movie/{id}")
    Response findById(@PathVariable("id") Long id);

}
