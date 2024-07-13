### DateUtil 方法概要

| 限定符和类型              | 方法和说明                                                   |
| :------------------------ | :----------------------------------------------------------- |
| `static java.util.Date`   | `addDay(java.util.Date date, int dayAmount)`增加日期的天数。 |
| `static java.lang.String` | `addDay(java.lang.String date, int dayAmount)`增加日期的天数。 |
| `static java.util.Date`   | `addHour(java.util.Date date, int hourAmount)`增加日期的小时。 |
| `static java.lang.String` | `addHour(java.lang.String date, int hourAmount)`增加日期的小时。 |
| `static java.util.Date`   | `addMinute(java.util.Date date, int minuteAmount)`增加日期的分钟。 |
| `static java.lang.String` | `addMinute(java.lang.String date, int minuteAmount)`增加日期的分钟。 |
| `static java.util.Date`   | `addMonth(java.util.Date date, int monthAmount)`增加日期的月份。 |
| `static java.lang.String` | `addMonth(java.lang.String date, int monthAmount)`增加日期的月份。 |
| `static java.util.Date`   | `addSecond(java.util.Date date, int secondAmount)`增加日期的秒钟。 |
| `static java.lang.String` | `addSecond(java.lang.String date, int secondAmount)`增加日期的秒钟。 |
| `static java.util.Date`   | `addYear(java.util.Date date, int yearAmount)`增加日期的年份。 |
| `static java.lang.String` | `addYear(java.lang.String date, int yearAmount)`增加日期的年份。 |
| `static int`              | `compareTwoTimeDifferHour(java.util.Date newTime, java.util.Date compareTime)`比较两个时间相差多少小时 |
| `static java.lang.String` | `dateToString(java.util.Date date, DateStyle dateStyle)`将日期转化为日期字符串。 |
| `static java.lang.String` | `dateToString(java.util.Date date, java.lang.String pattern)`将日期转化为日期字符串。 |
| `static java.lang.String` | `getAge(java.util.Date date, java.util.Date otherDate)`获取期间的年龄 |
| `static java.lang.String` | `getDate(java.util.Date date)`获取日期。                     |
| `static java.lang.String` | `getDate(java.util.Date date, DateStyle style)`              |
| `static java.lang.String` | `getDate(java.lang.String date)`获取日期 。                  |
| `static DateStyle`        | `getDateStyle(java.lang.String date)`获取日期字符串的日期风格。 |
| `static java.lang.String` | `getDateTime(java.util.Date date)`获取日期的时间。           |
| `static java.lang.String` | `getDateTime(java.lang.String date)`获取日期的时间。         |
| `static int`              | `getDay(java.util.Date date)`获取日期的天数。                |
| `static int`              | `getDay(java.lang.String date)`获取日期的天数。              |
| `static double`           | `getDecHourMinute(java.util.Date date)`获取当前时间十进制（小时和分钟） |
| `static double`           | `getDecHourMinute(java.lang.String date)`把 4:30 转成十进制的小时和分钟 |
| `static int`              | `getHour(java.util.Date date)`获取日期的小时。               |
| `static int`              | `getHour(java.lang.String date)`获取日期的小时。             |
| `static double`           | `getHourMinute(java.util.Date date)`获取当前小时分钟 例如：14.23-14点23分 |
| `static int`              | `getIntervalDays(java.util.Date date, java.util.Date otherDate)` |
| `static int`              | `getIntervalDays(java.lang.String date, java.lang.String otherDate)`获取两个日期相差的天数 |
| `static int`              | `getMinute(java.util.Date date)`获取日期的分钟。             |
| `static int`              | `getMinute(java.lang.String date)`获取日期的分钟。           |
| `static int`              | `getMonth(java.util.Date date)`获取日期的月份。              |
| `static int`              | `getMonth(java.lang.String date)`获取日期的月份。            |
| `static int`              | `getMonthSpace(java.lang.String date1, java.lang.String date2)`计算两个日期相差了几个月 |
| `static long`             | `getNowDayHoursTime(double hour)`获取当天某个整点的时间戳    |
| `static long`             | `getPreviousDayHoursTime(double hour)`获取前一天某个整点的时间戳 |
| `static int`              | `getSecond(java.util.Date date)`获取日期的秒钟。             |
| `static int`              | `getSecond(java.lang.String date)`获取日期的秒钟。           |
| `static java.lang.String` | `getTime(java.util.Date date)`获取日期的时间。               |
| `static java.lang.String` | `getTime(java.lang.String date)`获取日期的时间。             |
| `static long`             | `getTodayStartTime()`获取凌晨0点整时间戳                     |
| `static Week`             | `getWeek(java.util.Date date)`获取日期的星期。               |
| `static Week`             | `getWeek(java.lang.String date)`获取日期的星期。             |
| `static int`              | `getYear(java.util.Date date)`获取日期的年份。               |
| `static int`              | `getYear(java.lang.String date)`获取日期的年份。             |
| `static boolean`          | `isDate(java.lang.String date)`判断字符串是否为日期字符串    |
| `static boolean`          | `isEffectiveDate(java.util.Date nowTime, java.util.Date startTime, java.util.Date endTime)`判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致 |
| `static boolean`          | `isFirstDayOfMonth(java.util.Date date)`判断该日期是否是该月的第一天 |
| `static boolean`          | `isInTimeSection(double startTimeD, double endTimeD)`判断当前时间是否在给定的时间范围 |
| `static boolean`          | `isInTimeSection(java.lang.String start, java.lang.String end)` |
| `static boolean`          | `isLastDayOfMonth(java.util.Date date)`判断该日期是否是该月的最后一天 |
| `static java.util.Date`   | `stringToDate(java.lang.String date)`将日期字符串转化为日期。 |
| `static java.util.Date`   | `stringToDate(java.lang.String date, DateStyle dateStyle)`将日期字符串转化为日期。 |
| `static java.util.Date`   | `stringToDate(java.lang.String date, java.lang.String pattern)`将日期字符串转化为日期。 |
| `static java.lang.String` | `stringToString(java.lang.String date, DateStyle newDateStyle)`将日期字符串转化为另一日期字符串。 |
| `static java.lang.String` | `stringToString(java.lang.String date, DateStyle olddDteStyle, DateStyle newDateStyle)`将日期字符串转化为另一日期字符串。 |
| `static java.lang.String` | `stringToString(java.lang.String date, DateStyle olddDteStyle, java.lang.String newParttern)`将日期字符串转化为另一日期字符串。 |
| `static java.lang.String` | `stringToString(java.lang.String date, java.lang.String newPattern)`将日期字符串转化为另一日期字符串。 |
| `static java.lang.String` | `stringToString(java.lang.String date, java.lang.String olddPattern, DateStyle newDateStyle)`将日期字符串转化为另一日期字符串。 |
| `static java.lang.String` | `stringToString(java.lang.String date, java.lang.String olddPattern, java.lang.String newPattern)`将日期字符串转化为另一日期字符串。 |

