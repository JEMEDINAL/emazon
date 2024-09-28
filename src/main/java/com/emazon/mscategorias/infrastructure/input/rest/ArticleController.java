package com.emazon.mscategorias.infrastructure.input.rest;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;
import com.emazon.mscategorias.application.dto.ArticleResponseDto;
import com.emazon.mscategorias.application.handler.IArticleHandler;
import com.emazon.mscategorias.domain.model.CustomPageResponse;
import com.emazon.mscategorias.infrastructure.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final IArticleHandler iArticleHandler;

    @PostMapping
    public ResponseEntity<ApiResponse> saveArticle(@RequestBody ArticleRequestDto articleRequestDto){
        iArticleHandler.saveArticle(articleRequestDto);
        ApiResponse apiResponse = new ApiResponse("Tu articulo se ha creado correctamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<CustomPageResponse<ArticleResponseDto>> getParameterizedArticle(
            @RequestParam @NotNull(message = "No puede ir vació la pagina que deseas ver") Integer page,
            @RequestParam @NotNull(message = "No puede ir vació la cantidad de registros que deseas ver") Integer size,
            @RequestParam @NotNull(message = "No puede ir vació l orden en el que deseas ver los registros") String orden
    ){
        CustomPageResponse<ArticleResponseDto> response = iArticleHandler.getParameterizedArticles(page, size, orden);
        return ResponseEntity.ok(response);
    }
}
