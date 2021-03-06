package org.cytoscape.task.write;

/*
 * #%L
 * Cytoscape Core Task API (core-task-api)
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2006 - 2013 The Cytoscape Consortium
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

import java.io.File;

import org.cytoscape.task.NetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;

/**
 * This interface provides a task iterator for exporting network views.
 * @CyAPI.Api.Interface
 * @CyAPI.InModule core-task-api
 */
public interface ExportNetworkViewTaskFactory extends NetworkViewTaskFactory{
	
	/**
	 * Creates the task iterator for exporting network views. Notice that this task will be synced with 
	 * the current thread and it will not create a new thread or a new task monitor.
	 * @param view Selected view for export.
	 * @param file The file to store the exported view.
	 * @return Task iterator for running the task.
	 */
	TaskIterator createTaskIterator(CyNetworkView view, File file);

}
