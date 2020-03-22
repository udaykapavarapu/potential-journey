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
 * Net Total per client
 */
@ApiModel(description = "Net Total per client")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-22T22:26:15.976+11:00")

public class NetTotal   {
  @JsonProperty("clientNumber")
  private String clientNumber = null;

  @JsonProperty("totalTransactionAmount")
  private String totalTransactionAmount = null;

  public NetTotal clientNumber(String clientNumber) {
    this.clientNumber = clientNumber;
    return this;
  }

  /**
   * Unique identifier of the client
   * @return clientNumber
  **/
  @ApiModelProperty(value = "Unique identifier of the client")


  public String getClientNumber() {
    return clientNumber;
  }

  public void setClientNumber(String clientNumber) {
    this.clientNumber = clientNumber;
  }

  public NetTotal totalTransactionAmount(String totalTransactionAmount) {
    this.totalTransactionAmount = totalTransactionAmount;
    return this;
  }

  /**
   * Total Quantity Long - Total Quantity Short per client
   * @return totalTransactionAmount
  **/
  @ApiModelProperty(value = "Total Quantity Long - Total Quantity Short per client")


  public String getTotalTransactionAmount() {
    return totalTransactionAmount;
  }

  public void setTotalTransactionAmount(String totalTransactionAmount) {
    this.totalTransactionAmount = totalTransactionAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetTotal netTotal = (NetTotal) o;
    return Objects.equals(this.clientNumber, netTotal.clientNumber) &&
        Objects.equals(this.totalTransactionAmount, netTotal.totalTransactionAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientNumber, totalTransactionAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetTotal {\n");
    
    sb.append("    clientNumber: ").append(toIndentedString(clientNumber)).append("\n");
    sb.append("    totalTransactionAmount: ").append(toIndentedString(totalTransactionAmount)).append("\n");
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

