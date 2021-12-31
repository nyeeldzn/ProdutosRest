package com.sunonrails.productscrud;

import com.sunonrails.productscrud.models.Product;
import com.sunonrails.productscrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProductsCrudApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;


    public static void main(String[] args) {
        SpringApplication.run(ProductsCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando Servidor");
        System.out.println("Inserindo Objetos de Teste");

        Product product1 = new Product(null,7899123678L,"Multiuso Veja Tradicional 500ml",1.60,70L);
        Product product2 = new Product(null,7892781928L,"Chocolate Talento",2.60,20L);
        Product product3 = new Product(null,1289032863L,"Sabao em Po Tixan Ype 1kg",7.45,15L);
        Product product4 = new Product(null,789023L,"Salgadinho Doritos 55gr",13.00,15L);
        Product product5 = new Product(null,7891827401L,"Fone de Ouvidos Headphone Generico",45.78,4L);

        productService.insertList(Arrays.asList(product1,product2,product3,product4,product5));
    }
}
