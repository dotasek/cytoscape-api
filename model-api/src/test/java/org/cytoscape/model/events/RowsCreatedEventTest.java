package org.cytoscape.model.events;

/*
 * #%L
 * Cytoscape Model API (model-api)
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2008 - 2013 The Cytoscape Consortium
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */


import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import org.cytoscape.model.CyTable;

import static org.mockito.Mockito.*;


public class RowsCreatedEventTest {
	RowsCreatedEvent event;
	Collection<Object> pkCollection;
	CyTable table;

	@Before
	public void setUp() {
		pkCollection = new ArrayList<Object>();
		pkCollection.add( Long.valueOf(1) );
		pkCollection.add( Long.valueOf(2) );

		table = mock(CyTable.class);
		event = new RowsCreatedEvent(table,pkCollection);
	}

	@Test
	public void testGetNode() {
		for ( Object n : event.getPayloadCollection() )
			assertTrue( pkCollection.contains(n));
	}

	@Test
	public void testGetSource() {
		assertEquals( event.getSource(), table );
	}

	@Test
	public void testGetListenerClass() {
		assertEquals( event.getListenerClass(), RowsCreatedListener.class );
	}

	@Test(expected=NullPointerException.class)
	public void testNullNode() {
		RowsCreatedEvent ev = new RowsCreatedEvent(table, null);
	}

	@Test(expected=NullPointerException.class)
	public void testNullTable() {
		RowsCreatedEvent ev = new RowsCreatedEvent(null, pkCollection);
	}
}
