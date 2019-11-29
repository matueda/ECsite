package com.internousdev.ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
		public String getDate(){
					//日時などのデートを定義
			Date date=new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			return simpleDateFormat.format(date);
		}

}
