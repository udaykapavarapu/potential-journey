package au.com.cap.ref.transactions.genreport.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product Information
 */
@ApiModel(description = "Product Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-22T22:26:15.976+11:00")

public class ProductInformation   {
  @JsonProperty("exchangeCode")
  private String exchangeCode = null;

  @JsonProperty("productGroupCode")
  private String productGroupCode = null;

  @JsonProperty("symbol")
  private String symbol = null;

  @JsonProperty("expirationDate")
  private String expirationDate = null;

  public ProductInformation exchangeCode(String exchangeCode) {
    this.exchangeCode = exchangeCode;
    return this;
  }

  /**
   * Exchange Code
   * @return exchangeCode
  **/
  @ApiModelProperty(value = "Exchange Code")


  public String getExchangeCode() {
    return exchangeCode;
  }

  public void setExchangeCode(String exchangeCode) {
    this.exchangeCode = exchangeCode;
  }

  public ProductInformation productGroupCode(String productGroupCode) {
    this.productGroupCode = productGroupCode;
    return this;
  }

  /**
   * Product Group Code
   * @return productGroupCode
  **/
  @ApiModelProperty(value = "Product Group Code")


  public String getProductGroupCode() {
    return productGroupCode;
  }

  public void setProductGroupCode(String productGroupCode) {
    this.productGroupCode = productGroupCode;
  }

  public ProductInformation symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  /**
   * Symbol
   * @return symbol
  **/
  @ApiModelProperty(value = "Symbol")


  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public ProductInformation expirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Expiration Date
   * @return expirationDate
  **/
  @ApiModelProperty(value = "Expiration Date")


  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInformation productInformation = (ProductInformation) o;
    return Objects.equals(this.exchangeCode, productInformation.exchangeCode) &&
        Objects.equals(this.productGroupCode, productInformation.productGroupCode) &&
        Objects.equals(this.symbol, productInformation.symbol) &&
        Objects.equals(this.expirationDate, productInformation.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exchangeCode, productGroupCode, symbol, expirationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInformation {\n");
    
    sb.append("    exchangeCode: ").append(toIndentedString(exchangeCode)).append("\n");
    sb.append("    productGroupCode: ").append(toIndentedString(productGroupCode)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

