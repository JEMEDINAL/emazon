package com.emazon.mscategorias.domain.usecase;

import com.emazon.mscategorias.domain.model.Brand;
import com.emazon.mscategorias.domain.spi_output.IBrandPersistancePort;


import com.emazon.mscategorias.infrastructure.exception.NameNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.ValidDescription;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BrandUseCaseTest {

    @InjectMocks
    private BrandUseCase brandUseCase;

    @Mock
    private IBrandPersistancePort brandPersistancePort;


    @Test
    void saveBrand() {
        Brand brand = new Brand(1L,"Puma","Neymar es su figurar");

        doNothing().when(brandPersistancePort).saveBrand(brand);
        brandUseCase.saveBrand(brand);
        verify(brandPersistancePort).saveBrand(brand);
    }

    @Test
    void saveBrand_invalidNameBrand_ThrowException(){
        Brand brand = new Brand(1L,null,"la mejor");
        assertThrows(NameNotBlankException.class, () -> { brandUseCase.saveBrand(brand);});
    }
    @Test
    void saveBrand_invalidDescriptionBrand_ThrowException(){
        Brand brand = new Brand(1L,"New Balance",null);
        assertThrows(ValidDescription.class, () -> { brandUseCase.saveBrand(brand);});
    }
}