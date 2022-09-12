package com.api.Sewing_System.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class HistoricDto {

 //   @NotBlank
//    private LocalDateTime dataCompra;
  //  @NotBlank
    private String quantidade;



 //   public LocalDateTime getDataCompra() {
 //       return dataCompra;
 //   }

  //  public void setDataCompra(LocalDateTime dataCompra) {
 //      this.dataCompra = dataCompra;
//    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
}
