public class Clone610 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:46218958
*  Stack Overflow answer #:46219323
*  And Stack Overflow answer#:46231548
*/
public ZonedDateTime parseToZonedDateTime (String date, String dateFormat) {
DateTimeFormatter formatter = DateTimeFormatter.ofPattern (dateFormat);
TemporalAccessor parsed = formatter.parseBest (date, ZonedDateTime :: from, LocalDateTime :: from);
if (parsed instanceof ZonedDateTime) {
}
if (parsed instanceof LocalDateTime) {
}
return null;
}

public ZonedDateTime parseToZonedDateTime (String date, String dateFormat) {
DateTimeFormatter formatter = DateTimeFormatter.ofPattern (dateFormat);
ZonedDateTime zonedDateTime = null;
try {
zonedDateTime = ZonedDateTime.parse (date, formatter);
} catch (DateTimeException e) {
}
}

}