/*******************************************************************************
 * This file is part of logisim-evolution.
 *
 *   logisim-evolution is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   logisim-evolution is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   Original code by Carl Burch (http://www.cburch.com), 2011.
 *   Subsequent modifications by :
 *     + Haute École Spécialisée Bernoise
 *       http://www.bfh.ch
 *     + Haute École du paysage, d'ingénierie et d'architecture de Genève
 *       http://hepia.hesge.ch/
 *     + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 *       http://www.heig-vd.ch/
 *   The project is currently maintained by :
 *     + REDS Institute - HEIG-VD
 *       Yverdon-les-Bains, Switzerland
 *       http://reds.heig-vd.ch
 *******************************************************************************/

package com.bfh.logisim.designrulecheck;

import java.util.ArrayList;

public class ClockTreeContainer {

	private ArrayList<ConnectionPoint> ClockSources;
	private ArrayList<ConnectionPoint> ClockNets;
	private int ClockSourceId;
	private ArrayList<String> HierarchyId;

	public ClockTreeContainer(ArrayList<String> Hierarchy, int sourceId) {
		ClockSources = new ArrayList<ConnectionPoint>();
		ClockNets = new ArrayList<ConnectionPoint>();
		ClockSourceId = sourceId;
		HierarchyId = new ArrayList<String>();
		HierarchyId.addAll(Hierarchy);
	}

	public void addNet(ConnectionPoint NetInfo) {
		ClockNets.add(NetInfo);
	}

	public void addSource(ConnectionPoint NetInfo) {
		ClockSources.add(NetInfo);
	}

	public void clear() {
		ClockSources.clear();
		ClockNets.clear();
	}

	public boolean equals(ArrayList<String> Hierarchy, int sourceId) {
		return ((sourceId == ClockSourceId) && HierarchyId.equals(Hierarchy));
	}

	public ArrayList<Byte> GetClockEntries(Net NetInfo) {
		ArrayList<Byte> result = new ArrayList<Byte>();
		for (ConnectionPoint SolderPoint : ClockSources) {
			if (SolderPoint.GetParrentNet().equals(NetInfo))
				result.add(SolderPoint.GetParrentNetBitIndex());
		}
		for (ConnectionPoint SolderPoint : ClockNets) {
			if (SolderPoint.GetParrentNet().equals(NetInfo))
				result.add(SolderPoint.GetParrentNetBitIndex());
		}
		return result;
	}

	public boolean NetContainsClockConnection(Net NetInfo) {
		for (ConnectionPoint SolderPoint : ClockSources) {
			if (SolderPoint.GetParrentNet().equals(NetInfo))
				return true;
		}
		for (ConnectionPoint SolderPoint : ClockNets) {
			if (SolderPoint.GetParrentNet().equals(NetInfo))
				return true;
		}
		return false;
	}

	public boolean NetContainsClockSource(Net NetInfo) {
		for (ConnectionPoint SolderPoint : ClockSources) {
			if (SolderPoint.GetParrentNet().equals(NetInfo))
				return true;
		}
		return false;
	}

	public int NrOfSources() {
		return ClockSources.size();
	}
}
