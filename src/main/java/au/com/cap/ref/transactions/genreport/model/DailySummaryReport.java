package au.com.cap.ref.transactions.genreport.model;

import java.util.Objects;
import au.com.cap.ref.transactions.genreport.model.DailySummaryReportDetails;
import au.com.cap.ref.transactions.genreport.model.NetTotal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This structure holds the daily summary report retrieved from the input feed (.txt)
 */
@ApiModel(description = "This structure holds the daily summary report retrieved from the input feed (.txt)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-22T22:26:15.976+11:00")

public class DailySummaryReport   {
  @JsonProperty("dailySummaryReportDetails")
  @Valid
  private List<DailySummaryReportDetails> dailySummaryReportDetails = new ArrayList<DailySummaryReportDetails>();

  @JsonProperty("netTotalAmounts")
  @Valid
  private List<NetTotal> netTotalAmounts = null;

  public DailySummaryReport dailySummaryReportDetails(List<DailySummaryReportDetails> dailySummaryReportDetails) {
    this.dailySummaryReportDetails = dailySummaryReportDetails;
    return this;
  }

  public DailySummaryReport addDailySummaryReportDetailsItem(DailySummaryReportDetails dailySummaryReportDetailsItem) {
    this.dailySummaryReportDetails.add(dailySummaryReportDetailsItem);
    return this;
  }

  /**
   * Daily Summary Report Details
   * @return dailySummaryReportDetails
  **/
  @ApiModelProperty(required = true, value = "Daily Summary Report Details")
  @NotNull

  @Valid

  public List<DailySummaryReportDetails> getDailySummaryReportDetails() {
    return dailySummaryReportDetails;
  }

  public void setDailySummaryReportDetails(List<DailySummaryReportDetails> dailySummaryReportDetails) {
    this.dailySummaryReportDetails = dailySummaryReportDetails;
  }

  public DailySummaryReport netTotalAmounts(List<NetTotal> netTotalAmounts) {
    this.netTotalAmounts = netTotalAmounts;
    return this;
  }

  public DailySummaryReport addNetTotalAmountsItem(NetTotal netTotalAmountsItem) {
    if (this.netTotalAmounts == null) {
      this.netTotalAmounts = new ArrayList<NetTotal>();
    }
    this.netTotalAmounts.add(netTotalAmountsItem);
    return this;
  }

  /**
   * Get netTotalAmounts
   * @return netTotalAmounts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<NetTotal> getNetTotalAmounts() {
    return netTotalAmounts;
  }

  public void setNetTotalAmounts(List<NetTotal> netTotalAmounts) {
    this.netTotalAmounts = netTotalAmounts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DailySummaryReport dailySummaryReport = (DailySummaryReport) o;
    return Objects.equals(this.dailySummaryReportDetails, dailySummaryReport.dailySummaryReportDetails) &&
        Objects.equals(this.netTotalAmounts, dailySummaryReport.netTotalAmounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dailySummaryReportDetails, netTotalAmounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailySummaryReport {\n");
    
    sb.append("    dailySummaryReportDetails: ").append(toIndentedString(dailySummaryReportDetails)).append("\n");
    sb.append("    netTotalAmounts: ").append(toIndentedString(netTotalAmounts)).append("\n");
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

