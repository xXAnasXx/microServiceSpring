package org.mrb.billingservice.feign;

import org.mrb.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(path = "/products")
    PagedModel<Product> pageProduct();//retourne une page de produits
    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);//on donne id de la facture
    // me donne  la liste des products iitems dans cette facture
}
