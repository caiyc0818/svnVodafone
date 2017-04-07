package com.huawei.vodafone.ui.myview.datepicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ParseException;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.huawei.vodafone.R;
import com.huawei.vodafone.ui.myview.datepicker.ScrollerNumberPicker.OnSelectListener;
import com.huawei.vodafone.util.CalendarUtil;
import com.huawei.vodafone.util.DateUtil;

/**
 * 日期选择控件
 * 
 * @author suzhenpeng
 * 
 */
public class DatePickerTwo extends LinearLayout {
	/** 滑动控件 */
	private ScrollerNumberPicker yearPicker;

	private ScrollerNumberPicker monthPicker;

	/** 日历 */
	private CalendarUtil calendarUtil = CalendarUtil.getSingleton();

	/** 日历 */
	public Calendar calendar;

	/** 临时日期 */
	private int tempYearIndex = -1;

	private int tempMonthIndex = -1;

	/** 选择监听 */
	private OnSelectingListener onSelectingListener;

	/** 刷新界面 */
	private static final int REFRESH_VIEW = 0x001;

	public DatePickerTwo(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public DatePickerTwo(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
		LayoutInflater.from(getContext()).inflate(R.layout.su_date_picker_two,
				this);
		// 初始化日历
		calendar = Calendar.getInstance();
		calendarUtil = CalendarUtil.getSingleton();
		// 获取控件引用
		yearPicker = (ScrollerNumberPicker) findViewById(R.id.year);
		monthPicker = (ScrollerNumberPicker) findViewById(R.id.month);
		// 获取当前年月日
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		// 设置数据
		yearPicker.setData(calendarUtil.getYears());
		monthPicker.setData(calendarUtil.getMonths());
		// 设置默认值为当前
		yearPicker.setDefault(y - 1970);
		monthPicker.setDefault(m);

		yearPicker.setOnSelectListener(new OnSelectListener() {

			@Override
			public void endSelect(int id, String text) {
				// TODO Auto-generated method stub
				if (text == null || text.equals(""))
					return;
				if (tempYearIndex != id) {
					String selectMonth = monthPicker.getSelectedText();
					if (selectMonth == null || selectMonth.equals(""))
						return;
				}
				tempYearIndex = id;
				Message message = new Message();
				message.what = REFRESH_VIEW;
				handler.sendMessage(message);

			}

			@Override
			public void selecting(int id, String text) {
				// TODO Auto-generated method stub

			}
		});

		monthPicker.setOnSelectListener(new OnSelectListener() {

			@Override
			public void endSelect(int id, String text) {
				// TODO Auto-generated method stub
				if (text.equals("") || text == null)
					return;
				if (tempMonthIndex != id) {

					String selectYear = yearPicker.getSelectedText();
					if (selectYear == null || selectYear.equals(""))
						return;
				}
				tempMonthIndex = id;
				Message message = new Message();
				message.what = REFRESH_VIEW;
				handler.sendMessage(message);
			}

			@Override
			public void selecting(int id, String text) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void setTime(long time) {
		setDate(new Date(time));
	}

	public void setDate(Date date) {
		int year;
		if (date.getYear() < 70) {
			year = (70 + 1900);
		} else {
			year = (date.getYear() + 1900);
		}
		String a = DateUtil.ConverToString(date, "yyyyMMdd");
		setTime(Integer.valueOf(a.substring(0, 4)),
				Integer.valueOf(a.substring(4, 6)),
				Integer.valueOf(a.substring(6, 8)));
	}

	public void setTime(int year, int month, int day) {
		if (month > 12)
			return;
		if (day > 31)
			return;
		if (month <= 0 || year <= 0 || day <= 0)
			return;

		// 设置数据
		yearPicker.setData(calendarUtil.getYears());
		monthPicker.setData(calendarUtil.getMonths());
		// 设置默认值为当前
		yearPicker.setDefault(year - 1970);
		monthPicker.setDefault(month - 1);
	}

	/**
	 * 获取时间
	 * 
	 * @return
	 */
	public Date getDate() {
		String timeString = yearPicker.getSelectedText() + "-"
				+ monthPicker.getSelectedText();
		Date date = new Date(Long.valueOf(formatToTime(timeString, "yyyy-MM")));
		return date;
	}

	/**
	 * 获取时间戳
	 * 
	 * @return
	 */
	public long getTime() {
		return getDate().getTime();
	}

	public int getYear() {
		return Integer.valueOf(yearPicker.getSelectedText());
	}

	public int getMonth() {
		return Integer.valueOf(monthPicker.getSelectedText());
	}

	public String getFormaTime() {
		return (yearPicker.getSelectedText() + "-" + monthPicker
				.getSelectedText());
	}

	public String getFormatTime(String format) {
		return getFormatTime(getTime(), format);
	}

	public void setOnSelectingListener(OnSelectingListener onSelectingListener) {
		this.onSelectingListener = onSelectingListener;
	}

	/**
	 * 从格式化时间获取time
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String formatToTime(String time, String format) {
		Date date = null;
		SimpleDateFormat formatTime = new SimpleDateFormat(format, Locale.CHINA);
		try {
			try {
				date = formatTime.parse(time);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(date.getTime());
	}

	/**
	 * 返回指定格式时间
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String getFormatTime(long time, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.CHINA);
		return dateFormat.format(time);
	}

	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case REFRESH_VIEW:
				if (onSelectingListener != null)
					onSelectingListener.selected(true);
				break;
			default:
				break;
			}
		}

	};

}
