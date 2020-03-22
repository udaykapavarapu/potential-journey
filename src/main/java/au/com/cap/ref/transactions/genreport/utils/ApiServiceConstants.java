package au.com.cap.ref.transactions.genreport.utils;

public class ApiServiceConstants {

    public static final String FILE_REGEX = "(.*?)\\.txt";

    public enum ErrorEnum {
        INVALID_INPUT_PARAM(100, "Invalid Input Parameter", "Invalid File Extension"),
        UNEXPECTED_ERROR(10000, "Unexpected Error", "Error Details");

        public int errorCode;
        public String errorMessage;
        public String errorDescription;

        ErrorEnum(int errorCode, String errorMessage, String errorDesciption) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
            this.errorDescription = errorDesciption;
        }
    }

    public class FileReaderConstants {
        private FileReaderConstants() {}

        public static final int CLIENT_TYPE_START_INDEX = 3;
        public static final int CLIENT_TYPE_END_INDEX = 7;

        public static final int CLIENT_NUMBER_START_INDEX = 7;
        public static final int CLIENT_NUMBER_END_INDEX = 11;

        public static final int ACCOUNT_NUMBER_START_INDEX = 11;
        public static final int ACCOUNT_NUMBER_END_INDEX = 15;

        public static final int SUBACCOUNT_NUMBER_START_INDEX = 15;
        public static final int SUBACCOUNT_NUMBER_END_INDEX = 19;

        public static final int EXCHANGE_CODE_START_INDEX = 27;
        public static final int EXCHANGE_CODE_END_INDEX = 31;

        public static final int PRODUCT_GROUP_CODE_START_INDEX = 25;
        public static final int PRODUCT_GROUP_CODE_END_INDEX = 27;

        public static final int SYMBOL_START_INDEX = 31;
        public static final int SYMBOL_END_INDEX = 37;

        public static final int EXPIRATION_DATE_START_INDEX = 37;
        public static final int EXPIRATION_DATE_END_INDEX = 45;

        public static final int QUANTITY_LONG_START_INDEX = 52;
        public static final int QUANTITY_LONG_END_INDEX = 62;

        public static final int QUANTITY_SHORT_START_INDEX = 63;
        public static final int QUANTITY_SHORT_END_INDEX = 73;

    }
}
