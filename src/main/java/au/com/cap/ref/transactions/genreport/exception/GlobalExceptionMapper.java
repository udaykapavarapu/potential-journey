package au.com.cap.ref.transactions.genreport.exception;

import au.com.cap.ref.transactions.genreport.model.Error;
import au.com.cap.ref.transactions.genreport.model.ErrorResponse;
import au.com.cap.ref.transactions.genreport.utils.ApiServiceConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionMapper {

    @ExceptionHandler(value = ClientException.class)
    public ResponseEntity<ErrorResponse> exception(ClientException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.addErrorsItem(createError(exception.getCode(), exception.getMessage(), exception.getDetails()));
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = IOException.class)
    public ResponseEntity<ErrorResponse> exception(IOException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.addErrorsItem(createError(ApiServiceConstants.ErrorEnum.UNEXPECTED_ERROR.errorCode, ApiServiceConstants.ErrorEnum.UNEXPECTED_ERROR.errorMessage, exception.getMessage()));
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.addErrorsItem(createError(ApiServiceConstants.ErrorEnum.UNEXPECTED_ERROR.errorCode, ApiServiceConstants.ErrorEnum.UNEXPECTED_ERROR.errorMessage, exception.getMessage()));
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
     * Private Method to create Error Object
     */
    private Error createError(int code, String message, String details) {
        Error error = new Error();
        error.code(code);
        error.message(message);
        error.details(details);
        return error;
    }
}
