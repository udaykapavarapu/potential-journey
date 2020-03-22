package au.com.cap.ref.transactions.genreport.service;

import au.com.cap.ref.transactions.genreport.model.*;
import au.com.cap.ref.transactions.genreport.utils.ApiServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenerateSummaryReportService {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateSummaryReportService.class);

    /*
     * Method to generate report
     */
    public static DailySummaryReport generateReport(MultipartFile multipartFile) throws IOException {
        LOG.info("*** Start: Generating Report ***");
        String line;
        List<DailySummaryReportDetails> dailySummaryReportDetailsList = new ArrayList<>();
        List<NetTotal> netTotalList = new ArrayList<>();
        DailySummaryReport dailySummaryReport = new DailySummaryReport();
        DailySummaryReportDetails dailySummaryReportDetails = new DailySummaryReportDetails();
        InputStream inputStream = multipartFile.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while( (line = bufferedReader.readLine()) != null) {
            dailySummaryReportDetailsList.add(generateCSV(line));
        }

        dailySummaryReport.dailySummaryReportDetails(dailySummaryReportDetailsList);

        List<String> clientNumbers = dailySummaryReportDetailsList.stream().map(val -> val.getClientInformation()
                .getClientNumber()).distinct().collect(Collectors.toList());

        for(String clientNumber: clientNumbers) {
            netTotalList.add(netTotal(clientNumber, dailySummaryReportDetailsList));
        }

        dailySummaryReport.netTotalAmounts(netTotalList);

        LOG.info("*** End: Generating Report ***");
        return dailySummaryReport;
    }

    /*
     * Private method to set NetTotal
     */
    private static NetTotal netTotal(String clientNumber, final List<DailySummaryReportDetails> dailySummaryReportDetailsList) {
        NetTotal netTotal = new NetTotal();

        netTotal.clientNumber(clientNumber);
        double totalQuantityLong = dailySummaryReportDetailsList.stream().filter(
                item -> item.getClientInformation().getClientNumber().equals(clientNumber))
                .mapToDouble(val -> new Double(val.getQuantityLong())).sum();
        double totalQuantityShort = dailySummaryReportDetailsList.stream().filter(
                item -> item.getClientInformation().getClientNumber().equals(clientNumber))
                .mapToDouble(val -> new Double(val.getQuantityShort())).sum();
        netTotal.totalTransactionAmount(String.valueOf(totalQuantityLong - totalQuantityShort));
        return netTotal;
    }

    /*
     * Method to generate CSV and set all the values read from file to
     * response object
     */
    private static DailySummaryReportDetails generateCSV(String line) {
        DailySummaryReportDetails dailySummaryReportDetails = new DailySummaryReportDetails();
        dailySummaryReportDetails.clientInformation(populateClientInformation(line));
        dailySummaryReportDetails.productInformation(populateProductInformation(line));
        dailySummaryReportDetails.quantityLong(line.substring(
                ApiServiceConstants.FileReaderConstants.QUANTITY_LONG_START_INDEX,
                ApiServiceConstants.FileReaderConstants.QUANTITY_LONG_END_INDEX
        ));
        dailySummaryReportDetails.quantityShort(line.substring(
                ApiServiceConstants.FileReaderConstants.QUANTITY_SHORT_START_INDEX,
                ApiServiceConstants.FileReaderConstants.QUANTITY_SHORT_END_INDEX
        ));
        return dailySummaryReportDetails;
    }

    /*
     * Private Method to set Product Information
     */
    private static ProductInformation populateProductInformation(String line) {
        ProductInformation productInformation = new ProductInformation();
        productInformation.setExchangeCode(
                line.substring(ApiServiceConstants.FileReaderConstants.EXCHANGE_CODE_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.EXCHANGE_CODE_END_INDEX)
        );
        productInformation.setProductGroupCode(
                line.substring(ApiServiceConstants.FileReaderConstants.PRODUCT_GROUP_CODE_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.PRODUCT_GROUP_CODE_END_INDEX)
        );
        productInformation.setExpirationDate(
                line.substring(ApiServiceConstants.FileReaderConstants.EXPIRATION_DATE_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.EXPIRATION_DATE_END_INDEX)
        );
        productInformation.setSymbol(
                line.substring(ApiServiceConstants.FileReaderConstants.SYMBOL_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.SYMBOL_END_INDEX)
        );

        return productInformation;
    }

    /*
     * Private Method to set Client Information
     */
    private static ClientInformation populateClientInformation(String line) {
        ClientInformation clientInformation = new ClientInformation();
        clientInformation.setClientType(
                line.substring(ApiServiceConstants.FileReaderConstants.CLIENT_TYPE_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.CLIENT_TYPE_END_INDEX));
        clientInformation.setClientNumber(
                line.substring(ApiServiceConstants.FileReaderConstants.CLIENT_NUMBER_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.CLIENT_NUMBER_END_INDEX));
        clientInformation.setAccountNumber(
                line.substring(ApiServiceConstants.FileReaderConstants.ACCOUNT_NUMBER_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.ACCOUNT_NUMBER_END_INDEX));
        clientInformation.setSubAccountNumber(
                line.substring(ApiServiceConstants.FileReaderConstants.SUBACCOUNT_NUMBER_START_INDEX,
                        ApiServiceConstants.FileReaderConstants.SUBACCOUNT_NUMBER_END_INDEX));
        return clientInformation;
    }

    /*
     * Method to validate the input file uploaded
     */
    public boolean validateInputFile(MultipartFile generateSummaryReportRequest) {
        boolean isValidFile = false;
        LOG.info("*** Start: Validating the input file ***", generateSummaryReportRequest);
        //Validate the size of the file
        if(generateSummaryReportRequest.getSize() != 0) {
            isValidFile = true;
        }
        //Validate the name of the file
        if(generateSummaryReportRequest.getOriginalFilename().matches(ApiServiceConstants.FILE_REGEX)) {
            isValidFile = true;
        } else {
            isValidFile = false;
        }
        LOG.info("*** End: Validating the input file ***");
        return isValidFile;
    }
}
