package androidx.compose.material3;

import androidx.compose.material3.CalendarModel;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarModelImpl.android.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0004H\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010'\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\f\u0010*\u001a\u00020 *\u00020\bH\u0002J\f\u0010*\u001a\u00020 *\u00020\u001eH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006,"}, d2 = {"Landroidx/compose/material3/CalendarModelImpl;", "Landroidx/compose/material3/CalendarModel;", "()V", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "today", "Landroidx/compose/material3/CalendarDate;", "getToday", "()Landroidx/compose/material3/CalendarDate;", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "formatWithPattern", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "getCanonicalDate", "timeInMillis", "getDateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "getDayOfWeek", "date", "getMonth", "Landroidx/compose/material3/CalendarMonth;", "firstDayLocalDate", "Ljava/time/LocalDate;", "year", "month", "minusMonths", TypedValues.TransitionType.S_FROM, "subtractedMonthsCount", "parse", "plusMonths", "addedMonthsCount", "toString", "toLocalDate", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CalendarModelImpl implements CalendarModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ZoneId utcTimeZoneId;
    private final int firstDayOfWeek;
    private final List<Pair<String, String>> weekdayNames;

    @Override // androidx.compose.material3.CalendarModel
    public /* synthetic */ String formatWithSkeleton(CalendarDate calendarDate, String str, Locale locale) {
        return CalendarModel.CC.$default$formatWithSkeleton(this, calendarDate, str, locale);
    }

    @Override // androidx.compose.material3.CalendarModel
    public /* synthetic */ String formatWithSkeleton(CalendarMonth calendarMonth, String str, Locale locale) {
        return CalendarModel.CC.$default$formatWithSkeleton(this, calendarMonth, str, locale);
    }

    public CalendarModelImpl() {
        WeekFields of;
        DayOfWeek firstDayOfWeek;
        int value;
        DayOfWeek[] values;
        TextStyle textStyle;
        String displayName;
        TextStyle textStyle2;
        String displayName2;
        of = WeekFields.of(Locale.getDefault());
        firstDayOfWeek = of.getFirstDayOfWeek();
        value = firstDayOfWeek.getValue();
        this.firstDayOfWeek = value;
        Locale locale = Locale.getDefault();
        values = DayOfWeek.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (DayOfWeek dayOfWeek : values) {
            textStyle = TextStyle.FULL;
            displayName = dayOfWeek.getDisplayName(textStyle, locale);
            textStyle2 = TextStyle.NARROW;
            displayName2 = dayOfWeek.getDisplayName(textStyle2, locale);
            arrayList.add(TuplesKt.to(displayName, displayName2));
        }
        this.weekdayNames = arrayList;
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate getToday() {
        LocalDate now;
        int year;
        int monthValue;
        int dayOfMonth;
        LocalTime localTime;
        LocalDateTime atTime;
        ZonedDateTime atZone;
        long epochMilli;
        now = LocalDate.now();
        year = now.getYear();
        monthValue = now.getMonthValue();
        dayOfMonth = now.getDayOfMonth();
        localTime = LocalTime.MIDNIGHT;
        atTime = now.atTime(localTime);
        atZone = atTime.atZone(utcTimeZoneId);
        epochMilli = atZone.toInstant().toEpochMilli();
        return new CalendarDate(year, monthValue, dayOfMonth, epochMilli);
    }

    @Override // androidx.compose.material3.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.CalendarModel
    public List<Pair<String, String>> getWeekdayNames() {
        return this.weekdayNames;
    }

    @Override // androidx.compose.material3.CalendarModel
    public DateInputFormat getDateInputFormat(Locale locale) {
        FormatStyle formatStyle;
        Chronology ofLocale;
        String localizedDateTimePattern;
        Intrinsics.checkNotNullParameter(locale, "locale");
        formatStyle = FormatStyle.SHORT;
        ofLocale = Chronology.ofLocale(locale);
        localizedDateTimePattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(formatStyle, null, ofLocale, locale);
        Intrinsics.checkNotNullExpressionValue(localizedDateTimePattern, "getLocalizedDateTimePatt…= */ locale\n            )");
        return CalendarModelKt.datePatternAsInputFormat(localizedDateTimePattern);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate getCanonicalDate(long timeInMillis) {
        Instant ofEpochMilli;
        ZonedDateTime atZone;
        LocalDate localDate;
        int year;
        int monthValue;
        int dayOfMonth;
        LocalDateTime atStartOfDay;
        ZoneOffset zoneOffset;
        ofEpochMilli = Instant.ofEpochMilli(timeInMillis);
        atZone = ofEpochMilli.atZone(utcTimeZoneId);
        localDate = atZone.toLocalDate();
        year = localDate.getYear();
        monthValue = localDate.getMonthValue();
        dayOfMonth = localDate.getDayOfMonth();
        atStartOfDay = localDate.atStartOfDay();
        zoneOffset = ZoneOffset.UTC;
        return new CalendarDate(year, monthValue, dayOfMonth, atStartOfDay.toEpochSecond(zoneOffset) * 1000);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(long timeInMillis) {
        Instant ofEpochMilli;
        ZonedDateTime atZone;
        ZonedDateTime withDayOfMonth;
        LocalDate localDate;
        ofEpochMilli = Instant.ofEpochMilli(timeInMillis);
        atZone = ofEpochMilli.atZone(utcTimeZoneId);
        withDayOfMonth = atZone.withDayOfMonth(1);
        localDate = withDayOfMonth.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "ofEpochMilli(timeInMilli…           .toLocalDate()");
        return getMonth(localDate);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(CalendarDate date) {
        LocalDate of;
        Intrinsics.checkNotNullParameter(date, "date");
        of = LocalDate.of(date.getYear(), date.getMonth(), 1);
        Intrinsics.checkNotNullExpressionValue(of, "of(date.year, date.month, 1)");
        return getMonth(of);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(int year, int month) {
        LocalDate of;
        of = LocalDate.of(year, month, 1);
        Intrinsics.checkNotNullExpressionValue(of, "of(year, month, 1)");
        return getMonth(of);
    }

    @Override // androidx.compose.material3.CalendarModel
    public int getDayOfWeek(CalendarDate date) {
        DayOfWeek dayOfWeek;
        int value;
        Intrinsics.checkNotNullParameter(date, "date");
        dayOfWeek = toLocalDate(date).getDayOfWeek();
        value = dayOfWeek.getValue();
        return value;
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth plusMonths(CalendarMonth from, int addedMonthsCount) {
        LocalDate laterMonth;
        Intrinsics.checkNotNullParameter(from, "from");
        if (addedMonthsCount <= 0) {
            return from;
        }
        laterMonth = toLocalDate(from).plusMonths(addedMonthsCount);
        Intrinsics.checkNotNullExpressionValue(laterMonth, "laterMonth");
        return getMonth(laterMonth);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth minusMonths(CalendarMonth from, int subtractedMonthsCount) {
        LocalDate earlierMonth;
        Intrinsics.checkNotNullParameter(from, "from");
        if (subtractedMonthsCount <= 0) {
            return from;
        }
        earlierMonth = toLocalDate(from).minusMonths(subtractedMonthsCount);
        Intrinsics.checkNotNullExpressionValue(earlierMonth, "earlierMonth");
        return getMonth(earlierMonth);
    }

    @Override // androidx.compose.material3.CalendarModel
    public String formatWithPattern(long utcTimeMillis, String pattern, Locale locale) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return INSTANCE.formatWithPattern(utcTimeMillis, pattern, locale);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate parse(String date, String pattern) {
        DateTimeFormatter ofPattern;
        LocalDate parse;
        int year;
        Month month;
        int value;
        int dayOfMonth;
        LocalTime localTime;
        LocalDateTime atTime;
        ZonedDateTime atZone;
        long epochMilli;
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        ofPattern = DateTimeFormatter.ofPattern(pattern);
        try {
            parse = LocalDate.parse(date, ofPattern);
            year = parse.getYear();
            month = parse.getMonth();
            value = month.getValue();
            dayOfMonth = parse.getDayOfMonth();
            localTime = LocalTime.MIDNIGHT;
            atTime = parse.atTime(localTime);
            atZone = atTime.atZone(utcTimeZoneId);
            epochMilli = atZone.toInstant().toEpochMilli();
            return new CalendarDate(year, value, dayOfMonth, epochMilli);
        } catch (DateTimeParseException unused) {
            return null;
        }
    }

    public String toString() {
        return "CalendarModel";
    }

    /* compiled from: CalendarModelImpl.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/CalendarModelImpl$Companion;", "", "()V", "utcTimeZoneId", "Ljava/time/ZoneId;", "getUtcTimeZoneId$material3_release", "()Ljava/time/ZoneId;", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String formatWithPattern(long utcTimeMillis, String pattern, Locale locale) {
            DateTimeFormatter ofPattern;
            DecimalStyle of;
            DateTimeFormatter withDecimalStyle;
            Instant ofEpochMilli;
            ZonedDateTime atZone;
            LocalDate localDate;
            String format;
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(locale, "locale");
            ofPattern = DateTimeFormatter.ofPattern(pattern, locale);
            of = DecimalStyle.of(locale);
            withDecimalStyle = ofPattern.withDecimalStyle(of);
            Intrinsics.checkNotNullExpressionValue(withDecimalStyle, "ofPattern(pattern, local…(DecimalStyle.of(locale))");
            ofEpochMilli = Instant.ofEpochMilli(utcTimeMillis);
            atZone = ofEpochMilli.atZone(getUtcTimeZoneId$material3_release());
            localDate = atZone.toLocalDate();
            format = localDate.format(withDecimalStyle);
            Intrinsics.checkNotNullExpressionValue(format, "ofEpochMilli(utcTimeMill…       .format(formatter)");
            return format;
        }

        public final ZoneId getUtcTimeZoneId$material3_release() {
            return CalendarModelImpl.utcTimeZoneId;
        }
    }

    static {
        ZoneId of;
        of = ZoneId.of("UTC");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"UTC\")");
        utcTimeZoneId = of;
    }

    private final CalendarMonth getMonth(LocalDate firstDayLocalDate) {
        DayOfWeek dayOfWeek;
        int value;
        LocalTime localTime;
        LocalDateTime atTime;
        ZonedDateTime atZone;
        long epochMilli;
        int year;
        int monthValue;
        int lengthOfMonth;
        dayOfWeek = firstDayLocalDate.getDayOfWeek();
        value = dayOfWeek.getValue();
        int firstDayOfWeek = value - getFirstDayOfWeek();
        if (firstDayOfWeek < 0) {
            firstDayOfWeek += 7;
        }
        int i = firstDayOfWeek;
        localTime = LocalTime.MIDNIGHT;
        atTime = firstDayLocalDate.atTime(localTime);
        atZone = atTime.atZone(utcTimeZoneId);
        epochMilli = atZone.toInstant().toEpochMilli();
        year = firstDayLocalDate.getYear();
        monthValue = firstDayLocalDate.getMonthValue();
        lengthOfMonth = firstDayLocalDate.lengthOfMonth();
        return new CalendarMonth(year, monthValue, lengthOfMonth, i, epochMilli);
    }

    private final LocalDate toLocalDate(CalendarMonth calendarMonth) {
        Instant ofEpochMilli;
        ZonedDateTime atZone;
        LocalDate localDate;
        ofEpochMilli = Instant.ofEpochMilli(calendarMonth.getStartUtcTimeMillis());
        atZone = ofEpochMilli.atZone(utcTimeZoneId);
        localDate = atZone.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "ofEpochMilli(startUtcTim…TimeZoneId).toLocalDate()");
        return localDate;
    }

    private final LocalDate toLocalDate(CalendarDate calendarDate) {
        LocalDate of;
        of = LocalDate.of(calendarDate.getYear(), calendarDate.getMonth(), calendarDate.getDayOfMonth());
        Intrinsics.checkNotNullExpressionValue(of, "of(\n            this.yea…this.dayOfMonth\n        )");
        return of;
    }
}
