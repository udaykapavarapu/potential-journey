package au.com.cap.ref.transactions.genreport;

import au.com.cap.ref.transactions.genreport.api.GenerateSummaryReportApiController;
import au.com.cap.ref.transactions.genreport.exception.ClientException;

import au.com.cap.ref.transactions.genreport.model.DailySummaryReport;
import au.com.cap.ref.transactions.genreport.service.GenerateSummaryReportService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class GenerateSummaryReportTest {

    @InjectMocks
    GenerateSummaryReportApiController generateSummaryReportApiController;

    @Spy
    GenerateSummaryReportService generateSummaryReportService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = ClientException.class)
    public void invalidHeaderAppCorrelationId() {
        generateSummaryReportApiController.generateSummaryReport(
                "UKTest",
                "",
                "UK",
                null
        );
    }

    @Test(expected = ClientException.class)
    public void invalidHeaderMessageId() {
        generateSummaryReportApiController.generateSummaryReport(
                "",
                "UKTest",
                "UK",
                null
        );
    }

    @Test(expected = ClientException.class)
    public void invalidHeaderUserId() {
        generateSummaryReportApiController.generateSummaryReport(
                "UKMessageId",
                "UKTest",
                "",
                null
        );
    }

    @Test(expected = ClientException.class)
    public void invalidFile() {
        generateSummaryReportApiController.generateSummaryReport(
                "UKMessageId",
                "UKTest",
                "UserId",
                null
        );
    }

    @Test(expected = ClientException.class)
    public void invalidFileExtension() {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "input.pdf",
                "multipart/form-data", "Mock Input File".getBytes());
        generateSummaryReportApiController.generateSummaryReport(
                "UKMessageId",
                "UKTest",
                "UserId",
                multipartFile
        );
    }

    @Test
    public void generateSummaryReport() throws IOException {
        MultipartFile multipartFile = new MockMultipartFile("MockInput.txt", new FileInputStream(new File("./src/main/test/resources/MockInput.txt")));
        Mockito.when(generateSummaryReportService.validateInputFile(multipartFile)).thenReturn(true);
        ResponseEntity<DailySummaryReport> response = generateSummaryReportApiController.generateSummaryReport(
                "UKMessageId",
                "UKTest",
                "UserId",
                multipartFile
        );
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
