package com.emazon.mscategorias.domain.usecase;

import com.emazon.mscategorias.domain.api_input.IBrandServicePort;
import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.spi_output.IBrandPersistancePort;
import com.emazon.mscategorias.infrastructure.exception.NameNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.UnauthorizedUserException;
import com.emazon.mscategorias.infrastructure.exception.ValidDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistancePort iBrandPersistancePort;

    public BrandUseCase(IBrandPersistancePort iBrandPersistancePort){
        this.iBrandPersistancePort = iBrandPersistancePort;
    }

    @Override
    public void saveBrand(Brand brand) {
         String userRol ="ADMIN";
         validAdminUser(userRol);
         if(brand.getName() == null || brand.getName().trim().isEmpty() || brand.getName().length() >= 50){
            throw new NameNotBlankException();
         }


        if(brand.getDescription() == null ||  brand.getDescription().trim().isEmpty() || brand.getDescription().length() > 90){
           throw new ValidDescription();
        }
        iBrandPersistancePort.saveBrand(brand);

    }
    private  void validAdminUser(String rol){
        if(!rol.equals("ADMIN")){
            throw new UnauthorizedUserException();
        }
    }

    @Override
    public List<Brand> getParameterizedBrands(int page, int size, String orden) {
        return List.of();
    }
}
