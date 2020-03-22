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
 * Client Information
 */
@ApiModel(description = "Client Information")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-22T22:26:15.976+11:00")

public class ClientInformation   {
  @JsonProperty("clientType")
  private String clientType = null;

  @JsonProperty("clientNumber")
  private String clientNumber = null;

  @JsonProperty("accountNumber")
  private String accountNumber = null;

  @JsonProperty("subAccountNumber")
  private String subAccountNumber = null;

  public ClientInformation clientType(String clientType) {
    this.clientType = clientType;
    return this;
  }

  /**
   * Client Type
   * @return clientType
  **/
  @ApiModelProperty(value = "Client Type")


  public String getClientType() {
    return clientType;
  }

  public void setClientType(String clientType) {
    this.clientType = clientType;
  }

  public ClientInformation clientNumber(String clientNumber) {
    this.clientNumber = clientNumber;
    return this;
  }

  /**
   * Unique Identifier of the Client
   * @return clientNumber
  **/
  @ApiModelProperty(value = "Unique Identifier of the Client")


  public String getClientNumber() {
    return clientNumber;
  }

  public void setClientNumber(String clientNumber) {
    this.clientNumber = clientNumber;
  }

  public ClientInformation accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Account Number
   * @return accountNumber
  **/
  @ApiModelProperty(value = "Account Number")


  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public ClientInformation subAccountNumber(String subAccountNumber) {
    this.subAccountNumber = subAccountNumber;
    return this;
  }

  /**
   * Sub Account Number
   * @return subAccountNumber
  **/
  @ApiModelProperty(value = "Sub Account Number")


  public String getSubAccountNumber() {
    return subAccountNumber;
  }

  public void setSubAccountNumber(String subAccountNumber) {
    this.subAccountNumber = subAccountNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientInformation clientInformation = (ClientInformation) o;
    return Objects.equals(this.clientType, clientInformation.clientType) &&
        Objects.equals(this.clientNumber, clientInformation.clientNumber) &&
        Objects.equals(this.accountNumber, clientInformation.accountNumber) &&
        Objects.equals(this.subAccountNumber, clientInformation.subAccountNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientType, clientNumber, accountNumber, subAccountNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientInformation {\n");
    
    sb.append("    clientType: ").append(toIndentedString(clientType)).append("\n");
    sb.append("    clientNumber: ").append(toIndentedString(clientNumber)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    subAccountNumber: ").append(toIndentedString(subAccountNumber)).append("\n");
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

