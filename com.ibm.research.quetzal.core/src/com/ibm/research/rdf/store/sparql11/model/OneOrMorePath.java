/******************************************************************************
 * Copyright (c) 2015 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *****************************************************************************/
 package com.ibm.research.rdf.store.sparql11.model;

public  class OneOrMorePath extends UnaryPathOp {

	public OneOrMorePath(Path subPath) {
		super(subPath);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void visit(PathVisitor visitor) {
		visitor.visit(this);
	}
	
	/**
	 *returns whether this path directly contains  a "*" or "+" path modifier.
	 * @return
	 */
	public boolean isDirectlyRecursive() {
		return true;
	}
	@Override
	public <X> X map(PathMapper<X> visitor) {
		return visitor.visit(this);
	}
	

}
