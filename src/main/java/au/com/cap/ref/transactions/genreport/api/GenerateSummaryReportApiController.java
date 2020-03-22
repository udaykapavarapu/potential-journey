package au.com.cap.ref.transactions.genreport.api;

import au.com.cap.ref.transactions.genreport.exception.ClientException;
import au.com.cap.ref.transactions.genreport.model.DailySummaryReport;
import au.com.cap.ref.transactions.genreport.model.ErrorResponse;
import au.com.cap.ref.transactions.genreport.service.GenerateSummaryReportService;
import au.com.cap.ref.transactions.genreport.utils.ApiServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-22T21:13:15.087+11:00")

@Controller
public class GenerateSummaryReportApiController implements GenerateSummaryReportApi {

    private static final Logger log = LoggerFactory.getLogger(GenerateSummaryReportApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    GenerateSummaryReportService generateSummaryReportService;

    @org.springframework.beans.factory.annotation.Autowired
    public GenerateSummaryReportApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<DailySummaryReport> generateSummaryReport(@ApiParam(value = "Globally unique message identifier - GUID. This uniquely identifies the call" ,required=true) @RequestHeader(value="x-messageId", required=true) String xMessageId,@ApiParam(value = "Consumer generated message identifier. This groups together number of API calls comprising a business transaction" ,required=true) @RequestHeader(value="x-appCorrelationId", required=true) String xAppCorrelationId,@ApiParam(value = "Unique identifier for the user invoking the API (e.g. Staff Id)" ,required=true) @RequestHeader(value="x-userId", required=true) String xUserId,@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile inputFile) {
        DailySummaryReport dailySummaryReport = null;

        if(StringUtils.isEmpty(xAppCorrelationId)) {
            throw new ClientException(
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorCode,
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorMessage,
                    "Header x-appCorrelationId is invalid or missing"
            );
        }

        if(StringUtils.isEmpty(xMessageId)) {
            throw new ClientException(
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorCode,
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorMessage,
                    "Header x-messageId is invalid or missing"
            );
        }

        if(StringUtils.isEmpty(xUserId)) {
            throw new ClientException(
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorCode,
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorMessage,
                    "Header x-userId is invalid or missing"
            );
        }

        if(null != inputFile && generateSummaryReportService.validateInputFile(inputFile)) {
            log.info("{} Generate the report as the input file is valid", new Object[]{xAppCorrelationId});
            try {
                dailySummaryReport = generateSummaryReportService.generateReport(inputFile);
            } catch (IOException e) {
                log.error("Error in reading the file", e);
                throw new RuntimeException(e);
            }
        } else {
            log.error("Not a valid input file");
            throw new ClientException(
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorCode,
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorMessage,
                    ApiServiceConstants.ErrorEnum.INVALID_INPUT_PARAM.errorDescription
            );
        }
        if(dailySummaryReport != null) {
            return new ResponseEntity<DailySummaryReport>(dailySummaryReport, HttpStatus.OK);
        }

        return new ResponseEntity<DailySummaryReport>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
