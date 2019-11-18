package com.anz.rpncalculator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import com.anz.rpncalculator.util.NumberUtils;

/**
 * Model/Bean to manage RPN stack details and original list of commands.
 *
 */
public class RpnStack implements Serializable {

	private static final long serialVersionUID = 523235L;

	private final Deque<BigDecimal> rpnDeque;
	private final List<String> rpnCommandList;
	private List<String> currentLineCommandList;
	private int position = 0;

	public RpnStack() {
		this.rpnDeque = new ArrayDeque<>();
		this.rpnCommandList = new ArrayList<>();
		this.currentLineCommandList = new ArrayList<>();
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getRpnStackSize() {
		return rpnDeque.size();
	}

	public boolean isRpnStackEmpty() {
		return rpnDeque.isEmpty();
	}

	public List<String> getReadOnlyCommandList() {
		List<String> readOnlyList = new ArrayList<>();
		for (String str : rpnCommandList) {
			readOnlyList.add(str);
		}

		return readOnlyList;
	}

	public List<String> getCurrentLineCommandList() {
		return this.currentLineCommandList;
	}

	public void setCurrentLineCommandList(List<String> list) {
		this.currentLineCommandList = list;
	}

	public boolean addAll(List<String> newCommandList) {
		return this.rpnCommandList.addAll(newCommandList);
	}

	public String removeLastCommand(int index) {
		return this.rpnCommandList.remove(index);
	}

	public void push(BigDecimal number) {
		rpnDeque.push(number);
	}

	public BigDecimal pop() {
		return rpnDeque.pop();
	}

	public void clearStack() {
		rpnDeque.clear();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Iterator<BigDecimal> iter = this.rpnDeque.descendingIterator();
		while (iter.hasNext()) {
			sb.append(NumberUtils.convertBeforePrintingStack(iter.next()) + " ");
		}

		return sb.toString();
	}
}
