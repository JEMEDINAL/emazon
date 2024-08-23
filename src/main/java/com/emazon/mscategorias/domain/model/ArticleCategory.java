package com.emazon.mscategorias.domain.model;

public class ArticleCategory {
    private Long idCategoria;
    private Long idArticulo;

    public ArticleCategory(Long idCategoria, Long idArticulo) {
        this.idCategoria = idCategoria;
        this.idArticulo = idArticulo;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }
}
