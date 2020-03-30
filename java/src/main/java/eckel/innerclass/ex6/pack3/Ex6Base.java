package eckel.innerclass.ex6.pack3;

import eckel.innerclass.ex6.pack2.Ex6Interface;

public class Ex6Base {
	protected class Ex6BaseInner implements Ex6Interface {
		// need public constructor to create one in Ex6Base child:
        		public Ex6BaseInner() { }
		public String say() { return "Hi"; }
	}
 }