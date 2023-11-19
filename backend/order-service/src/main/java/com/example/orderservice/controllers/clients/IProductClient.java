package com.example.orderservice.controllers.clients;

import com.example.orderservice.core.ReqProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "product-service",path = "micro/product")
public interface IProductClient {
    @DeleteMapping()
    ResponseEntity<?> delete(@RequestBody ReqProductDTO req);
}
