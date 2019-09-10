package com.ita.logisim.ttl;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import com.bfh.logisim.designrulecheck.Netlist;
import com.bfh.logisim.designrulecheck.NetlistComponent;
import com.bfh.logisim.fpgagui.FPGAReport;
import com.bfh.logisim.hdlgenerator.AbstractHDLGeneratorFactory;
import com.bfh.logisim.hdlgenerator.HDLGeneratorFactory;
import com.cburch.logisim.data.AttributeSet;

public class Ttl7442HDLGenerator extends AbstractHDLGeneratorFactory {
	
	private boolean IsExes3 = false;
	private boolean IsGray = false;
	
	public Ttl7442HDLGenerator() {
		super();
	}

	public Ttl7442HDLGenerator(boolean Exess3, boolean Gray) {
		super();
		IsExes3 = Exess3;
		IsGray = Gray;
	}

	@Override
	public String getComponentStringIdentifier() {
		return "TTL";
	}
	
	@Override
	public SortedMap<String, Integer> GetInputList(Netlist TheNetlist,
			AttributeSet attrs) {
		SortedMap<String, Integer> MyInputs = new TreeMap<String, Integer>();
		MyInputs.put("A", 1);
		MyInputs.put("B", 1);
		MyInputs.put("C", 1);
		MyInputs.put("D", 1);
		return MyInputs;
	}

	@Override
	public SortedMap<String, Integer> GetOutputList(Netlist TheNetlist,
			AttributeSet attrs) {
		SortedMap<String, Integer> MyOutputs = new TreeMap<String, Integer>();
		MyOutputs.put("O0", 1);
		MyOutputs.put("O1", 1);
		MyOutputs.put("O2", 1);
		MyOutputs.put("O3", 1);
		MyOutputs.put("O4", 1);
		MyOutputs.put("O5", 1);
		MyOutputs.put("O6", 1);
		MyOutputs.put("O7", 1);
		MyOutputs.put("O8", 1);
		MyOutputs.put("O9", 1);
		return MyOutputs;
	}

	@Override
	public ArrayList<String> GetModuleFunctionality(Netlist TheNetlist,
			AttributeSet attrs, FPGAReport Reporter, String HDLType) {
		ArrayList<String> Contents = new ArrayList<String>();
		if (IsExes3) {
			Contents.add("   O0 <= NOT (NOT(D) AND NOT(C) AND     B  AND     A );");
			Contents.add("   O1 <= NOT (NOT(D) AND     C  AND NOT(B) AND NOT(A));");
			Contents.add("   O2 <= NOT (NOT(D) AND     C  AND NOT(B) AND     A );");
			Contents.add("   O3 <= NOT (NOT(D) AND     C  AND     B  AND NOT(A));");
			Contents.add("   O4 <= NOT (NOT(D) AND     C  AND     B  AND     A );");
			Contents.add("   O5 <= NOT (    D  AND NOT(C) AND NOT(B) AND NOT(A));");
			Contents.add("   O6 <= NOT (    D  AND NOT(C) AND NOT(B) AND     A );");
			Contents.add("   O7 <= NOT (    D  AND NOT(C) AND     B  AND NOT(A));");
			Contents.add("   O8 <= NOT (    D  AND NOT(C) AND     B  AND     A );");
			Contents.add("   O9 <= NOT (    D  AND     C  AND NOT(B) AND NOT(A));");
		} else if (IsGray) {
			Contents.add("   O0 <= NOT (NOT(D) AND NOT(C) AND     B  AND NOT(A));");
			Contents.add("   O1 <= NOT (NOT(D) AND     C  AND     B  AND NOT(A));");
			Contents.add("   O2 <= NOT (NOT(D) AND     C  AND     B  AND     A );");
			Contents.add("   O3 <= NOT (NOT(D) AND     C  AND NOT(B) AND     A );");
			Contents.add("   O4 <= NOT (NOT(D) AND     C  AND NOT(B) AND NOT(A));");
			Contents.add("   O5 <= NOT (    D  AND     C  AND NOT(B) AND NOT(A));");
			Contents.add("   O6 <= NOT (    D  AND     C  AND NOT(B) AND     A );");
			Contents.add("   O7 <= NOT (    D  AND     C  AND     B  AND     A );");
			Contents.add("   O8 <= NOT (    D  AND     C  AND     B  AND NOT(A));");
			Contents.add("   O9 <= NOT (    D  AND NOT(C) AND     B  AND NOT(A));");
		} else {
			Contents.add("   O0 <= NOT (NOT(D) AND NOT(C) AND NOT(B) AND NOT(A));");
			Contents.add("   O1 <= NOT (NOT(D) AND NOT(C) AND NOT(B) AND     A );");
			Contents.add("   O2 <= NOT (NOT(D) AND NOT(C) AND     B  AND NOT(A));");
			Contents.add("   O3 <= NOT (NOT(D) AND NOT(C) AND     B  AND     A );");
			Contents.add("   O4 <= NOT (NOT(D) AND     C  AND NOT(B) AND NOT(A));");
			Contents.add("   O5 <= NOT (NOT(D) AND     C  AND NOT(B) AND     A );");
			Contents.add("   O6 <= NOT (NOT(D) AND     C  AND     B  AND NOT(A));");
			Contents.add("   O7 <= NOT (NOT(D) AND     C  AND     B  AND     A );");
			Contents.add("   O8 <= NOT (    D  AND NOT(C) AND NOT(B) AND NOT(A));");
			Contents.add("   O9 <= NOT (    D  AND NOT(C) AND NOT(B) AND     A );");
		}
		return Contents;
	}

	@Override
	public SortedMap<String, String> GetPortMap(Netlist Nets,
			NetlistComponent ComponentInfo, FPGAReport Reporter, String HDLType) {
		SortedMap<String, String> PortMap = new TreeMap<String, String>();
		PortMap.putAll(GetNetMap("A",true,ComponentInfo,13,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("B",true,ComponentInfo,12,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("C",true,ComponentInfo,11,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("D",true,ComponentInfo,10,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O0",true,ComponentInfo,0,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O1",true,ComponentInfo,1,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O2",true,ComponentInfo,2,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O3",true,ComponentInfo,3,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O4",true,ComponentInfo,4,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O5",true,ComponentInfo,5,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O6",true,ComponentInfo,6,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O7",true,ComponentInfo,7,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O8",true,ComponentInfo,8,Reporter,HDLType,Nets));
		PortMap.putAll(GetNetMap("O9",true,ComponentInfo,9,Reporter,HDLType,Nets));
		return PortMap;
	}
	
	@Override
	public String GetSubDir() {
		/*
		 * this method returns the module directory where the HDL code needs to
		 * be placed
		 */
		return "ttl";
	}

	@Override
	public boolean HDLTargetSupported(String HDLType, AttributeSet attrs) {
		/* TODO: Add support for the ones with VCC and Ground Pin */
		if (attrs==null)
			return false;
		return (!attrs.getValue(TTL.VCC_GND)&&(HDLType.equals(HDLGeneratorFactory.VHDL)));
	}
}
