package za.co.sasams.util;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Utility methods
 */
public class Util {

    public static final String MULTIPLE = "Multiple";
    public static final String UNSUCCESSFUL = "-R20";
    public static final String NO_RESPONSE = "No Response";
    public static final String UNSPECIFIED_VALUE = "-2";
    public static final String UNSPECIFIED_LABEL = "Unspecified";
    public static final String NA_VALUE = "-3";
    public static final String NA_LABEL = "N/A";
    public static final String ALL_VALUE = "-1";
    public static final int ALL_VALUE_INT = -1;
    public static final String ALL_LABEL = "All";
    public static final String NONE_VALUE = "0";
    public static final String NONE_LABEL = "(none)";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    static {
        DATE_FORMAT.setLenient(false);
    }

    private static final SimpleDateFormat TRAN_REFERNECE_DATE_FORMAT = new SimpleDateFormat("ddMMyy");
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private static final SimpleDateFormat DATE_DAY_FORMAT = new SimpleDateFormat("dd/MM/yyy EEEE");
    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("EEEE");
    private static final SimpleDateFormat DATE_TIME_SECONDS_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final SimpleDateFormat CLIENT_MESSAGING_DATE_TIME_SECONDS_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat ABSA_FILE_DATE_TIME_SECONDS_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private static final SimpleDateFormat WS_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
    private static final SimpleDateFormat MONTH_YEAR_FORMAT = new SimpleDateFormat("MM/yyyy");
    private static final SimpleDateFormat YEAR_MONTH_DAY_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    private static final SimpleDateFormat DATABASE_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Logger log = Logger.getLogger(Util.class);
    public static final String BLANK_STRING = "";
    public static final long NUMBER_OF_MILLISECONDS_IN_SECOND = 1000;
    private static final String CARD_NUMBER_PREFIX = "636194";

    //Brenton, I am using these values in InvoiceProcessing Screen and I didn't find any way of using the
    // Java standard Calender Class for achieving this goal. Where I need to get all the months as a MAP or List.
    public static final Integer MONTH_JANUARY = 1;
    public static final Integer MONTH_FEBRUARY = 2;
    public static final Integer MONTH_MARCH = 3;
    public static final Integer MONTH_APRIL = 4;
    public static final Integer MONTH_MAY = 5;
    public static final Integer MONTH_JUNE = 6;
    public static final Integer MONTH_JULY = 7;
    public static final Integer MONTH_AUGUST = 8;
    public static final Integer MONTH_SEPTEMBER = 9;
    public static final Integer MONTH_OCTOBER = 10;
    public static final Integer MONTH_NOVEMBER = 11;
    public static final Integer MONTH_DECEMBER = 12;

//    public static final ConstantNameMap MAP_MONTH = new ConstantNameMap(Util.class, "MONTH_");

    public static String yesNo(boolean value) {
        return value ? "Yes" : "No";
    }

    public static String nstoNA(String string) {
        return string == null ? NA_LABEL : string;
    }

    public static String nstoblank(String string) {
        return string == null ? "" : string;
    }

    public static String nstoNone(String string) {
        return string == null ? NONE_LABEL : string;
    }

    /**
     * Return new date with days added (or subtracted if negative).
     */
    public static Date addDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        Calendar c = createCalendar();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
    }

    /**
     * Return new date with months added (or subtracted if negative).
     */
    public static Date addMonths(Date date, int months) {
        if (date == null) {
            return null;
        }
        Calendar c = createCalendar();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        return c.getTime();
    }

    /**
     * Create a calendar with the first day of the week monday.
     */
    public static GregorianCalendar createCalendar() {
        GregorianCalendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return c;
    }

    /**
     * Return new date with time set to 00:00:00.000
     */
    public static Date startOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * Return new date with time set to 15:00:00.000
     */
    public static Date getCutoffDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 15);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * Return new date with time set to 23:59:59.999
     */
    public static Date endOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date middleOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 12);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date startOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static boolean isSameDay(Date date1, Date date2) {
        return date1 != null && date2 != null && DateUtils.isSameDay(date1, date2);
    }
    
    public static Date addMinutes(Date date,int minutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Date endOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 31);
        c.set(Calendar.MONTH, Calendar.DECEMBER);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date startOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date endOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    // todo: Kutlo: The below seems to have no usages so either remove it or make it static (since every method in this class should be static)
    public Date getDate(int day, int month, int year) {
        // todo: Kutlo: Remove the unnecessary blank line below

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        return cal.getTime();
    }

    public static Date parseDate(String date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new CashopsException("Invalid date. Valid format is: dd/MM/yyyy");
        }
    }

    public static String formatTodayYearMonthDay() {
        return YEAR_MONTH_DAY_FORMAT.format(new Date());
    }

    public static String formatMessagingService(Date date) {
        if (date != null) {
            return CLIENT_MESSAGING_DATE_TIME_SECONDS_FORMAT.format(date);
        }
        return "";
    }

    public static String format(Date date) {
        if (date != null) {
            return DATE_FORMAT.format(date);
        }
        return null;
    }

    public static String formatsDay(Date date) {
        if (date != null) {
            return DAY_FORMAT.format(date);
        }
        return null;
    }

    public static String dbDateformat(Date date) {
        if (date != null) {
            return DATABASE_DATE_TIME_FORMAT.format(date);
        }
        return null;
    }

    public static Date dbParseDate(String date) {
        try {
            return DATABASE_DATE_TIME_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new CashopsException("Invalid date. Valid format is: yyyy-MM-dd HH:mm:ss");
        }
    }


    public static String tranReferenceFormat(Date date) {
        if (date != null) {
            return TRAN_REFERNECE_DATE_FORMAT.format(date);
        }
        return null;
    }

    public static Date wsParseDate(String date) {
        try {
            return WS_DATE_TIME_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new CashopsException("Invalid date. Valid format is: dd/MM/yyyy");
        }
    }

    public static String wsFormat(Date date) {
        if (date != null) {
            return WS_DATE_TIME_FORMAT.format(date);
        }
        return null;
    }


    public static String absaFormat(Date date) {
        if (date != null) {
            return ABSA_FILE_DATE_TIME_SECONDS_FORMAT.format(date);
        }
        return BLANK_STRING;
    }


    public static String formatDateTime(Date date) {
        if (date != null) {
            return DATE_TIME_FORMAT.format(date);
        }
        return null;
    }

    public static String formatDateTimeSeconds(Date date) {
        if (date != null) {
            return DATE_TIME_SECONDS_FORMAT.format(date);
        }
        return NONE_LABEL;
    }

    public static String formatTwoDigits(int num) {
        NumberFormat twoDigits = NumberFormat.getInstance();
        twoDigits.setMinimumIntegerDigits(2);
        return twoDigits.format(num);
    }

    /**
     * compress the given data
     */
    public static byte[] compress(byte[] uncompressedData) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(uncompressedData);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(16384);
        GZIPOutputStream gs = new GZIPOutputStream(bos);
        byte[] buf = new byte[2048];
        for (; ; ) {
            int sz = in.read(buf, 0, buf.length);
            if (sz < 0) {
                break;
            }
            gs.write(buf, 0, sz);
        }
        gs.flush();
        gs.close();
        return bos.toByteArray();
    }

    /**
     * Uncompress the given data
     */
    public static byte[] uncompress(byte[] data) throws IOException {
        int BUF_SIZE = 2048;
        byte[] buf = new byte[BUF_SIZE];
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        GZIPInputStream gs = new GZIPInputStream(bis);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(16384);
        for (; ; ) {
            int sz = gs.read(buf, 0, buf.length);
            if (sz < 0) {
                break;
            }
            bos.write(buf, 0, sz);
        }
        return bos.toByteArray();

    }
//
//    public static byte[] uncompress(XMLFile xmlFile) {
//        byte[] content = xmlFile.getData();
//        if (xmlFile.isCompressed()) {
//            try {
//                content = Util.uncompress(xmlFile.getData());
//            } catch (IOException e) {
//                log.error(e);
//                throw new CashopsException("Unable to uncompress the file");
//            }
//        }
//        return content;
//    }

    public static String nstoUnspecified(String str) {
        if (str == null) {
            return UNSPECIFIED_LABEL;
        }
        return str;
    }

    public static boolean isValidPhoneNumber(String number) {
        if (number != null && number.length() > 0) {
            int n = number.length();
            if (n < 11) {
                return false;
            } else if (!number.startsWith("27") && !number.startsWith("44")
                    && !number.startsWith("973") && !number.startsWith("61")) {
                return false;

            } else {
                for (int i = 0; i < n; i++) {
                    if (!Character.isDigit(number.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int comp(Comparable a, Comparable b) {
        if (a == null) {
            return b == null ? 0 : -1;
        }
        if (b == null) {
            return +1;
        }
        return a.compareTo(b);
    }

    public static boolean equal(Object a, Object b) {
        if (a instanceof Date) {
            a = fix((Date) a);
        }
        if (b instanceof Date) {
            b = fix((Date) b);
        }

        if (a != null) {
            return a.equals(b);
        } else if (b != null) {
            return b.equals(a);
        }
        return true;
    }

   /* public static String nctoNone(Company company) {
        return company != null ? company.getName() : NONE_LABEL;
    }

    public static String ncbtoNone(CompanyBranch companyBranch) {
        return companyBranch != null ? companyBranch.getName() : NONE_LABEL;
    }

    public static String nsimtoNone(SIMCard simCard) {
        return simCard != null ? simCard.getMSISDNNumber() : NONE_LABEL;
    }

    public static String ncontracttoNone(ClientContract clientContract) {
        return clientContract != null ? clientContract.getNumber() : NONE_LABEL;
    }*/

    public static Date fix(Date date) {
        if (date instanceof Timestamp) {
            date = new Date(date.getTime());
        }
        return date;
    }

    public static String formatsDateDay(Date date) {
        if (date != null) {
            return DATE_DAY_FORMAT.format(date);
        }
        return null;
    }

    public static String formatMonthYear(Date date) {
        if (date != null) {
            return MONTH_YEAR_FORMAT.format(date);
        }
        return null;
    }

    public static String nstouspecified(String string) {
        return (string == null) ? UNSPECIFIED_LABEL : string;
    }

    public static String getCardNumber(Long cardNumber) {
        String result = cardNumber.toString();
        if (!result.startsWith(CARD_NUMBER_PREFIX)) {
            result = CARD_NUMBER_PREFIX + cardNumber;
        }
        return result;
    }
/*
    public static String ncgtonone(ClientGroup clientGroup) {
        return clientGroup != null ? nstoNone(clientGroup.getName()) : NONE_LABEL;
    }

    public static String nrtonone(Region region) {
        return region != null ? nstoNone(region.getName()) : NONE_LABEL;
    }

    public static String ncashCentretonone(CashCentre cashCentre) {
        return cashCentre != null ? nstoNone(cashCentre.getName()) : NONE_LABEL;
    }*/

   /* public static String mapToString(MapMessage mapMessage) {
        StringBuilder result = new StringBuilder();
        if (mapMessage != null) {
            try {
                for (Enumeration<String> names = mapMessage.getMapNames(); names.hasMoreElements(); ) {
                    String name = names.nextElement();
                    result.append(name);
                    result.append("=");
                    try {
                        result.append(mapMessage.getString(name));
                    } catch (MessageFormatException me) {
                        byte[] bytes = mapMessage.getBytes(name);

                        if (name.equals(TransactionTransformer.TRANSACTION_REPLY_PK)) {
                            TransactionPK pk = TransactionTransformer.createTransactionPK(bytes);
                            result.append(pk);
                        } else {
                            result.append(bytes.toString());
                        }
                    }
                    result.append(";");
                }
            } catch (JMSException e) {
                log.error(e, e);
            }
        }
        return result.toString();
    }

    public static Long calcCardNumber(Long cardNumber) {
        long result;
        if (cardNumber != null && cardNumber < CardDataTransformer.CARD_PREFIX) {
            result = CardDataTransformer.CARD_PREFIX + cardNumber;
            if (result > CardDataTransformer.MAX_CARD_PREFIX) {
                return cardNumber;
            }
            return result;
        }
        return cardNumber;
    }*/

    public static byte[] IntToByteArray(int data) {
        return new byte[]{
                (byte) ((data >> 24) & 0xff),
                (byte) ((data >> 16) & 0xff),
                (byte) ((data >> 8) & 0xff),
                (byte) ((data >> 0) & 0xff),
        };
    }

    public static byte[] LongToByteArray(long data) {
        return new byte[]{
                (byte) ((data >> 56) & 0xff),
                (byte) ((data >> 48) & 0xff),
                (byte) ((data >> 40) & 0xff),
                (byte) ((data >> 32) & 0xff),
                (byte) ((data >> 24) & 0xff),
                (byte) ((data >> 16) & 0xff),
                (byte) ((data >> 8) & 0xff),
                (byte) ((data >> 0) & 0xff),
        };
    }

    public static boolean notEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String getCurrentMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        Calendar cal = Calendar.getInstance();
        return months[cal.get(Calendar.MONTH)];
    }

    public static Double round(Double value) {
        /*DecimalFormat decimalFormat = new DecimalFormat("0.00");
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);*/
        return Math.round(value * 100.0) / 100.0;
    }

    public static List<Integer> getDaysOfMonth() {
        List<Integer> days = new ArrayList<Integer>();
        for (int i = 1; i <= 31; i++) {
            days.add(i);
        }
        return days;
    }

    public static boolean isDouble(String num) {
        try {
            Double.parseDouble(num.trim());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String num) {
        try {
            Integer.parseInt(num.trim());
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
