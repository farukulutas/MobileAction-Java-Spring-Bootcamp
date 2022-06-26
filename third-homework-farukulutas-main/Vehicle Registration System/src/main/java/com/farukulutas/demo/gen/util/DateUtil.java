package com.farukulutas.demo.gen.util;

import com.farukulutas.demo.gen.enums.GenErrorMessage;
import com.farukulutas.demo.gen.exceptions.GenBusinessException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static Date convertToDate(LocalDate localDate){

        if (localDate == null){
            throw new GenBusinessException(GenErrorMessage.DATE_COULD_NOT_BE_CONVERTED);
        }

        Date date = Date.from(
                localDate.atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        return date;
    }
}
