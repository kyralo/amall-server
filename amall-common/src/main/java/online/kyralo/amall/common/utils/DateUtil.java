package online.kyralo.amall.common.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;


/**
 * \* Created with IntelliJ IDEA.
 * \* @author: WangChen
 * \* Date: 19-9-14
 * \* Time: 下午9:26
 * \
 */
@Component
public class DateUtil {

    /**
     * Date类型 转 LocalDate类型
     */
    public static LocalDate uDateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * 计算当前日期与{@code endDate}的间隔天数
     *
     * @param endDate 截止日期
     * @return 间隔天数
     */
    public static long until(LocalDate endDate) {
        return LocalDate.now().until(endDate, ChronoUnit.DAYS);
    }

    /**
     * 计算日期{@code startDate}与{@code endDate}的间隔天数
     *
     * @param startDate 开始日期
     * @param endDate   截止日期
     * @return 间隔天数
     */
    public static long until(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

}
