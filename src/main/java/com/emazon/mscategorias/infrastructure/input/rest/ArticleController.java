package com.emazon.mscategorias.infrastructure.input.rest;

import com.emazon.mscategorias.application.dto.ArticleRequestDto;
import com.emazon.mscategorias.application.handler.IArticleHandler;
import com.emazon.mscategorias.infrastructure.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
