// Install the Java helper library from twilio.com/docs/java/install
import org.joda.time.DateTime;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.usage.Record;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    ResourceSet<Record> records = Record.reader()
        .byCategory(Record.Category.CALLS_INBOUND)
        .byStartDate(DateTime.parse("2012-09-01"))
        .setEndDate(DateTime.parse("2012-09-30"))
        .read();

    // Loop over records and print out a property for each one.
    for (Record record : records) {
      System.out.println(record.getPrice());
    }
  }
}
