package fiuba.algo3.vista;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitarJTextField extends PlainDocument {

	private int limite;

	public LimitarJTextField(int limite) {
		super();
		this.limite = limite;

	}
	
	public void insertString(int compensacion, String str, AttributeSet attr) throws BadLocationException{
		if (str == null) return;
		if ((getLength()+str.length()) <= this.limite){
			super.insertString(compensacion, str, attr);
		}
	}
}
