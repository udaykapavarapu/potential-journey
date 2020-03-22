package au.com.cap.ref.transactions.genreport.model;

import java.util.Objects;
import au.com.cap.ref.transactions.genreport.model.ClientInformation;
import au.com.cap.ref.transactions.genreport.model.ProductInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Daily Summary Report Details
 */
@ApiModel(description = "Daily Summary Report Details")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-22T22:26:15.976+11:00")

public class DailySummaryReportDetails   {
  @JsonProperty("clientInformation")
  private ClientInformation clientInformation = null;

  @JsonProperty("productInformation")
  private ProductInformation productInformation = null;

  @JsonProperty("quantityLong")
  private String quantityLong = null;

  @JsonProperty("quantityShort")
  private String quantityShort = null;

  public DailySummaryReportDetails clientInformation(ClientInformation clientInformation) {
    this.clientInformation = clientInformation;
    return this;
  }

  /**
   * Get clientInformation
   * @return clientInformation
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ClientInformation getClientInformation() {
    return clientInformation;
  }

  public void setClientInformation(ClientInformation clientInformation) {
    this.clientInformation = clientInformation;
  }

  public DailySummaryReportDetails productInformation(ProductInformation productInformation) {
    this.productInformation = productInformation;
    return this;
  }

  /**
   * Get productInformation
   * @return productInformation
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ProductInformation getProductInformation() {
    return productInformation;
  }

  public void setProductInformation(ProductInformation productInformation) {
    this.productInformation = productInformation;
  }

  public DailySummaryReportDetails quantityLong(String quantityLong) {
    this.quantityLong = quantityLong;
    return this;
  }

  /**
   * Quantity Long
   * @return quantityLong
  **/
  @ApiModelProperty(value = "Quantity Long")


  public String getQuantityLong() {
    return quantityLong;
  }

  public void setQuantityLong(String quantityLong) {
    this.quantityLong = quantityLong;
  }

  public DailySummaryReportDetails quantityShort(String quantityShort) {
    this.quantityShort = quantityShort;
    return this;
  }

  /**
   * Quantity Short
   * @return quantityShort
  **/
  @ApiModelProperty(value = "Quantity Short")


  public String getQuantityShort() {
    return quantityShort;
  }

  public void setQuantityShort(String quantityShort) {
    this.quantityShort = quantityShort;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DailySummaryReportDetails dailySummaryReportDetails = (DailySummaryReportDetails) o;
    return Objects.equals(this.clientInformation, dailySummaryReportDetails.clientInformation) &&
        Objects.equals(this.productInformation, dailySummaryReportDetails.productInformation) &&
        Objects.equals(this.quantityLong, dailySummaryReportDetails.quantityLong) &&
        Objects.equals(this.quantityShort, dailySummaryReportDetails.quantityShort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientInformation, productInformation, quantityLong, quantityShort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailySummaryReportDetails {\n");
    
    sb.append("    clientInformation: ").append(toIndentedString(clientInformation)).append("\n");
    sb.append("    productInformation: ").append(toIndentedString(productInformation)).append("\n");
    sb.append("    quantityLong: ").append(toIndentedString(quantityLong)).append("\n");
    sb.append("    quantityShort: ").append(toIndentedString(quantityShort)).append("\n");
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

