package br.com.caelum.seleniumdsl.table.layout;

import br.com.caelum.seleniumdsl.table.Table;

import com.thoughtworks.selenium.Selenium;

public class FullTableLayout implements TableLayout {

	private final TableLayoutHelper helper;

	public FullTableLayout(Selenium selenium, String id, String type) {
		helper = new TableLayoutHelper(selenium, id, type);
	}

	public int getContentCount() {
		return helper.countXPath("/tbody/tr");
	}

	public int getColCount() {
		return helper.countXPath("/thead/tr/th");
	}

	public String headerValue(int col) {
		return helper.getXPathText("/thead/tr[1]/th[" + col + "]");
	}

	public String headerLinkValue(int col) {
		return helper.getXPathText("/thead/tr[1]/th[" + col + "]/a/text()");
	}

	public String value(int row, int col) {
		return helper.getXPathText("/tbody/tr[" + row + "]/td[" + col + "]");
	}

	public int getRowCount() {
		return helper.getRowCount();
	}

	public boolean contains(Table table, String col, String content) {
		return helper.contains(table, col, content);
	}
}
