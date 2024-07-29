import java.time.LocalDate
import java.time.format.DateTimeParseException

fun String?.toLocalDate(): LocalDate? {
    return try {
        this?.let { LocalDate.parse(it) }
    } catch (e: DateTimeParseException) {
        null
    }
}
