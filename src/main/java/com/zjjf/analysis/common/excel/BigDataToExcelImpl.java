package com.zjjf.analysis.common.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.util.HtmlUtils;



/**
 * 用于excel大数据量导出
 * 
 * @author lisen
 * @date 2013-10-30 上午10:41:36
 */
public class BigDataToExcelImpl extends AbstractExportBigData implements ExportBigData {

	StringBuffer headStr = new StringBuffer(
			"<html xmlns:x=\"urn:schemas-microsoft-com:office:excel\">").append("<head>").append(
			"<meta http-equiv=\"content-type\" content=\"application/ms-excel; charset=UTF-8\"/>")
			.append("<!--[if gte mso 9]><xml>").append("<x:ExcelWorkbook>").append(
					"<x:ExcelWorksheets>").append("<x:ExcelWorksheet>").append("<x:Name></x:Name>")
			.append("<x:WorksheetOptions>").append("<x:Print>").append("<x:ValidPrinterInfo />")
			.append("</x:Print>").append("</x:WorksheetOptions>").append("</x:ExcelWorksheet>")
			.append("</x:ExcelWorksheets>").append("</x:ExcelWorkbook>").append(
					"</xml><![endif]-->").append("<style>").append("<!--table").append(
					"{mso-displayed-decimal-separator:'\\.';").append(
					"mso-displayed-thousand-separator:'\\,';}").append(".xl27").append(
					"{mso-style-parent:style0;").append("font-size:10.0pt;").append(
					"font-family:'Arial Unicode MS', sans-serif;").append("mso-font-charset:0;")
			.append("mso-number-format:'\\@';").append("white-space:normal;}").append("</style>")
			.append("</head>").append("<body>").append("<table>");

	StringBuffer footStr = new StringBuffer("</table></body></html>");

	public BigDataToExcelImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
		super.setPrefix("dataAnalysis");
		super.setSuffix(".xls");
	}

	/**
	 * 文件开头的写入
	 * 
	 * @param fos
	 * @throws IOException
	 */
	protected void writeHeaderToOutputStream(FileOutputStream fos) throws IOException {
		writeToOutputStream(headStr.toString(), fos);
	}

	/**
	 * 文件结尾的写入
	 * 
	 * @param fos
	 */
	protected void writeFooterToOutputStream(FileOutputStream fos) throws IOException {
		writeToOutputStream(footStr.toString(), fos);
	}

	/**
	 * 一行数据的写入
	 * 
	 * @param rs
	 * @param fos
	 * @throws SQLException
	 * @throws IOException
	 */
	protected void writeOneRowToOutputStream(ResultSet rs, FileOutputStream fos)
			throws SQLException, IOException {
		// 获取metaData;
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		writeToOutputStream("<tr>", fos);
		for (int i = 1; i <= columnCount; i++) {
			// String key = getColumnKey(rsmd.getColumnName(i));
			Object obj = getColumnValue(rs, i);
			writeToOutputStream("<td class=xl27>"
					+ (obj == null ? "" : HtmlUtils.htmlEscape(obj == null ? "" : obj.toString()))
					+ "</td>", fos);
		}
		writeToOutputStream("</tr>", fos);
	}

	protected void fileOutputStreamStatus(List<FileOutputStream> foList) throws IOException {
		System.out.println("共有文件输出流：" + foList.size());
		for (FileOutputStream fo : foList) {
			System.out.println("文件输出流："
					+ (fo == null ? "已清空" : fo.toString() + " : " + (fo.getFD().valid())));
		}
	}

	@Override
	protected void writeTitleToOutputStream(Collection<String> titles, FileOutputStream fos)
			throws IOException {
		if (titles != null && titles.size() > 0) {
			writeToOutputStream("<tr>", fos);
			for (String title : titles) {
				writeToOutputStream("<td class=xl27><b>"
						+ (title == null ? "" : HtmlUtils.htmlEscape(title)) + "</b></td>", fos);
			}
			writeToOutputStream("</tr>", fos);
		}
	}

}
