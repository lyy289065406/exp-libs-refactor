package exp.libs.xls;

import exp.libs.utils.str.StrUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;


/**
 * <PRE>
 * Excel处理工具
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class XlsUtils {

	/** 私有化构造函数 */
	protected XlsUtils() {}
	
	/**
	 * 生成单元格格式.
	 * 	此方法可配合 {@link Sheet#setStyle} 使用
	 * 
	 * @param excel Excel工作簿对象
	 * @param fontName 字体名称, 如: 宋体
	 * @param fontSize 字体大小, 如: (short) 9
	 * @return 单元格格式
	 */
	public static CellStyle getCellStyle(Excel excel, String fontName, short fontSize) {
		return getCellStyle(excel, fontName, fontSize,
				HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex(), true);
	}
	
	/**
	 * 生成单元格格式.
	 * 	此方法可配合 {@link Sheet#setStyle} 使用
	 * 
	 * @param excel Excel工作簿对象
	 * @param bgColor 单元格背景色, 如：HSSFColor.LIGHT_GREEN.index
	 * @return 单元格格式
	 */
	public static CellStyle getCellStyle(Excel excel, short bgColor) {
		return getCellStyle(excel, "", (short) 0, bgColor, true);
	}
	
	/**
	 * 生成单元格格式.
	 * 	此方法可配合 {@link Sheet#setStyle} 使用
	 * 
	 * @param excel Excel工作簿对象
	 * @param alignCenter 是否完全居中(水平+垂直方向居中)
	 * @return 单元格格式
	 */
	public static CellStyle getCellStyle(Excel excel, boolean alignCenter) {
		return getCellStyle(excel, "", (short) 0, 
				HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex(), true);
	}
	
	/**
	 * 生成单元格格式.
	 * 	此方法可配合 {@link Sheet#setStyle} 使用
	 * 
	 * @param excel Excel工作簿对象
	 * @param fontName 字体名称, 如: 宋体
	 * @param fontSize 字体大小, 如: (short) 9
	 * @param bgColor 单元格背景色, 如：HSSFColor.LIGHT_GREEN.index
	 * @param alignCenter 是否完全居中(水平+垂直方向居中)
	 * @return 单元格格式
	 */
	public static CellStyle getCellStyle(Excel excel, 
			String fontName, short fontSize, short bgColor, boolean alignCenter) {
		CellStyle style = excel.createCellStyle();
		
		// 设置字体
		if(StrUtils.isNotEmpty(fontName) && fontSize > 0) {
			Font font = excel.createFont();
			font.setFontName(fontName);
			font.setFontHeightInPoints(fontSize);
			style.setFont(font);
		}
		
		// 设置背景色
		if(HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex() != bgColor) {
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 使用纯色填充单元格
			style.setFillForegroundColor(bgColor);	// 设置单元格填充色
			
		} else {
			style.setFillPattern(FillPatternType.NO_FILL);	// 不填充颜色
		}
		
		// 设置居中
		if(alignCenter == true) {
			style.setAlignment(HorizontalAlignment.CENTER);			// 水平居中
			style.setVerticalAlignment(VerticalAlignment.CENTER);	// 垂直居中
		}
		return style;
	}
}
