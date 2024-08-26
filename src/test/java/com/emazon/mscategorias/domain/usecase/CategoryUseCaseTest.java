package com.emazon.mscategorias.domain.usecase;


import com.emazon.mscategorias.domain.model.Category;
import com.emazon.mscategorias.domain.spi_output.ICategoryPersistancePort;
import com.emazon.mscategorias.infrastructure.exception.NameCategoryNotBlankException;
import com.emazon.mscategorias.infrastructure.exception.ValidCategoryDescription;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Mock
    private ICategoryPersistancePort categoryPersistancePort;



    @Test
    void saveCategory_ValidAdminUser_Success() {
        Category category = new Category(1L,"Guayos","los mejores");
        category.setName("guayos");
        category.setDescription("los mejores guayos");

        categoryUseCase.saveCategory(category);
        verify(categoryPersistancePort,times(1)).saveCategory(category);
    }

    @Test
    void saveCategory_InvalidCategoryName_ThrowsException() {

        Category category = new Category(1L,"","los mejores");



        assertThrows(NameCategoryNotBlankException.class, () -> categoryUseCase.saveCategory(category));
    }

    @Test
    void saveCategory_InvalidCategoryDescription_ThrowsException() {

        Category category = new Category(1L,"Guayos","");

        assertThrows(ValidCategoryDescription.class, () -> categoryUseCase.saveCategory(category));
    }
    @BeforeEach
    void setUp() {
        categoryUseCase = new CategoryUseCase(categoryPersistancePort);
    }
}