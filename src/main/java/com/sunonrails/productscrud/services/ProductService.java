package com.sunonrails.productscrud.services;

import com.sunonrails.productscrud.exceptions.ObjectNotFoundException;
import com.sunonrails.productscrud.models.Product;
import com.sunonrails.productscrud.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> findAll(){
        return repo.findAll();
    }

    public Product findById(Long id){
        Optional<Product> product = repo.findById(id);
        return product.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id: " + id
        ));
    }

    public Product insert(Product product){
        product.setId(null);
        return repo.save(product);
    }

    public List<Product> insertList(List<Product> productList){
        List<Product> returnList = new ArrayList<>();
        for(int i = 0; i < productList.size(); i++){
            returnList.add(repo.save(productList.get(i)));
            System.out.println("Produto Inserido com sucesso! \n" + returnList.get(i));
        }
        return returnList;
    }

    public Product update(Product produto){
        Product newObj = findById(produto.getId());
        updateData(newObj, produto);
        return repo.save(newObj);
    }


    private void updateData(Product newObj, Product obj){
        newObj.setDescription(obj.getDescription());
    }



    public void delete(Long id){
        repo.deleteById(id);
        Optional<Product> product = repo.findById(id);
        product.orElseThrow( () -> new ObjectNotFoundException(
                "Objeto de Id: " + id + " deletado com sucesso@"
        ));
    }

}
